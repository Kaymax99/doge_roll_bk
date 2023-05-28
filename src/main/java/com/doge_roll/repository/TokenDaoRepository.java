package com.doge_roll.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doge_roll.entity.CanvasToken;

public interface TokenDaoRepository extends CrudRepository<CanvasToken, String>, PagingAndSortingRepository<CanvasToken, String> {

	@Query(value = "SELECT * FROM canvas_tokens t WHERE t.campaign_id = :campaignId", nativeQuery = true)
	public List<CanvasToken> filterByCampaignId(Long campaignId);
	
//	@Query(value = "DELETE FROM campaigns_tokens c WHERE c.token_id IN (SELECT id FROM canvas_tokens);"
//			+ "DELETE FROM canvas_tokens", nativeQuery = true)
	@Query(value = "DELETE FROM canvas_tokens WHERE campaign_id = :id", nativeQuery = true)
	public void delByCampaignId(Long id);
}