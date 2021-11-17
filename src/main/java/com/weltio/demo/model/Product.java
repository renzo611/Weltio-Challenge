package com.weltio.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private float price;
    @NotNull
    private Long cuantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @Temporal(TemporalType.DATE)
    private Date creationTime;

    @PrePersist
    private void initDate(){
        creationTime = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return this.name.toUpperCase().equals(((Product) o).getName().toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
