package com.doge_roll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doge_roll.entity.CharacterDnD;
import com.doge_roll.service.CharacterService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	CharacterService charService;

	@PostMapping
	public ResponseEntity<CharacterDnD> createCharacter(@RequestBody CharacterDnD character) {
		return new ResponseEntity<CharacterDnD>(charService.saveCharacter(character), HttpStatus.CREATED);
	}

	@GetMapping(path = "all")
	public ResponseEntity<List<CharacterDnD>> getAllCharacters() {
		return new ResponseEntity<List<CharacterDnD>>(charService.findall(), HttpStatus.OK);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> updateCharacter(@RequestBody CharacterDnD character){
		return new ResponseEntity<CharacterDnD>(charService.updateCharacter(character),HttpStatus.OK);
	}
}
