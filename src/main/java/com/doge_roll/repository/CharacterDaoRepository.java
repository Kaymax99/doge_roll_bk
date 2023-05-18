package com.doge_roll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.doge_roll.entity.CharacterDnD;

public interface CharacterDaoRepository extends CrudRepository<CharacterDnD, Long>, PagingAndSortingRepository<CharacterDnD, Long>{

}
