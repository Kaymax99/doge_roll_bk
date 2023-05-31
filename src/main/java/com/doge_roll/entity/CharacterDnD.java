package com.doge_roll.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "characters")
public class CharacterDnD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Campaign campaign;
	
	private String name;
	private String charClass;
	private String classLevel;
	private String background;
	private String race;
	private String size;
	private String alignment;
	private String xp;
	private String xpMax;
	
	private String inspiration;
	private String proficiencyBonus;
	
	private String strength;
	private String dexterity;
	private String constitution;
	private String intelligence;
	private String wisdom;
	private String charisma;
	
	private String strSave;
	private String strSaveProficient;
	private String dexSave;
	private String dexSaveProficient;
	private String conSave;
	private String conSaveProficient;
	private String intSave;
	private String intSaveProficient;
	private String wisSave;
	private String wisSaveProficient;
	private String chaSave;
	private String chaSaveProficient;
	
	private String acrobatics;
	private String acrobaticsProficient;
	private String animalHandling;
	private String animalHandlingProficient;
	private String arcana;
	private String arcanaProficient;
	private String athletics;
	private String athleticsProficient;
	private String deception;
	private String deceptionProficient;
	private String history;
	private String historyProficient;
	private String insight;
	private String insightProficient;
	private String intimidation;
	private String intimidationProficient;
	private String investigation;
	private String investigationProficient;
	private String medicine;
	private String medicineProficient;
	private String nature;
	private String natureProficient;
	private String perception;
	private String perceptionProficient;
	private String performance;
	private String performanceProficient;
	private String persuasion;
	private String persuasionProficient;
	private String religion;
	private String religionProficient;
	private String slightOfHand;
	private String slightOfHandProficient;
	private String stealth;
	private String stealthProficient;
	private String survival;
	private String survivalProficient;
	private String otherProficiencies;
	private String languages;
	
	private String ac;
	private String init;
	private String speed;
	private String hp;
	private String maxHp;
	private String tempHp;
	private String hitDie;
	private String hitDieMax;
	
	private String deathsaveSuccesses;
	private String deathsaveFailures;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CharacterDnDAttack> attacks;
	private String attacksText;
	
	private String spellcastingType;
	private String spellcastingAbility;
	private String spellSaveDC;
	private String spellAttackMod;
	private String knownSpells;
	private String preparedSpells;
	
	private String cantrips;
	private String lvl1SpellSlotsMax;
	private String lvl1SpellSlotsUsed;
	private String lvl1Spells;
	private String lvl2SpellSlotsMax;
	private String lvl2SpellSlotsUsed;
	private String lvl2Spells;
	private String lvl3SpellSlotsMax;
	private String lvl3SpellSlotsUsed;
	private String lvl3Spells;
	private String lvl4SpellSlotsMax;
	private String lvl4SpellSlotsUsed;
	private String lvl4Spells;
	private String lvl5SpellSlotsMax;
	private String lvl5SpellSlotsUsed;
	private String lvl5Spells;
	private String lvl6SpellSlotsMax;
	private String lvl6SpellSlotsUsed;
	private String lvl6Spells;
	private String lvl7SpellSlotsMax;
	private String lvl7SpellSlotsUsed;
	private String lvl7Spells;
	private String lvl8SpellSlotsMax;
	private String lvl8SpellSlotsUsed;
	private String lvl8Spells;
	private String lvl9SpellSlotsMax;
	private String lvl9SpellSlotsUsed;
	private String lvl9Spells;
	
	private String cp;
	private String sp;
	private String ep;
	private String gp;
	private String pp;
	private String equipment;
	
	private String personalityTraits;
	private String ideals;
	private String bonds;
	private String flaws;
	
	private String modifiers;
	private String racialTraits;
	private String classFeatures;
	private String feats;
	private String traits;
	private String miscNotes1;
	private String miscNotes2;
	
	private String gender;
	private String age;
	private String height;
	private String weight;
	private String eyes;
	private String skin;
	private String hair;
	private String appeareance;
	private String backstory;
	private String picture;

}
