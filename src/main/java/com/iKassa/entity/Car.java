package com.iKassa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 021 21.02.16.
 */
@Entity
@Table(name="cars")
@NamedQuery(name="CAR.getAll", query="SELECT c from Car c")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "number", length = 10)
    private String number;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "cost", length = 50)
    private float cost;
    @Column(name = "releaseDate", length = 50)
    private Date releaseDate;

    public Car(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
