package com.example.mylocker.controller;

import com.example.mylocker.entity.User;
import com.example.mylocker.model.RegisterUserRequest;
import com.example.mylocker.model.UpdateUserRequest;
import com.example.mylocker.model.UserResponse;
import com.example.mylocker.model.WebResponse;
import com.example.mylocker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
        path = "/api/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> register(@RequestBody RegisterUserRequest request){
        UserResponse userResponse = userService.register(request);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @GetMapping(
            path = "/api/users/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> get(@PathVariable("userId") String userId ){
        UserResponse userResponse = userService.get(userId);
        return WebResponse.<UserResponse>builder()
                .data(userResponse)
                .build();
    }

    @PutMapping(
            path = "/api/users/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> update(@RequestBody UpdateUserRequest request,
                                            @PathVariable("userId") String userId
    ){
        request.setId(userId);

        UserResponse userResponse = userService.update(request);
        return WebResponse.<UserResponse>builder()
                .data(userResponse)
                .build();
    }
}
