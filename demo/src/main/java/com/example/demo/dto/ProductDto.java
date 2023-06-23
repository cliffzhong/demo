package com.example.demo.dto;

import com.example.demo.entity.Manager;
import com.example.demo.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private LocalDate createDate;

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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<ClientDto> getClientDtoList() {
        return clientDtoList;
    }

    public void setClientDtoList(List<ClientDto> clientDtoList) {
        this.clientDtoList = clientDtoList;
    }

    public Product convertProductDtoToProduct(){
        Product product = new Product();
        if(getId() != null)
            product.setId(getId());
        product.setName(getName());
        product.setDescription(getDescription());
        product.setCreateDate(getCreateDate());
        return product;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
