package com.doge_roll.entity;

import java.math.BigDecimal;

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
@Table(name = "canvas_tokens")
public class CanvasToken {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer leftValue;
	private Integer topValue;
	private Integer width;
	private Integer height;
	private BigDecimal scaleX;
	private BigDecimal scaleY;
	private Short angle;
	private String currentSrc;
	private String layer;
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	private Campaign campaign;

}
