package com.project.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDto {

//    @NotEmpty(message = "Rejection reason must be provided")
    private String firstName;
    private String lastName;

//    @NotEmpty(message = "Rejection reason must be provided")
    private String email;
//    @NotEmpty(message = "Rejection reason must be provided")
    private String password;
}
