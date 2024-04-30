package com.Spring.SpringBootProject.service;

import com.Spring.SpringBootProject.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    public List<Department> saveAllDepartments( List<Department> departmentList);
    public Optional<Department> getDepartmentById(Long id);

    public List<Department> getAllDepartments();
}
