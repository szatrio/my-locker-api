package com.example.mylocker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    private String id;

    private String name;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="id_number")
    private String idNumber;

    private String email;

    @Column(name="total_deposit")
    private Integer totalDeposit;

    @Column(name="total_forfeit")
    private Integer totalForfeit;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;
}
