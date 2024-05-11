package com.Spring.SpringBootProject.service;

import com.Spring.SpringBootProject.entity.Department;
import com.Spring.SpringBootProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> saveAllDepartments(List<Department> departmentList) {
        System.out.println(departmentRepository.getClass().getName());
        return departmentRepository.saveAll(departmentList);
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void updateDepartmentById(String departmentName, Integer departmentId) {
        departmentRepository.updateDepartmentById(departmentName, departmentId);
    }
}
