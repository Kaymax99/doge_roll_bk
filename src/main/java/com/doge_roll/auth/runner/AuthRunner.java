package com.doge_roll.auth.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.doge_roll.auth.entity.ERole;
import com.doge_roll.auth.entity.Role;
import com.doge_roll.auth.repository.RoleRepository;
import com.doge_roll.auth.repository.UserRepository;
import com.doge_roll.auth.service.AuthService;

@Component
public class AuthRunner implements ApplicationRunner {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthService authService;

	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Auth Running...");
		setRoleDefault();

	}

	private void setRoleDefault() {
		Optional<Role> adminCheck = roleRepository.findByRoleName(ERole.ROLE_ADMIN);
		Optional<Role> userCheck = roleRepository.findByRoleName(ERole.ROLE_USER);

		Role admin = new Role();
		Role user = new Role();
		
		System.out.println(adminCheck);
		if (adminCheck.isEmpty()) {
			admin.setRoleName(ERole.ROLE_ADMIN);
			roleRepository.save(admin);
		}

		if (userCheck.isEmpty()) {
			user.setRoleName(ERole.ROLE_USER);
			roleRepository.save(user);
		}

		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(user);

		moderatorRole = new HashSet<Role>();
		moderatorRole.add(user);

		userRole = new HashSet<Role>();
		userRole.add(user);
	}

}
