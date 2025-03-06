package com.rajatraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajatraj.dto.OrganizationDTO;
import com.rajatraj.service.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping
	public List<OrganizationDTO> getAllOrganizations() {
		return organizationService.getAllorganizations();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
		OrganizationDTO organizationDTO = organizationService.getOrganizationById(id);
		return ResponseEntity.ok(organizationDTO);
	}
	
	@PostMapping
	public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
		OrganizationDTO createOrganization = organizationService.createOrganization(organizationDTO);
		return ResponseEntity.ok(createOrganization);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrganizationDTO> updateOrganization(@PathVariable Long id, @RequestBody OrganizationDTO organizationDTO) {
		OrganizationDTO updatedOrganization = organizationService.updateOrganization(id, organizationDTO);
		return ResponseEntity.ok(updatedOrganization);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrganization(@PathVariable Long id){
		organizationService.deleteOrganization(id);
		return ResponseEntity.noContent().build();
	}
}
