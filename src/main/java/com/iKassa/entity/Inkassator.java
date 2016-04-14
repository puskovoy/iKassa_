package com.iKassa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 021 21.02.16.
 */
@Entity
@Table(name = "inkassators")
@NamedQuery(name = "INKASSATOR.getAll", query = "SELECT c from Inkassator c")
public class Inkassator extends Model{

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;
    @ManyToMany(mappedBy = "inkassatorSet")
    private Set<Car> carSet = new HashSet<Car>();
    /*@OneToMany(mappedBy = "inkassators")
    private Set<Card> cardSet;*/

    public Inkassator() {
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

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

    @Override
    public String toString() {
        return "Inkassator{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", carSet=" + carSet +
                '}';
    }
/*public Set<Card> getCardSet() {
        return cardSet;
    }

    public void setCardSet(Set<Card> cardSet) {
        this.cardSet = cardSet;
    }*/
}
