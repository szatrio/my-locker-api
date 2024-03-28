package com.example.mylocker.service;

import com.example.mylocker.entity.User;
import com.example.mylocker.model.RegisterUserRequest;
import com.example.mylocker.model.UpdateUserRequest;
import com.example.mylocker.model.UserResponse;
import com.example.mylocker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public UserResponse register(RegisterUserRequest request){
        validationService.validate(request);

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(request.getName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setIdNumber(request.getIdNumber());
        user.setEmail(request.getEmail());
        user.setTotalDeposit(0);
        user.setTotalForfeit(0);
        user.setCreatedAt(getCurrentTimestamp());

        userRepository.save(user);

        return toUserResponse(user);
    }

    private UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .idNumber(user.getIdNumber())
                .email(user.getEmail())
                .totalDeposit(user.getTotalDeposit())
                .totalForfeit(user.getTotalForfeit())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
    private Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    @Transactional(readOnly = true)
    public UserResponse get(String id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return toUserResponse(user);
    }

    @Transactional
    public UserResponse update(UpdateUserRequest request){
        validationService.validate(request);

        User user = userRepository.findById(request.getId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        user.setName(request.getName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setIdNumber(request.getIdNumber());
        user.setEmail(request.getEmail());
        user.setUpdatedAt(getCurrentTimestamp());
        userRepository.save(user);

        return toUserResponse(user);
    }
}
