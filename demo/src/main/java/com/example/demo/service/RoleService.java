package com.example.demo.service;


import com.example.demo.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto getRoleByName(String name);

    List<RoleDto> getAllRoles();
}
