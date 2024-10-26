package com.camt.olympic.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "Comments")
public class Comments {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    private int userId;
    private String username;

    @Column(columnDefinition = "TEXT")
    private String countryId;

    @Column(columnDefinition = "TEXT")
    private String commentText;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Column(length = 255)
    private String profileUri;



}