package com.doge_roll.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CharacterDnDAttack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String bonus;
	private boolean proficiency;
	private short critRange;
	private short diceQnt;
	private String diceType;
	private String damageType;
	private short bonusAtk;

}
