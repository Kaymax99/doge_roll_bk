package com.doge_roll.auth.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doge_roll.auth.entity.ERole;
import com.doge_roll.auth.entity.Role;
import com.doge_roll.auth.entity.User;
import com.doge_roll.auth.exception.MyAPIException;
import com.doge_roll.auth.payload.LoginDto;
import com.doge_roll.auth.payload.RegisterDto;
import com.doge_roll.auth.repository.RoleRepository;
import com.doge_roll.auth.repository.UserRepository;
import com.doge_roll.auth.security.JwtTokenProvider;

import jakarta.persistence.EntityExistsException;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        
    	Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(
        				loginDto.getUsername(), loginDto.getPassword()
        		)
        ); 
    	
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {

        // check if username exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username already registered!");
        }

        // check if email exists in database
		if(userRepository.existsByEmail(registerDto.getEmail())){ 
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "Email already registered!");
		}
        
        User user = new User();
        user.setName(registerDto.getName());
        user.setSurname(registerDto.getSurname());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRegistrationDate(LocalDate.now());

        Set<Role> roles = new HashSet<>();
        

//        if(registerDto.getRoles() != null) {
//	        registerDto.getRoles().forEach(role -> {
//	        	Role userRole = roleRepository.findByRoleName(getRole(role)).get();
//	        	roles.add(userRole);
//	        });
//        } else {
        	Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER).get();
        	roles.add(userRole);
//        }
        
        user.setRoles(roles);
        System.out.println(user);
        userRepository.save(user);

        return "User registered successfully!.";
    }
    
    public ERole getRole(String role) {
    	if(role.equals("ROLE_ADMIN")) return ERole.ROLE_ADMIN;
    	else return ERole.ROLE_USER;
    }
    
    public User getUserByUsername(String username) {
    	if(!userRepository.existsByUsername(username)){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "No user found with given username.");
        } else {
        	return userRepository.findByUsername(username).get();
        }
    	
    }
    
    public User getUserById (Long id) {
    	if (!userRepository.existsById(id)) {
    		throw new MyAPIException(HttpStatus.BAD_REQUEST, "No user found with given id.");
    	} else {
    		return userRepository.findById(id).get();
    	}
    }
    
    public User updateUser(User user) {
    	if (!userRepository.existsById(user.getId())) {
    		throw new EntityExistsException("No User found with given ID");
    	}
    	userRepository.save(user);
    	return user;
    }
}
