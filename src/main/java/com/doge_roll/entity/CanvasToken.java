package com.doge_roll.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "campaign_tokens")
public class CanvasToken {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer left;
	private Integer top;
	private short scaleX;
	private short scaleY;
	private short angle;
	private String currentSrc;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Campaign campaign;

}
