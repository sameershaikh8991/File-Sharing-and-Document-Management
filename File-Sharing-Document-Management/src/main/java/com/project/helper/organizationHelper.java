package com.project.helper;

import com.project.domain.request.CreateOrganizationDto;
import com.project.model.Organization;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class organizationHelper {
    public organizationHelper() {
    }


    public  static Organization buildOrganization(CreateOrganizationDto createOrganizationDto){

        Organization organization = new Organization();

        organization.setPublicId(UUID.randomUUID());
        organization.setOrganizationName(createOrganizationDto.getOrganizationName());
        organization.setOrganizationAddress(createOrganizationDto.getOrganizationAddress());
        organization.setPhoneNo(createOrganizationDto.getPhoneNo());
        organization.setNumberOfEmployee(createOrganizationDto.getNumberOfEmployee());
        organization.setEmail(createOrganizationDto.getEmail());
        organization.setDescription(createOrganizationDto.getDescription());
        organization.setCreatedBy(organization.getCreatedBy());
        organization.setCreatedDate(LocalDateTime.now());
        organization.setStatus("ACTIVE");
        return organization;
    }


    public static CreateOrganizationDto buildOrganizationResponse(Organization organization){

    return  CreateOrganizationDto.builder()
                .OrganizationName(organization.getOrganizationName())
                .organizationAddress(organization.getOrganizationAddress())
                .email(organization.getEmail())
                .phoneNo(organization.getPhoneNo())
                .numberOfEmployee(organization.getNumberOfEmployee())
                .build();
    }
}
