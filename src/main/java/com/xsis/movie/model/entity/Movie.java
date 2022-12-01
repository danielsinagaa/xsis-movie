package com.xsis.movie.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Table
@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private String image;
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = LocalDateTime.now();
    }
}
