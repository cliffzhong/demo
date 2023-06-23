package com.example.demo.entity;

import com.example.demo.dto.ManagerDto;
import com.example.demo.dto.ProductDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToMany(mappedBy = "productList")
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public ProductDto convertProductToProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(getId());
        productDto.setName(getName());
        productDto.setDescription(getDescription());
        productDto.setCreateDate(getCreateDate());
        return productDto;
    }

    public List<Client> getClientList() {
        if(clientList == null)
            clientList = new ArrayList<>();
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }


    public void addClient(Client client){
        client.getProductList().add(this);
        this.getClientList().add(client);
    }

//    public boolean removeClient(Client client){
//        boolean successfulFlag = client.getProductList().remove(this);
//        successfulFlag = this.getClientList().remove(client);
//        return successfulFlag;
//    }

        public void removeClient(Client client){
        this.getClientList().remove(client);
        client.getProductList().remove(this);

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
