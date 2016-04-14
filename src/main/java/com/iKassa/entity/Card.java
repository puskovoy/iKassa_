package com.iKassa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shevtsov on 12.04.2016.
 */
@Entity
@Table(name="cards")
@NamedQuery(name = "CARD.getAll", query = "SELECT c from Card c")
public class Card extends Model {

    @Column(name = "number")
    private String number;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inkassator_id", referencedColumnName = "id")
    private ServletInkassator inkassator;*/

    public Card() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /*public ServletInkassator getInkassator() {
        return inkassator;
    }

    public void setInkassator(ServletInkassator inkassator) {
        this.inkassator = inkassator;
    }*/
}
