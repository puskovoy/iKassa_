package com.iKassa.entity;

import javax.persistence.*;


@Entity
@Table(name = "bags")
@NamedQuery(name = "BAG.getAll", query = "SELECT c from Bag c")
public class Bag extends Model{

    @Column(name = "number")
    private int number;
    @Column(name = "isFull")
    private int isFull;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clients;
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inkassator_id", referencedColumnName = "id")
    private Inkassator inkassator;*/

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

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    /*public Inkassator getInkassator() {
        return inkassator;
    }

    public void setInkassator(Inkassator inkassator) {
        this.inkassator = inkassator;
    }*/

    @Override
    public String toString() {
        return "Bag{" +
                "number=" + number +
                ", isFull=" + isFull +
                '}';
    }
}
