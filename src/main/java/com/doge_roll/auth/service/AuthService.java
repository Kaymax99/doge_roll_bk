package com.doge_roll.auth.service;

import com.doge_roll.auth.payload.LoginDto;
import com.doge_roll.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
