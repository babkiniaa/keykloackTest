package org.babkiniaa.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "sale_car")
@Comment("Машины доступные для продажи")
public class CarForSale extends Car {

    @ManyToOne
    @JoinColumn(name = "seller_id_old", nullable = false)
    public Customer sellerIdOld;

}
