package com.doge_roll.auth.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String username;
	private String name;
	private String surname;
	private String email;
	private String profilePic;
    private String accessToken;
    private String tokenType = "Bearer";
    private LocalDate registration_date;
}
