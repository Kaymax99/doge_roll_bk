package com.doge_roll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doge_roll.entity.Campaign;
import com.doge_roll.entity.CharacterDnD;
import com.doge_roll.repository.CharacterDaoRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class CharacterService {
	
	@Autowired
	private CharacterDaoRepository charRepo;
	
	@Autowired
	private CampaignService campRepo;
	
	public CharacterDnD saveCharacter(Long id, CharacterDnD character) {
		Campaign c = campRepo.getCampaignById(id);
		character.setCampaign(c);
		charRepo.save(character);
		return character;
	}
	
	public List<CharacterDnD> findAll() {
		return (List<CharacterDnD>) charRepo.findAll();
	}
	
	public CharacterDnD updateCharacter(CharacterDnD character) {
		if (!charRepo.existsById(character.getId())) {
			throw new EntityExistsException("No Character saved with given ID");
		}
		charRepo.save(character);
		return character;
	}
	public List<CharacterDnD> filterByCampaign(Long campaignId) {
		return charRepo.filterByCampaign(campaignId);
	}
	public String deleteCharacter(Long id) {
		if (!charRepo.existsById(id)) {
			throw new EntityExistsException("No Character saved with given ID");
		}
		charRepo.deleteById(id);
		return "Character successfully deleted";
	}
}
