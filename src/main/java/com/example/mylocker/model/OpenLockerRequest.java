package com.example.mylocker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenLockerRequest {

    @NotBlank
    @Size( max = 100)
    private String userId;

    @NotBlank
    @Size( max = 100)
    private String lockerId;

    @NotBlank
    @Size( max = 100)
    private String password;
}
