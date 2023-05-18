package com.doge_roll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doge_roll.entity.CharacterDnD;
import com.doge_roll.repository.CharacterDaoRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class CharacterService {
	
	@Autowired
	private CharacterDaoRepository charRepo;
	
	public CharacterDnD saveCharacter(CharacterDnD character) {
		charRepo.save(character);
		return character;
	}
	
	public List<CharacterDnD> findall() {
		return (List<CharacterDnD>) charRepo.findAll();
	}
	
	public CharacterDnD updateCharacter(CharacterDnD character) {
		if (!charRepo.existsById(character.getId())) {
			throw new EntityExistsException("No Character saved with given ID");
		}
		charRepo.save(character);
		return character;
	}
	
}
