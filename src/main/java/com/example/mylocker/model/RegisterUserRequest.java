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
public class RegisterUserRequest {

    @NotBlank
    @Size( max = 100)
    private String name;

    @NotBlank
    @Size( max = 100)
    private String phoneNumber;

    @NotBlank
    @Size( max = 100)
    private String idNumber;

    @NotBlank
    @Size( max = 100)
    private String email;
}
