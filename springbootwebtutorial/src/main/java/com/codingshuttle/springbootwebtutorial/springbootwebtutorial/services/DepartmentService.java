package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.DepartmentDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.DepartmentEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repositories.DepartmentRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public DepartmentDTO getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .map(entity -> modelMapper.map(entity, DepartmentDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: "+ departmentId));
    }


    public DepartmentDTO createNewDepartment(@Valid DepartmentDTO inputDepartment) {
        DepartmentEntity departmentEntity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity savedEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        return departmentEntityList.stream().
                map((entity -> modelMapper.map(entity, DepartmentDTO.class)))
                .toList();
    }


    public Boolean deleteDepartmentById(Long departmentId) {
        departmentRepository.findById(departmentId).
                orElseThrow(() -> new ResourceNotFoundException("Department not found with Id : " + departmentId));
        return true;
    }


    public DepartmentDTO updateDepartmentWithId(Long departmentId, DepartmentDTO inputDepartment) {
        boolean isExist = departmentRepository.existsById(departmentId);
        if (!isExist) {
            throw new ResourceNotFoundException("Department not exist with the Id " + departmentId);
        }

        DepartmentEntity entity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        entity.setId(departmentId);
        entity.setTitle(inputDepartment.getTitle());
        return modelMapper.map(departmentRepository.save(entity), DepartmentDTO.class);
    }


}
