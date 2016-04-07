package com.iKassa.entity;

import javax.persistence.*;

/**
 * Created by User on 021 21.02.16.
 */
@Entity
@Table(name="clients")
@NamedQuery(name="CLIENT.getAll", query="SELECT c from Client c")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "adres", length = 100)
    private String adres;
    @Column(name = "timevisit", length = 5)
    private int timeVisit;
    @Column(name = "kodNumber", length = 5)
    private int kodNumber;
    @Column(name = "Beg", length = 10)
    private int Beg;
    @Column(name = "route", length = 10)
    private int route;
    @Column(name = "cod", length = 10)
    private int cod;
    @Column(name = "card", length = 10)
    private int card;

    public Client(String name, String adres, int timeVisit, int kodNumber, int beg, int route, int cod, int card) {
        this.name = name;
        this.adres = adres;
        this.timeVisit = timeVisit;
        this.kodNumber = kodNumber;
        Beg = beg;
        this.route = route;
        this.cod = cod;
        this.card = card;
    }

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getTimeVisit() {
        return timeVisit;
    }

    public void setTimeVisit(int timeVisit) {
        this.timeVisit = timeVisit;
    }

    public int getKodNumber() {
        return kodNumber;
    }

    public void setKodNumber(int kodNumber) {
        this.kodNumber = kodNumber;
    }

    public int getBeg() {
        return Beg;
    }

    public void setBeg(int beg) {
        Beg = beg;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adres='" + adres + '\'' +
                ", timeVisit=" + timeVisit +
                ", kodNumber=" + kodNumber +
                ", Beg=" + Beg +
                ", route=" + route +
                ", cod=" + cod +
                ", card=" + card +
                '}';
    }
}
