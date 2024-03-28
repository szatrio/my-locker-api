package com.example.mylocker.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String id;

    private String name;

    private String phoneNumber;

    private String idNumber;

    private String email;

    private Integer totalDeposit;

    private Integer totalForfeit;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
