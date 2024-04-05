package com.example.mylocker.entity;

import jakarta.persistence.*;
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
@Table(name="user_lockers")
public class UserLocker {

    @Id
    private String id;

    private String password;

    @Column(name="password_used")
    private Integer passwordUsed;

    @Column(name="password_wrong")
    private Integer passwordWrong;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "locker_id", referencedColumnName = "id")
    private Locker locker;
}
