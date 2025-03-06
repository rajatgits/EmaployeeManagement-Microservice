package com.rajatraj.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long organizationId;
	private String organizationName;
	private String organizationDescription;
	private String organizationCode;
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationDescription() {
		return organizationDescription;
	}
	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public Organization() {
		
	}
	public Organization(Long organizationId, String organizationName, String organizationDescription,
			String organizationCode) {
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.organizationDescription = organizationDescription;
		this.organizationCode = organizationCode;
	}
	
}
