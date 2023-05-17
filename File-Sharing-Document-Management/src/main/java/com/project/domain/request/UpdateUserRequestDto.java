package com.project.domain.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequestDto {

    private String userName;

    //    @NotEmpty(message = "Rejection reason must be provided")
    private String userEmail;
}
