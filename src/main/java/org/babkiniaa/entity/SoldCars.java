package org.babkiniaa.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.util.Date;

@Entity
@Table(name = "sold_car")
@Comment("Проданные автомобили")
public class SoldCars extends Car {

    @Column(name = "seller_id_old", nullable = false)
    public Customer sellerIdOld;

    @Column(name = "seller_id_new", nullable = false)
    public Customer sellerIdNew;

    @Column(name = "date_sold", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date dateSold;


}
