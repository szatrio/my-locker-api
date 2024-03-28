package com.example.mylocker.service;

import com.example.mylocker.entity.Locker;
import com.example.mylocker.model.LockerResponse;
import com.example.mylocker.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
public class LockerService {

    @Autowired
    private LockerRepository lockerRepository;

    public LockerResponse create(){

        Locker locker = new Locker();
        locker.setId(UUID.randomUUID().toString());
        locker.setCode(generateCode());
        locker.setCreatedAt(getCurrentTimestamp());

        lockerRepository.save(locker);

        return LockerResponse.builder()
                .id(locker.getId())
                .code(locker.getCode())
                .createdAt(locker.getCreatedAt())
                .build();
    }

    private String generateCode(){

        String code;

        Locker locker = lockerRepository.findFirstByOrderByCreatedAtDesc()
                .orElse(null);

        return "";
    }

    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }


}
