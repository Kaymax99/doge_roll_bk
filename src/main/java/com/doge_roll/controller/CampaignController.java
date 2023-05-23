package com.doge_roll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doge_roll.entity.Campaign;
import com.doge_roll.service.CampaignService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/campaigns")
public class CampaignController {
	
	@Autowired
	CampaignService campService;
	
	@PostMapping
	public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) {
		return new ResponseEntity<Campaign>(campService.saveCampaign(campaign), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "all")
	public ResponseEntity<List<Campaign>> getAllCampaigns() {
		return new ResponseEntity<List<Campaign>>(campService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/user/{username}")
	public ResponseEntity<List<Campaign>> getCampaignsByUsername(@PathVariable(name = "username") String username) {
		return new ResponseEntity<List<Campaign>>(campService.filterByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Campaign> getCampaignById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<Campaign>(campService.getCampaignById(id), HttpStatus.OK);
	}
	@PutMapping(path = "{id}")
	public ResponseEntity<Campaign> updateCampaign(@RequestBody Campaign campaign) {
		return new ResponseEntity<Campaign>(campService.updateCampaign(campaign), HttpStatus.OK);
	}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<String> deleteCampaign(@PathVariable Long id) {
		return new ResponseEntity<String>(campService.deleteCampaign(id), HttpStatus.OK);
	}
}
