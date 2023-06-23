package com.example.demo.dto;

import com.example.demo.entity.Client;
import com.example.demo.entity.Manager;
import com.example.demo.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientDto {

    private Long id;

    private String loginName;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate enrolledDate;

    private Manager managers;

    private List<ProductDto> productDtoList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(LocalDate enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public Manager getManagers() {
        return managers;
    }

    public void setManagers(Manager managers) {
        this.managers = managers;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }

    public Client convertClientDtoToClient(){
        Client client = new Client();
        if(getId() != null)
            client.setId(getId());
        client.setLoginName(getLoginName());
        client.setPassword(getPassword());
        client.setFirstName(getFirstName());
        client.setLastName(getLastName());
        client.setEmail(getEmail());
        client.setEnrolledDate(getEnrolledDate());
        client.setManager(getManagers());
        return client;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", enrolledDate=" + enrolledDate +
                '}';
    }
}
