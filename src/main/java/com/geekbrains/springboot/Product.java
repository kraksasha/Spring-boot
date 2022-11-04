package com.geekbrains.springboot;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_title")
    private String title;
    @Column(name = "product_coast")
    private int coast;

    @ManyToMany
    @JoinTable(name = "products_and_buyers",
            joinColumns = @JoinColumn(name = "product_id_tab"),
            inverseJoinColumns = @JoinColumn(name = "buyers_id")
    )

    private List<Buyer> buyers;

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    @Override
    public String toString() {
        String allBuyers = "";
        for (Buyer o : buyers) {
            allBuyers += o.getName() + " ";
        }
        return "Product [" + id + " " + title + " " + coast + " " + allBuyers + "]";
    }

    public String toStringNet(){
        String allBuyers = "";
        for (Buyer o : buyers) {
            allBuyers += o.getName() + " ";
        }
        return "[ " + allBuyers + " ]";
    }
}

