package com.example.mylocker.repository;

import com.example.mylocker.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LockerRepository extends JpaRepository<Locker, String> {

    Optional<Locker> findFirstByOrderByCreatedAtDesc();

}
