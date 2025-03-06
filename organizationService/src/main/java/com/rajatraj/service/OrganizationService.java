package com.rajatraj.service;

import java.util.List;

import com.rajatraj.dto.OrganizationDTO;

public interface OrganizationService {
	List<OrganizationDTO> getAllorganizations();
	OrganizationDTO getOrganizationById(Long id);
 	OrganizationDTO createOrganization(OrganizationDTO organizationDTO);
	OrganizationDTO updateOrganization(Long id, OrganizationDTO organizationDTO);
    void deleteOrganization(Long id);
}
