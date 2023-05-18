package com.project.controller;


import com.project.domain.request.CreateOrganizationDto;
import com.project.domain.response.AppResponse;
import com.project.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/org")
@RequiredArgsConstructor
public class OrganizationController {


    private final OrganizationService organizationService;

    @PostMapping(value = "/saveOrg")
    public ResponseEntity<AppResponse> saveUser(@RequestBody CreateOrganizationDto requestDto) {

        AppResponse appResponse = organizationService.saveOrganization(requestDto);
        return ResponseEntity.ok().body(appResponse);
    }

}
