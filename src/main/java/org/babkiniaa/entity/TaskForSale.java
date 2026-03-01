package org.babkiniaa.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "sale_task")
@Comment("Заявка на выставку машину на продажу в определенный салон")
public class TaskForSale extends Car {

    @Column(name = "status", length = 50, nullable = false)
    public String status = "pending";

    @Column(name = "seller_id")
    public Customer sellerId;

    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date requestDate = new java.util.Date();

    @Column(name = "comment", length = 500)
    @Comment("Комментарий к заявке")
    public String comment;
}
