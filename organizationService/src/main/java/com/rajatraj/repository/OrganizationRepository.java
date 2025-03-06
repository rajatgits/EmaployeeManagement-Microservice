package com.rajatraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajatraj.enitity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}