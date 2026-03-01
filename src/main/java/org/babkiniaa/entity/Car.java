package org.babkiniaa.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Date;

@Inheritance(strategy = InheritanceType.JOINED)
public class Car extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "description", length = 1000)
    public String description;

    @Column(name = "mark", nullable = false, length = 100)
    public String mark;

    @Column(name = "model", nullable = false, length = 100)
    public String model;

    @Column(name = "year_born", length = 4)
    public String yearsBorn;

    @Column(name = "url_photo", length = 500)
    public String urlPhoto;

    @Column(name = "mileage")
    public Long mileage;

    @Column(name = "amount", precision = 10, scale = 2)
    public Long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_ship_id", nullable = false)
    public CarDealerShip idDealerShip;

    @Column(name = "date_publication")
    @Temporal(TemporalType.TIMESTAMP)
    public Date datePublication;

}
