package com.joshua.domain.testEntity_ManyToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="no")
    private Integer no;

    @Column (name = "id")
    private String id;

    @ManyToMany
    @JoinTable (name = "customer_product",
            joinColumns = @JoinColumn (name = "customer_no"),
            inverseJoinColumns = @JoinColumn (name = "product_no"))
    private List<Product> products = new ArrayList<Product>();

}
