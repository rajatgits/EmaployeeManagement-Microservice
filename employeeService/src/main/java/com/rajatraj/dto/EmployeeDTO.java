package com.rajatraj.dto;

 
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
    private DepartmentDTO department;
    private Long organizationId;
    private OrganizationDTO organization;
    public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public OrganizationDTO getOrganization() {
		return organization;
	}
	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}
	
    public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public DepartmentDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeDTO() {
		
	}
	public EmployeeDTO(Long id, String firstName, String lastName, String email, Long departmentId, DepartmentDTO department, Long organizationId, OrganizationDTO organization) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.departmentId = departmentId;
		this.department = department;
		this.organizationId = organizationId;
		this.organization = organization;
	}
}