package com.project.service;

import com.project.domain.request.CreateOrganizationDto;
import com.project.domain.response.AppResponse;

public interface OrganizationService {

    AppResponse saveOrganization(CreateOrganizationDto requestDto);

    AppResponse getByPublicId(int userId);

    AppResponse deleteByPublicId(int userId);

//    AppResponse updateOrganization(UpdateUserRequestDto requestDto, int userId);





}



