package com.iKassa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 021 21.02.16.
 */
@Entity
@Table(name="clients")
@NamedQuery(name="CLIENT.getAll", query="SELECT c from Client c")
public class Client extends Model{

    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "adres", length = 100)
    private String adres;
    @Column(name = "timevisit", length = 5)
    private int timeVisit;
    @Column(name = "kodNumber", length = 5)
    private int kodNumber;
    /*@ManyToMany(mappedBy = "clients")
    private Set<Route> route = new HashSet<Route>();*/
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

    public Set<Bag> getBag() {
        return bag;
    }

    public void setBag(Set<Bag> bag) {
        this.bag = bag;
    }

   /* public Set<Route> getRoute() {
        return route;
    }

    public void setRoute(Set<Route> route) {
        this.route = route;
    }*/

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", adres='" + adres + '\'' +
                ", timeVisit=" + timeVisit +
                ", kodNumber=" + kodNumber +
                ", card=" + card +
                ", bag=" + bag +
                '}';
    }
}
