package com.iKassa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="routs")
@NamedQuery(name="ROUTE.getAll", query="SELECT c from Route c")
public class Route extends Model{
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "number")
    private int number;
    @ManyToMany
    @JoinTable(name="route_client",
            joinColumns = @JoinColumn(name="client_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="route_id", referencedColumnName="id"))
    private Set<Client> clients;

    public Route() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
