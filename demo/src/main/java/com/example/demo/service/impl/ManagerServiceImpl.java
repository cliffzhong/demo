package com.example.demo.service.impl;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.dao.hibernate.ManagerDao;
import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.dto.ManagerDto;
import com.example.demo.entity.Manager;
import com.example.demo.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    @Qualifier("ManagerDaoSpringDataJPAImpl")
    private ManagerDao managerDao;

    @Autowired
    @Qualifier("ClientDaoSpringDataJPAImpl")
    private ClientDao clientDao;

    @Autowired
    @Qualifier("ProductDaoSpringDataJPAImpl")
    private ProductDao productDao;

    @Override
    public ManagerDto save(ManagerDto managerDto) {
        Manager manager = managerDto.convertManagerDtoToManager();
        Manager savedManager = managerDao.save(manager);
        ManagerDto savedManagerDto = savedManager.convertManagerToManagerDto();
        return savedManagerDto;
    }

    @Override
    public ManagerDto update(ManagerDto managerDto) {
        Manager manager = managerDto.convertManagerDtoToManager();
        Manager updatedManager = managerDao.update(manager);
        ManagerDto updatedManagerDto = updatedManager.convertManagerToManagerDto();
        return updatedManagerDto;
    }

    @Override
    public boolean deleteByName(String managerDtoName) {
        return false;
    }

    @Override
    public boolean deleteById(Long managerDtoId) {
        return false;
    }

    @Override
    public boolean delete(ManagerDto managerDto) {
        return false;
    }

    @Override
    public List<ManagerDto> getManagers() {
        List<Manager> managerList = managerDao.getManagers();
        List<ManagerDto> managerDtoList = getManagerDtoFromManagerList(managerList);
        return managerDtoList;
    }

    private List<ManagerDto> getManagerDtoFromManagerList(List<Manager> managerList) {
        List<ManagerDto> managerDtoList = new ArrayList<>();
        for(Manager manager:managerList) {
            ManagerDto managerDto = manager.convertManagerToManagerDto();
            managerDtoList.add(managerDto);
        }
        return managerDtoList;
    }

    @Override
    public ManagerDto getManagerById(Long id) {
        ManagerDto managerDto = null;
        Manager manager = managerDao.getManagerById(id);
        managerDto = manager.convertManagerToManagerDto();
        return managerDto;
    }

    @Override
    public ManagerDto getManagerByName(String managerDtoName) {
        ManagerDto managerDto = null;
        Manager manager = managerDao.getManagerByName(managerDtoName);
        managerDto = manager.convertManagerToManagerDto();
        return managerDto;
    }
}
