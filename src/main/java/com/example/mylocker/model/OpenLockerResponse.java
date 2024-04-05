package com.example.mylocker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenLockerResponse {

    private String id;

    private String userName;

    private String lockerCode;

    private Integer totalPayment;

    private Integer depositBack;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
