package com.example.mylocker.controller;

import com.example.mylocker.model.*;
import com.example.mylocker.service.UserLockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLockerController {

    @Autowired
    private UserLockerService userLockerService;

    @PostMapping(
            path = "/api/book-locker",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BookLockerResponse> bookLocker(@RequestBody BookLockerRequest request){
        BookLockerResponse bookLockerResponse = userLockerService.bookLocker(request);
        return WebResponse.<BookLockerResponse>builder().data(bookLockerResponse).build();
    }

    @PostMapping(
            path = "/api/open-locker",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<OpenLockerResponse> openLocker(@RequestBody OpenLockerRequest request){
        OpenLockerResponse openLockerResponse = userLockerService.openLocker(request);
        return WebResponse.<OpenLockerResponse>builder().data(openLockerResponse).build();
    }
}
