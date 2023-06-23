package com.example.demo.dto;

import com.example.demo.entity.Client;
import com.example.demo.entity.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerDto {

    private Long id;

    private String name;

    private String description;

    private List<ClientDto> clientDtoList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClientDto> getClientDtoList() {
        return clientDtoList;
    }

    public void setClientDtoList(List<ClientDto> clientDtoList) {
        this.clientDtoList = clientDtoList;
    }

    public Manager convertManagerDtoToManager(){
        Manager manager = new Manager();
        if(getId() != null)
            manager.setId(getId());
        manager.setName(getName());
        manager.setDescription(getDescription());
        List<Client> clientList = getClientListByManagerDtoList(this.getClientDtoList());
        manager.setClientList(clientList);
        return manager;
    }

    private List<Client> getClientListByManagerDtoList(List<ClientDto> clientDtoList) {
        List<Client> clientList = new ArrayList<>();
        for(ClientDto clientDto: clientDtoList)
            clientDtoList = clientDtoList;
        return clientList;
    }

    @Override
    public String toString() {
        return "ManagerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
