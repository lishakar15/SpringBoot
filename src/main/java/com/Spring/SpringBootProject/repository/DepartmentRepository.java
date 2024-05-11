package com.Spring.SpringBootProject.repository;

import com.Spring.SpringBootProject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Modifying
    @Transactional
    @Query(value = "update Department D set D.departmentName =?1 where D.departmentId=?2")
    public void updateDepartmentById(String departmentName,Integer departmentId);
}
