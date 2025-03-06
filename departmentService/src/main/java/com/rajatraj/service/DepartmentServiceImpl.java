package com.rajatraj.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajatraj.dto.DepartmentDTO;
import com.rajatraj.entity.Department;
import com.rajatraj.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return convertToDTO(department);
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return convertToDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        if(departmentDTO.getDepartmentName() != null) {
        	existingDepartment.setDepartmentName(departmentDTO.getDepartmentName());
        }
        
        if(departmentDTO.getDepartmentDescription() != null) {
        	existingDepartment.setDepartmentDescription(departmentDTO.getDepartmentDescription());
        }
        
        if(departmentDTO.getDepartmentCode() != null) {
        	existingDepartment.setDepartmentCode(departmentDTO.getDepartmentCode());
        }
        
        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return convertToDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
    
    // Convert Entity to DTO
    private DepartmentDTO convertToDTO(Department department) {
        return modelMapper.map(department, DepartmentDTO.class);
    }
    
    // Convert DTO to Entity
    private Department convertToEntity(DepartmentDTO departmentDTO) {
        return modelMapper.map(departmentDTO, Department.class);
    }
}