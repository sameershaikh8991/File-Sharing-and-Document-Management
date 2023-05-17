package com.project.domain.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrganizationDto {


    private String OrganizationName;
    private  String description;

    private String organizationAddress;

    private int numberOfEmployee;

    private  String email;

    private String phoneNo;
}
