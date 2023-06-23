package com.example.demo.entity;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.ManagerDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "enrolled_date")
    private LocalDate enrolledDate;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToMany
    @JoinTable(name = "client_product",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> productList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ClientDto convertClientToClientDto() {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(getId());
        clientDto.setLoginName(getLoginName());
        clientDto.setPassword(getPassword());
        clientDto.setFirstName(getFirstName());
        clientDto.setLastName(getLastName());
        clientDto.setEmail(getEmail());
        clientDto.setEnrolledDate(getEnrolledDate());
        clientDto.setManagers(getManager());
        return clientDto;
    }

    public List<Product> getProductList() {
        if(productList == null)
            productList = new ArrayList<>();
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product){
        this.getProductList().add(product);
        product.getClientList().add(this);
    }

    public void removeProduct(Product product){
        this.getProductList().remove(product);
        product.getClientList().remove(this);
    }

    @Override
    public String toString() {
        return "Client{" +
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
