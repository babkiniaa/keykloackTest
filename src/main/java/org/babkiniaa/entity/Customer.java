package org.babkiniaa.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "customer")
@Comment("Покупатели автомобилей")
public class Customer extends PanacheEntity {

    @Column(name = "first_name", nullable = false, length = 100)
    public String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    public String lastName;

    @Column(name = "middle_name", length = 100)
    public String middleName;

    @Column(name = "phone", nullable = false, length = 20)
    public String phone;

    @Column(name = "email", unique = true, length = 100)
    public String email;

    @Column(name = "passport_series", length = 4)
    public String passportSeries;

    @Column(name = "passport_number", length = 6)
    public String passportNumber;

    @Column(name = "passport_issued_by", length = 500)
    public String passportIssuedBy;

    @Column(name = "passport_issued_date")
    @Temporal(TemporalType.DATE)
    public java.util.Date passportIssuedDate;

    @Column(name = "registration_address", length = 500)
    public String registrationAddress;

    @Column(name = "actual_address", length = 500)
    public String actualAddress;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    public java.util.Date birthDate;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date createdAt = new java.util.Date();

    public static Customer findCustomerByEmail(String email) {
        return find("email = ?1", email).stream()
                .findFirst()
                .map(ent -> (Customer) ent)
                .orElse(null);
    }
}
