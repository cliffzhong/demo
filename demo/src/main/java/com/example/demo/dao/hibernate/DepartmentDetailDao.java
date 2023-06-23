package com.example.demo.dao.hibernate;


import com.example.demo.dto.DepartmentDetail;

import java.util.List;

public interface DepartmentDetailDao {
    List<DepartmentDetail> getDepartmentDetails();
    DepartmentDetail getDepartmentDetailById(Long id);
    DepartmentDetail save(DepartmentDetail departmentDetail);
    boolean delete(DepartmentDetail departmentDetail);
}
