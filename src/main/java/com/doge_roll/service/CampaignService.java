package com.doge_roll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doge_roll.auth.repository.UserRepository;
import com.doge_roll.entity.Campaign;
import com.doge_roll.entity.CharacterDnD;
import com.doge_roll.repository.CampaignDaoRepository;
import com.doge_roll.repository.CharacterDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignDaoRepository campRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CharacterDaoRepository charRepo;
	
	public Campaign saveCampaign(Campaign campaign) {
		campRepo.save(campaign);
		return campaign;
	}
	public List<Campaign> findAll() {
		return (List<Campaign>) campRepo.findAll();
	}
	public Campaign getCampaignById(Long id) {
		if(!campRepo.existsById(id)) {
			throw new EntityNotFoundException("No campaign found matching given id!");
		}
		return campRepo.findById(id).get();
	}
	public Campaign updateCampaign(Campaign campaign ) {
		if (!campRepo.existsById(campaign.getId())) {
			throw new EntityExistsException("No Campaign saved with given ID");
		}
		campRepo.save(campaign);
		return campaign;
	}
	public List<Campaign> filterByUsername(String username) {
		if (!userRepo.existsByUsername(username)) {
			throw new EntityExistsException("No User saved with given ID");
		}
		return campRepo.filterByUsername(username);
	}
	
	public String deleteCampaign(Long id) {
		if (!campRepo.existsById(id)) {
			throw new EntityExistsException("No Campaign saved with given ID");
		}
		List<CharacterDnD> charList = charRepo.filterByCampaign(id);
		for (CharacterDnD character : charList) {
			charRepo.deleteById(character.getId());
		}
		campRepo.deleteById(id);
		return "Campaign and associated characters deleted succesfully";
	}
}
