package com.doge_roll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doge_roll.entity.Campaign;

public interface CampaignDaoRepository extends CrudRepository<Campaign, Long>, PagingAndSortingRepository<Campaign, Long> {

	@Query(value = "SELECT * FROM campaigns c where c.user_id = :userId ORDER BY c.id ASC", nativeQuery = true)
	public List<Campaign> filterByUserId(Long userId);
}
