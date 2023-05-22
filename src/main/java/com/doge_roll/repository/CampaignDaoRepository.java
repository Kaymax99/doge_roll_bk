package com.doge_roll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doge_roll.entity.Campaign;

public interface CampaignDaoRepository extends CrudRepository<Campaign, Long>, PagingAndSortingRepository<Campaign, Long> {

}
