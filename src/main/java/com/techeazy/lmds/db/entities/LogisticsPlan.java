package com.techeazy.lmds.db.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "logistics_plans")
@Data
public class LogisticsPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "logisticsPlan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Parcel> groupedParcels;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private User driver;

    @Column(name = "plan_date", nullable = false)
    private LocalDateTime planDate;

    @Column(nullable = false)
    private String status;
}
