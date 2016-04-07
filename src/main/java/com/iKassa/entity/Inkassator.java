package com.iKassa.entity;

import javax.persistence.*;

/**
 * Created by User on 021 21.02.16.
 */
@Entity
@Table(name="inkassators")
@NamedQuery(name="INKASSATOR.getAll", query="SELECT c from Inkassator c")
public class Inkassator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;
    @Column(name = "bag")
    private int bag;
    @Column(name = "route")
    private int route;
    @Column(name = "card")
    private int card;

    public Inkassator(String name, String age, int bag, int route, int card) {
        this.name = name;
        this.age = age;
        this.bag = bag;
        this.route = route;
        this.card = card;
    }

    public Inkassator() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getBag() {
        return bag;
    }

    public void setBag(int bag) {
        this.bag = bag;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Inkassator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", bag=" + bag +
                ", route=" + route +
                ", card=" + card +
                '}';
    }
}