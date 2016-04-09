package com.iKassa.entity;

import javax.persistence.*;

/**
 * Created by Shevtsov on 08.04.2016.
 */
@Entity
@Table(name="routs")
@NamedQuery(name="ROUTE.getAll", query="SELECT c from Route c")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "number")
    private int number;

    public Route(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Route() {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
