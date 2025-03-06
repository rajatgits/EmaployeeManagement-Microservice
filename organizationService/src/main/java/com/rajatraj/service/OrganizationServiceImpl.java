package com.rajatraj.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajatraj.dto.OrganizationDTO;
import com.rajatraj.enitity.Organization;
import com.rajatraj.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<OrganizationDTO> getAllorganizations() {
		List<Organization> organizations = organizationRepository.findAll();
		return organizations.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public OrganizationDTO getOrganizationById(Long id) {
		Organization organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
		return convertToDTO(organization);
	}

	@Override
	public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
		Organization organization = convertToEntity(organizationDTO);
		Organization savedOrganization = organizationRepository.save(organization);
		return convertToDTO(savedOrganization);
	}

	@Override
	public OrganizationDTO updateOrganization(Long id, OrganizationDTO organizationDTO) {
		Organization existingOrganization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
		
		if(organizationDTO.getOrganizationName() != null) {
			existingOrganization.setOrganizationName(organizationDTO.getOrganizationName());
		}
		
		if(organizationDTO.getOrganizationDescription() != null) {
			existingOrganization.setOrganizationDescription(organizationDTO.getOrganizationDescription());
		}
		
		if(organizationDTO.getOrganizationCode() != null) {
			existingOrganization.setOrganizationCode(organizationDTO.getOrganizationCode());
		}
		
		Organization updatedOrganization = organizationRepository.save(existingOrganization);
		return convertToDTO(updatedOrganization);
	}

	@Override
	public void deleteOrganization(Long id) {
		organizationRepository.deleteById(id);
	}
	
	// Convert Entity to DTO
    private OrganizationDTO convertToDTO(Organization organization) {
        return modelMapper.map(organization, OrganizationDTO.class);
    }
    
    // Convert DTO to Entity
    private Organization convertToEntity(OrganizationDTO organizationDTO) {
        return modelMapper.map(organizationDTO, Organization.class);
    }

}
