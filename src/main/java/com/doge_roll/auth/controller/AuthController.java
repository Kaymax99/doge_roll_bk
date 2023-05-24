package com.doge_roll.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doge_roll.auth.entity.User;
import com.doge_roll.auth.payload.JWTAuthResponse;
import com.doge_roll.auth.payload.LoginDto;
import com.doge_roll.auth.payload.ProfileResponse;
import com.doge_roll.auth.payload.RegisterDto;
import com.doge_roll.auth.service.AuthService;
import com.doge_roll.auth.service.AuthServiceImpl;

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    
    @Autowired
    private AuthServiceImpl authImplService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
           	
    	String username = loginDto.getUsername();
    	String token = authService.login(loginDto);
    	User u = authImplService.getUserByUsername(username);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setId(u.getId());
        jwtAuthResponse.setUsername(username);
        jwtAuthResponse.setName(u.getName());
        jwtAuthResponse.setSurname(u.getSurname());
        jwtAuthResponse.setEmail(u.getEmail());
        jwtAuthResponse.setProfilePic(u.getProfilePic());
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRegistration_date(u.getRegistrationDate());
        jwtAuthResponse.setBio(u.getBio());
        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
    	
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/user/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ProfileResponse> getUserById(@PathVariable(name = "id") Long id) {
    	
    	User u = authImplService.getUserById(id);
    	ProfileResponse res = new ProfileResponse();
    	res.setId(id);
    	res.setUsername(u.getUsername());
    	res.setName(u.getName());
    	res.setSurname(u.getSurname());
    	res.setEmail(u.getEmail());
    	res.setProfilePic(u.getProfilePic());
    	res.setRegistration_date(u.getRegistrationDate());
    	res.setBio(u.getBio());
    	return ResponseEntity.ok(res);
    }
}
