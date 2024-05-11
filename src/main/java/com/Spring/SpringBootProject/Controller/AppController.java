package com.Spring.SpringBootProject.Controller;

import com.Spring.SpringBootProject.entity.Department;
import com.Spring.SpringBootProject.errors.DepartmentNotFoundException;
import com.Spring.SpringBootProject.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AppController {
    @Autowired
    private DepartmentService departmentService;
    @Value("${welcome.msg}")
    private String welcomeMsg;
    //Log4j
    private final Logger Logger =LoggerFactory.getLogger(AppController.class);

    @GetMapping ("/getDepartmentData/{id}")
    public Department getDataById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> optional = departmentService.getDepartmentById(departmentId);
        //Handling the department not present exception
        if(!optional.isPresent())
        {
            Logger.error("Department "+departmentId+ " doesn't exists");
            throw new DepartmentNotFoundException("Department not found Exception");
        }
        return optional.get();
    }

    @PostMapping("/saveAllDepartments")
    public List<Department> saveAllDepartments(@RequestBody List<Department> departmentList)
    {
        return departmentService.saveAllDepartments(departmentList);
    }
    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartment()
    {
        if(Logger.isDebugEnabled())
        {
            System.out.println("Debug is enabled in the AppController class");
        }
        return departmentService.getAllDepartments();
    }

    @GetMapping("/home")
    public String homePage()
    {
        return welcomeMsg; //Returning custom property value
    }

    @PutMapping("/updateDepartment/{id}")
    public void updateDepartment(@RequestBody Department department, @PathVariable("id") Integer departmentId)
    {
        System.out.println(department);
        if(department != null)
         departmentService.updateDepartmentById(department.getDepartmentName(),departmentId);
    }
}
