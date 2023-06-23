package com.example.demo.controller;

import com.example.demo.dto.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(){
        this.departmentService = new DepartmentService();
    }

    @GetMapping("/departments")
    public List<Department> findAllDepartments(){
        return departmentService.findAllDepartment();
    }
    @GetMapping("/departments/{name}")
    public Department findDepartmentByName(@PathVariable("name") String departmentname){
        return departmentService.findDepartmentByName(departmentname);
    }
}
