package com.example.mylocker.service;

import com.example.mylocker.entity.Locker;
import com.example.mylocker.entity.User;
import com.example.mylocker.model.LockerResponse;
import com.example.mylocker.model.UserResponse;
import com.example.mylocker.repository.LockerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Slf4j
public class LockerService {

    @Autowired
    private LockerRepository lockerRepository;

    @Transactional
    public LockerResponse create(){

        Locker locker = new Locker();
        locker.setId(UUID.randomUUID().toString());
        locker.setCode(generateCode());
        locker.setCreatedAt(getCurrentTimestamp());

        lockerRepository.save(locker);

        return toLockerResponse(locker);
    }

    private LockerResponse toLockerResponse(Locker locker){
        return LockerResponse.builder()
                .id(locker.getId())
                .code(locker.getCode())
                .createdAt(locker.getCreatedAt())
                .build();
    }

    private String generateCode(){

        StringBuilder code = new StringBuilder("MLA-");

        Locker lastLocker = lockerRepository.findFirstByOrderByCreatedAtDesc()
                .orElse(null);

        if(lastLocker ==  null){
            code.append("00000");
        } else {
            String lastLockerNumber = lastLocker.getCode().replace("MLA-", "");
            try{
                int number = Integer.parseInt(lastLockerNumber)+1;
                String res = String.format("%05d", number);
                code.append(res);
            } catch (NumberFormatException e){
                System.out.println("NumberFormatException occurred");
            }
        }

        return code.toString();
    }

    @Transactional(readOnly = true)
    public List<LockerResponse> getList(){
        List<Locker> lockers = lockerRepository.findAll();

        return lockers.stream()
                .map(this::toLockerResponse)
                .toList();
    }

    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

}
