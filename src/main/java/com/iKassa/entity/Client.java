package com.iKassa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="clients")
@NamedQuery(name="CLIENT.getAll", query="SELECT c from Client c")
public class Client extends Model{

    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "adres", length = 100)
    private String adres;
    @Column(name = "telefon", length = 60)
    private String telefon;
    @Column(name = "rahunok", length = 20)
    private String rahunok;
    @Column(name = "vihodnoi", length = 50)
    private String vihodnoi;
    @Column(name = "timeStopWork", length = 5)
    private int timeStopWork;
    @Column(name = "timeVisit", length = 5)
    private int timeVisit;
    @Column(name = "timevisit", length = 5)
    private int timeVisitSund;
    @Column(name = "kodNumber", length = 5)
    private int kodNumber;
    @ManyToMany(mappedBy = "clients")
    private Set<Route> route = new HashSet<Route>();
    @OneToMany(mappedBy = "clients")
    private Set<Bag> bag;
    @OneToOne(optional = false)
    @JoinColumn(name="card_id", unique = true, nullable = false, updatable = false)
    private Card card;

    public Client() {
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

    public int getKodNumber() {
        return kodNumber;
    }

    public void setKodNumber(int kodNumber) {
        this.kodNumber = kodNumber;
    }

    public Set<Bag> getBag() {
        return bag;
    }

    public void setBag(Set<Bag> bag) {
        this.bag = bag;
    }

    public Set<Route> getRoute() {
        return route;
    }

    public void setRoute(Set<Route> route) {
        this.route = route;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getVihodnoi() {
        return vihodnoi;
    }

    public void setVihodnoi(String vihodnoi) {
        this.vihodnoi = vihodnoi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getRahunok() {
        return rahunok;
    }

    public void setRahunok(String rahunok) {
        this.rahunok = rahunok;
    }

    public int getTimeStopWork() {
        return timeStopWork;
    }

    public void setTimeStopWork(int timeStopWork) {
        this.timeStopWork = timeStopWork;
    }

    public int getTimeVisit() {
        return timeVisit;
    }

    public void setTimeVisit(int timeVisit) {
        this.timeVisit = timeVisit;
    }

    public int getTimeVisitSund() {
        return timeVisitSund;
    }

    public void setTimeVisitSund(int timeVisitSund) {
        this.timeVisitSund = timeVisitSund;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", vihodnoi='" + vihodnoi + '\'' +
                ", adres='" + adres + '\'' +
                ", telefon='" + telefon + '\'' +
                ", rahunok='" + rahunok + '\'' +
                ", timeStopWork='" + timeStopWork + '\'' +
                ", timeVisit='" + timeVisit + '\'' +
                ", timeVisitSund=" + timeVisitSund +
                ", kodNumber=" + kodNumber +
                ", route=" + route +
                ", bag=" + bag +
                ", card=" + card +
                '}';
    }
}
