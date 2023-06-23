package com.example.demo.entity;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.ManagerDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "manager")
    private List<Client> clientList;

    public long getId() {
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

    public ManagerDto convertManagerToManagerDto(){
        Manager manager = new Manager();
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(getId());
        managerDto.setName(getName());
        managerDto.setDescription(getDescription());
        return managerDto;


//        manager.setName(
    }

//    public Manager convertManagerDtoToManager(){
//        Manager manager = new Manager();
//        if(getId() != 0L)
//            manager.setId(getId());
//        manager.setName(getName());
//        manager.setDescription(getDescription());
//        List<Client> clientList = getClientListByStudentDtoList(this.getClientDtoList());
//        manager.setClientList(clientList);
//
//    }
//
//    private List<Client> getClientListByStudentDtoList(List<ClientDto> clientDtoList){
//        List<Client> clientList = new ArrayList<>();
//        for(ClientDto clientDto : clientDtoList){
//            Client client = clientDto.convertClientDtoToClient();
//            clientList.add(client);
//        }
//        return clientList;
//    }

    public List<Client> getClientList() {
        if(clientList == null)
            clientList = new ArrayList<>();
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public void addClient(Client client){
        this.getClientList().add(client);
        client.setManager(this);
    }

    public void removeClient(Client client){
        this.getClientList().remove(client);
        client.setManager(null);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
