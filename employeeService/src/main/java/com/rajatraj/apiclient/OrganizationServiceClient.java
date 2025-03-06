package com.rajatraj.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rajatraj.entity.Organization;

@FeignClient(name="ORGANIZATION-SERVICE", url="http://localhost:8083")
public interface OrganizationServiceClient {
	@GetMapping("/organizations/{organizationId}")
	Organization organizationById(@PathVariable Long organizationId);
}
