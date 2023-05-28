package com.doge_roll.service;

import java.util.List;
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
		tokenRepo.deleteById(id);
		return "Token deleted";
	}
	public List<CanvasToken> filterByCampaignId(Long id) {
		if (!campaignRepo.existsById(id)) {
			throw new EntityExistsException("No Campaign saved with given ID");
		}
		return tokenRepo.filterByCampaignId(id);
	}
	
	public CanvasToken saveToken (CanvasToken token) {
		tokenRepo.save(token);
		return token;
	}
	

}
