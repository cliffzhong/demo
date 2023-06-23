package com.example.demo.service;

import com.example.demo.dto.Department;
import com.example.demo.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(){
        this.departmentRepository = new DepartmentRepository();
    }




    public List<Department> findAllDepartment(){
        return departmentRepository.findAllDepartment();
    }


    public Department findDepartmentByName(String departmentname){
        return departmentRepository.findDepartmentBynName(departmentname);
    }
}
