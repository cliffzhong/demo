package com.example.demo.repository;

import com.example.demo.dto.Department;
import com.example.demo.exception.DepartmentNotFoundException;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

public class DepartmentRepository {

    private static Department[] departmentArray = new Department[] {
            new Department("HR", "human", "111"),
            new Department("R&D", "research", "222"),
            new Department("Tech", "techno", "333"),
            new Department("CS", "Cunstomer Service", "555")
    };


    private static List<Department> departmentList = Arrays.asList(departmentArray);

    public List<Department> findAllDepartment(){
        return departmentList;
    }

    public Department findDepartmentBynName(String departmentName) {
        Department department = null;
        for (Department eachDepartment : departmentList) {
            if (departmentName.equalsIgnoreCase(eachDepartment.getName())) {
                department = eachDepartment;
                break;

            }
        }
        if (department == null) {
            throw new DepartmentNotFoundException("Can not found department " + departmentName);
        }
        return department;
    }

    public Department save(Department department) {
    return null;
    }

    public boolean deleteByName(String deptName) {return false;
    }

    public List<Department> findAllDepartmentsWithChildren() {return null;
    }

    public Optional<Department> findById(Long id) {return null;
    }

    public Department findDepartmentWithChildrenByName(String deptName) {
    return null;}

    public Department findDepartmentWithChildrenById(Long id) {
        return null;}

    public Department findDepartmentWithAssociatedEmployeesByDepartmentName(String deptName) {
        return null;}

    public Department findDepartmentWithAssociatedEmployeesAndAccountsByDepartmentName(String deptName) {
        return null;}

    public List<Department> findAll() {
    return null;}

    public Department findByName(String deptName) {
    return null;}
}

