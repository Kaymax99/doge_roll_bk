package com.doge_roll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doge_roll.entity.CharacterDnD;

public interface CharacterDaoRepository
		extends CrudRepository<CharacterDnD, Long>, PagingAndSortingRepository<CharacterDnD, Long> {

	@Query(value = "SELECT * FROM characters c where c.campaign_id = :campaignId ORDER BY c.id ASC", nativeQuery = true)
	public List<CharacterDnD> filterByCampaign(Long campaignId);
}
