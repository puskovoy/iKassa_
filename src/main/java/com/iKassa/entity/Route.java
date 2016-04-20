package com.iKassa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="routs")
@NamedQuery(name="ROUTE.getAll", query="SELECT c from Route c")
public class Route extends Model{
    @Column(name = "number")
    private int number;
    @ManyToMany
    @JoinTable(name="route_client",
            joinColumns = @JoinColumn(name="client_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="route_id", referencedColumnName="id"))
    private Set<Client> clients;
    /*@ManyToMany
    @JoinTable(name="route_inkassator",
            joinColumns = @JoinColumn(name="inkassator_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="route_id", referencedColumnName="id"))
    private Set<Inkassator> inkassatorSet;*/

    public Route() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

   /* public Set<Inkassator> getInkassatorSet() {
        return inkassatorSet;
    }

    public void setInkassatorSet(Set<Inkassator> inkassatorSet) {
        this.inkassatorSet = inkassatorSet;
    }*/

    @Override
    public String toString() {
        return "Route{" +
                "number=" + number +
                ", clients=" + clients +
                '}';
    }
}
