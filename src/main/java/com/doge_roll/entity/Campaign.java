package com.doge_roll.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.doge_roll.auth.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "campaigns")
public class Campaign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private User user;
	private LocalDate nextSession;
	private String description;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "campaigns_tokens",
            joinColumns = @JoinColumn(name = "campaign_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "token_id", referencedColumnName = "id")
    )
    private List<CanvasToken> tokens = new ArrayList<>();
}
