package com.rajatraj.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rajatraj.entity.Department;

@FeignClient(name = "DEPARMENT-SERVICE", url = "http://localhost:8082")
public interface DepartmentServiceClient {
	@GetMapping("/departments/{departmentId}")
	Department departmentById(@PathVariable Long departmentId);
}