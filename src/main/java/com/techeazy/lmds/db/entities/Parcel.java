package com.techeazy.lmds.db.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "parcels")
@Data
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(nullable = false)
    private String address;

    @Column(name = "customer_contact_number", nullable = false)
    private String customerContactNumber;

    @Column(nullable = false)
    private String dimensions;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "logistics_plan_id")
    private LogisticsPlan logisticsPlan;

}
