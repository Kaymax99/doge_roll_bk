package com.doge_roll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doge_roll.entity.Campaign;
import com.doge_roll.repository.CampaignDaoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignDaoRepository campRepo;
	
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
}
