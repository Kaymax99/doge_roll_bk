package com.doge_roll.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.OnDelete;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
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
	private String id;
	
	private Integer leftValue;
	private Integer topValue;
	private Integer width;
	private Integer height;
	private BigDecimal scaleX;
	private BigDecimal scaleY;
	private Short angle;
	private String currentSrc;
	private String layer;
//	@JoinTable(name = "campaigns_tokens",
//		joinColumns = @JoinColumn(name = "token_id", referencedColumnName = "id"),
//		inverseJoinColumns = @JoinColumn(name = "campaign_id", referencedColumnName = "id")
//			)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Campaign campaign;
}
