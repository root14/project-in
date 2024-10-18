package com.root14.projectin.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "expense")
@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Column(name = "price")
    private String price;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @CreatedDate
    @Column(name = "created_at")
    private Instant created;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
