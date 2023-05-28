package com.doge_roll.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doge_roll.entity.CanvasToken;
import com.doge_roll.repository.CampaignDaoRepository;
import com.doge_roll.repository.TokenDaoRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class TokenService {
	
	@Autowired
	private TokenDaoRepository tokenRepo;
	@Autowired
	private CampaignDaoRepository campaignRepo;
	
	public String deleteToken (String id) {
		if (!tokenRepo.existsById(id)) {
			throw new EntityExistsException("No Token found with given ID");
		}
		System.out.println("id: " + id);
		System.out.println("pls delete");
		tokenRepo.deleteById(id);
		return "Token deleted";
	}
	public List<CanvasToken> filterByCampaignId(Long id) {
		if (!campaignRepo.existsById(id)) {
			throw new EntityExistsException("No Campaign saved with given ID");
		}
		return tokenRepo.filterByCampaignId(id);
	}
	public String delById(Long id) {
		List<CanvasToken> tokens = tokenRepo.filterByCampaignId(id);
		if (tokens.size() == 0) {
			return "No token deleted as campaign had no tokens assigned";
		}
		tokenRepo.delByCampaignId(id);
		return "Deleted all related tokens";
	}
	public CanvasToken saveToken (CanvasToken token) {
		tokenRepo.save(token);
		return token;
	}
	

}
