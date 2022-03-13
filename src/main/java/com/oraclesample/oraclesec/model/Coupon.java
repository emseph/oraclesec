package com.oraclesample.oraclesec.model;

import javax.persistence.*;

@Entity
public class Coupon {

    @Id
    @SequenceGenerator(name = "COUPON_SEQ", sequenceName = "COUPON_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUPON_SEQ")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float disc;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    private Event event;

    public Coupon(int id, String name, float disc) {
        super();
        this.id = id;
        this.name = name;
        this.disc = disc;
    }

    public Coupon() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDisc() {
        return this.disc;
    }

    public void setDisc(float disc) {
        this.disc = disc;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
