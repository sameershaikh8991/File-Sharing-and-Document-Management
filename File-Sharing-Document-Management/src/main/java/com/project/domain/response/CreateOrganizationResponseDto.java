package com.project.domain.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateOrganizationResponseDto(
        UUID publicId,String OrganizationName, LocalDateTime createdDate, LocalDateTime lastModifiedDate,
        String createdBy, String lastModifiedBy,String description, String organizationAddress,int numberOfEmployee,String email
        ,String phoneNo,String status) {
}
