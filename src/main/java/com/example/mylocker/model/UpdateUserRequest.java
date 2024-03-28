package com.example.mylocker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UpdateUserRequest {

    @JsonIgnore
    @NotBlank
    private String id;

    @Size( max = 100)
    private String name;

    @Size( max = 100)
    private String phoneNumber;

    @Size( max = 100)
    private String idNumber;

    @Size( max = 100)
    private String email;
}
