package com.iKassa.entity;

import javax.persistence.*;

/**
 * Created by Shevtsov on 08.04.2016.
 */
@Entity
@Table(name="banks")
@NamedQuery(name="BANK.getAll", query="SELECT c from Bank c")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", length = 50)
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public Bank() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
