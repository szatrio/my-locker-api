package com.example.mylocker.service;

import com.example.mylocker.entity.Locker;
import com.example.mylocker.model.LockerResponse;
import com.example.mylocker.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.UUID;

@Service
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

        if(lastLocker == null){
            code.append("00000");
        } else {
            String lastLockerNumber = lastLocker.getCode().replace("MLA-", "");

            try{
                int number = Integer.parseInt(lastLockerNumber);
                String strNumber = Integer.toString(number);
                code.append("0".repeat(Math.max(0, 5 - strNumber.length())));
                code.append(strNumber);
            } catch (NumberFormatException e){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Generate locker code failed");
            }
        }

        return code.toString();
    }

    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

}
