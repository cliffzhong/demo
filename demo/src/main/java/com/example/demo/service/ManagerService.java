package com.example.demo.service;

import com.example.demo.dto.ManagerDto;
import com.example.demo.entity.Manager;

import java.util.List;

public interface ManagerService {

    ManagerDto save(ManagerDto managerDto);

    ManagerDto update(ManagerDto managerDto);

    boolean deleteByName(String managerDtoName);

    boolean deleteById(Long managerDtoId);

    boolean delete(ManagerDto managerDto);

    List<ManagerDto> getManagers();

    ManagerDto getManagerById(Long id);

    ManagerDto getManagerByName(String managerDtoName);
}
