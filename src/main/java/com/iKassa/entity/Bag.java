package com.iKassa.entity;

import javax.persistence.*;

/**
 * Created by User on 029 29.02.16.
 */
@Entity
@Table(name = "bags")
@NamedQuery(name = "BAG.getAll", query = "SELECT c from Bag c")
public class Bag extends Model{

    @Column(name = "number")
    private int number;
    @Column(name = "isFull")
    private int isFull;
    @Column(name = "route")
    private int route;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clients;

    public Bag() {
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

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "number=" + number +
                ", isFull=" + isFull +
                ", route=" + route +
                ", clients=" + clients +
                '}';
    }
}
