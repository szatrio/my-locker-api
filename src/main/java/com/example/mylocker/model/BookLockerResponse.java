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
public class BookLockerResponse {

    private String id;

    private String userName;

    private String lockerCode;

    private String password;

    private Timestamp createdAt;
}
