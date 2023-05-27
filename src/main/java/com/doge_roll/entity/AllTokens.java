package com.doge_roll.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class AllTokens {
	
	private List<CanvasToken> tokens = new ArrayList<>();
	private List<CanvasToken> maps = new ArrayList<>();

}
