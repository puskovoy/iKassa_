package com.iKassa.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 021 21.02.16.
 */
@Entity
@Table(name = "cars")
@NamedQuery(name = "CAR.getAll", query = "SELECT c from Car c")
public class Car extends Model{

    @Column(name = "number", length = 10)
    private String number;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "cost", length = 50)
    private float cost;
    @Column(name = "releaseDate", length = 50)
    private Date releaseDate;
    @ManyToMany
    @JoinTable(name="inkassator_car",
            joinColumns = @JoinColumn(name="inkassator_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="Car_id", referencedColumnName="id"))
    private Set<Inkassator> inkassatorSet = new HashSet<Inkassator>();

    public Car() {
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

    public Set<Inkassator> getInkassatorSet() {
        return inkassatorSet;
    }

    public void setInkassatorSet(Set<Inkassator> inkassatorSet) {
        this.inkassatorSet = inkassatorSet;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
