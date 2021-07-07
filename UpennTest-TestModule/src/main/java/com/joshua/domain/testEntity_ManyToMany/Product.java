package com.joshua.domain.testEntity_ManyToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "no")
    private Integer no;

    @Column (name = "name")
    private String name;

    @ManyToMany (mappedBy = "products")
    private List<Customer> customers = new ArrayList<Customer>();
}


