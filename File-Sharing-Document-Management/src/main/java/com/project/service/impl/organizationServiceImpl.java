package com.project.service.impl;

import com.project.domain.request.CreateOrganizationDto;
import com.project.domain.response.AppResponse;
import com.project.helper.organizationHelper;
import com.project.model.Organization;
import com.project.service.OrganizationInternalService;

import com.project.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class organizationServiceImpl implements OrganizationService {


    private  final OrganizationInternalService organizationInternalService;

    @Override
    public AppResponse saveOrganization(CreateOrganizationDto requestDto) {

        Organization organization = organizationHelper.buildOrganization(requestDto);

        Organization saveOrganization = organizationInternalService.saveOrganization(organization);

        CreateOrganizationDto createOrganizationDto = organizationHelper.buildOrganizationResponse(saveOrganization);

                return new AppResponse(HttpStatus.CREATED.value(),
                "Organization.created.successfully",
                "Organization.created.successfully",
                        createOrganizationDto, null);

    }

    @Override
    public AppResponse getByPublicId(int userId) {
        return null;
    }

    @Override
    public AppResponse deleteByPublicId(int userId) {
        return null;
    }
}
