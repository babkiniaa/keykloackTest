package org.babkiniaa.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.babkiniaa.convector.LongToBooleanConverter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "dealer_ship")
@Comment("Автосалон")
public class CarDealerShip extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "city", nullable = false, length = 100)
    public String city;

    @Column(name = "full_address", nullable = false, length = 500)
    public String fullAddress;

    @Column(name = "phone", length = 20)
    public String phone;

    @Column(name = "email", length = 100)
    public String email;

    @Column(name = "name", nullable = false, length = 200)
    public String name;

    @Convert(converter = LongToBooleanConverter.class)
    @Column(name = "is_active", nullable = false, length = 200)
    public Boolean isActive = true;

}
