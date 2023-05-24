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
public class ProfileResponse {
	private Long id;
	private String username;
	private String name;
	private String surname;
	private String email;
	private String profilePic;
    private LocalDate registration_date;
    private String bio;

}
