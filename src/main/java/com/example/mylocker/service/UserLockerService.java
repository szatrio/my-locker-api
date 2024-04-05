package com.example.mylocker.service;

import com.example.mylocker.entity.Locker;
import com.example.mylocker.entity.User;
import com.example.mylocker.entity.UserLocker;
import com.example.mylocker.model.BookLockerRequest;
import com.example.mylocker.model.BookLockerResponse;
import com.example.mylocker.model.OpenLockerRequest;
import com.example.mylocker.model.OpenLockerResponse;
import com.example.mylocker.repository.LockerRepository;
import com.example.mylocker.repository.UserLockerRepository;
import com.example.mylocker.repository.UserRepository;
import com.example.mylocker.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
public class UserLockerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LockerRepository lockerRepository;

    @Autowired
    private UserLockerRepository userLockerRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public BookLockerResponse bookLocker(BookLockerRequest request){
        validationService.validate(request);

        User user = userRepository.findById(request.getLockerId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Locker locker = lockerRepository.findById(request.getLockerId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locker not found"));

        userLockerRepository.findFirstByLocker(locker)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locker already in use"));

        long userLockerMaxCheck = userLockerRepository.countByUser(user);

        if (Math.toIntExact(userLockerMaxCheck) >= 3){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user has maximum number to book a lockers");
        }

        String password = generatePassword();

        UserLocker userLocker = new UserLocker();
        userLocker.setId(UUID.randomUUID().toString());
        userLocker.setUser(user);
        userLocker.setLocker(locker);
        userLocker.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        userLocker.setPasswordUsed(0);
        userLocker.setPasswordWrong(0);
        userLocker.setCreatedAt(getCurrentTimestamp());

        userLockerRepository.save(userLocker);

        return BookLockerResponse.builder()
                .id(userLocker.getId())
                .userName(userLocker.getUser().getName())
                .lockerCode(userLocker.getLocker().getCode())
                .password(password)
                .createdAt(userLocker.getCreatedAt())
                .build();
    }

    private static String generatePassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num = "0123456789";
        String specialChar = "!@#%";
        String combination = upper + upper.toLowerCase() + num + specialChar;
        int len = 6;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(combination.charAt(
                    ThreadLocalRandom.current().nextInt(
                            combination.length()
                    )
            ));
        }
        return sb.toString();
    }

    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    @Transactional
    public OpenLockerResponse openLocker(OpenLockerRequest request){
        validationService.validate(request);

        User user = userRepository.findById(request.getLockerId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Locker locker = lockerRepository.findById(request.getLockerId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locker not found"));

        UserLocker userLocker = userLockerRepository.findFirstByLockerAndUser(locker, user)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locker not found"));

        int totalPayment = 0;

        if(!BCrypt.checkpw(request.getPassword(), userLocker.getPassword())){
            userLocker.setPasswordWrong(userLocker.getPasswordWrong() + 1);
            userLocker.setUpdatedAt(userLocker.getUpdatedAt());
            userLockerRepository.save(userLocker);

            if(userLocker.getPasswordWrong() > 3){
                return OpenLockerResponse.builder()
                        .id(userLocker.getId())
                        .userName(userLocker.getUser().getName())
                        .lockerCode(userLocker.getLocker().getCode())
                        .totalPayment(25000)
                        .depositBack(0)
                        .createdAt(userLocker.getCreatedAt())
                        .updatedAt(userLocker.getUpdatedAt())
                        .build();
            }

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }

        int passwordUsed = userLocker.getPasswordUsed() + 1;
        int deposit = 10000;

        long difTime = getCurrentTimestamp().getTime() - userLocker.getCreatedAt().getTime();
        long daysLong = TimeUnit.MILLISECONDS.toDays(difTime);
        int days = Math.toIntExact(daysLong);

        if(days > 1){
            totalPayment = 5000 * (days-1);
        }

        if(totalPayment > deposit){
            totalPayment = totalPayment - deposit;
        }

        userLocker.setPasswordUsed(passwordUsed);
        userLocker.setUpdatedAt(getCurrentTimestamp());

        userLockerRepository.save(userLocker);

        if (passwordUsed < 2){
            userLockerRepository.delete(userLocker);
        }

        return OpenLockerResponse.builder()
                .id(userLocker.getId())
                .userName(userLocker.getUser().getName())
                .lockerCode(userLocker.getLocker().getCode())
                .totalPayment(totalPayment)
                .depositBack(deposit)
                .createdAt(userLocker.getCreatedAt())
                .updatedAt(userLocker.getUpdatedAt())
                .build();
    }
}
