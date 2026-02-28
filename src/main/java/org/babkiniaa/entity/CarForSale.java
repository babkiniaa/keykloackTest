package org.babkiniaa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "sale_car")
@Comment("Машины доступные для продажи")
public class CarForSale extends Car {

}
