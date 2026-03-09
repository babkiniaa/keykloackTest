package org.babkiniaa.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.babkiniaa.convector.LongToBooleanConverter;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "dealer_ship")
@Comment("Автосалон")
public class CarDealerShip extends PanacheEntity {

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

    @OneToMany(mappedBy = "dealerShip", fetch = FetchType.LAZY)
    public List<Car> carsInDealer = new ArrayList<>();

    public static CarDealerShip findDealerByNameAndCity(String name, String city) {
        return find("city = ?1 and name = ?2", city, name).stream()
                .findFirst()
                .map(ent -> (CarDealerShip) ent)
                .orElse(null);
    }

    public static List<CarDealerShip> findDealerByCity(String city) {
        return find("city = ?1", city).stream()
                .map(ent -> (CarDealerShip) ent)
                .collect(Collectors.toList());
    }

}
