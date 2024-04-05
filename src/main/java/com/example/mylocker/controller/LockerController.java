package com.example.mylocker.controller;

import com.example.mylocker.entity.Locker;
import com.example.mylocker.model.LockerResponse;
import com.example.mylocker.model.RegisterUserRequest;
import com.example.mylocker.model.UserResponse;
import com.example.mylocker.model.WebResponse;
import com.example.mylocker.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LockerController {

    @Autowired
    private LockerService lockerService;

    @GetMapping(
            path = "/api/lockers",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<LockerResponse> create(){
        LockerResponse lockerResponse = lockerService.create();
        return WebResponse.<LockerResponse>builder().data(lockerResponse).build();
    }

    @GetMapping(
            path = "/api/lockers-list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<LockerResponse>> getList(){
        List<LockerResponse> lockerResponse = lockerService.getList();
        return WebResponse.<List<LockerResponse>>builder()
                .data(lockerResponse)
                .build();
    }


}
