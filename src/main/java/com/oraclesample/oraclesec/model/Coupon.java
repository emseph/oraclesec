package com.oraclesample.oraclesec.model;

import javax.persistence.*;

@Entity
public class Coupon {

    @Id
    @SequenceGenerator(name = "COUPON_SEQ", sequenceName = "COUPON_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUPON_SEQ")
    @Column(name = "coupon_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float disc;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Coupon(int id, String name, float disc, Event event, Category category) {
        this.id = id;
        this.name = name;
        this.disc = disc;
        this.event = event;
        this.category = category;
    }

    public Coupon() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDisc() {
        return disc;
    }

    public void setDisc(float disc) {
        this.disc = disc;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
