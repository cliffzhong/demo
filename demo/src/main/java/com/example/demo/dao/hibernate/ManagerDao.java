package com.example.demo.dao.hibernate;

import com.example.demo.entity.Manager;

import java.util.List;

public interface ManagerDao {
    Manager save(Manager manager);
    Manager update(Manager manager);
    boolean deleteByName(String managerName);
    boolean deleteById(Long managerId);
    boolean delete(Manager manager);
    List<Manager> getManagers();
    Manager getManagerById(Long id);

    Manager getManagerAndClientAndProductWithManagerId(Long id);

    Manager getManagerByName(String managerName);

    //List<Major> getMajorsWithChildren();
    //Manager getManagerAndClientsAndProductsByManagerId(Long ManagerId);
    //Manager getManagerAndClientsAndProductsByManagerName(String ManagerName);
}
