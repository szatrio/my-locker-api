package com.example.mylocker.repository;

import com.example.mylocker.entity.Locker;
import com.example.mylocker.entity.User;
import com.example.mylocker.entity.UserLocker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLockerRepository  extends JpaRepository<UserLocker, String> {

    Optional<UserLocker> findFirstByLocker(Locker locker);

    Optional<UserLocker> findFirstByLockerAndUser(Locker locker, User user);

    long countByUser(User user);
}
