package com.iKassa.entity;

import javax.persistence.*;

/**
 * Created by User on 029 29.02.16.
 */
@Entity
@Table(name="bags")
@NamedQuery(name="BAG.getAll", query="SELECT c from Bag c")
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "number")
    private int number;
    @Column(name = "isFull")
    private int isFull;

    public Bag(int number, int isFull) {
        this.number = number;
        this.isFull = isFull;
    }

    public Bag() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIsFull() {
        return isFull;
    }

    public void setIsFull(int isFull) {
        this.isFull = isFull;
    }
}
