package com.project.service.internal;

import com.project.model.Organization;
import com.project.repository.OrganizationRepository;
import com.project.service.OrganizationInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationInternalServiceImpl implements OrganizationInternalService {



    private  final OrganizationRepository organizationRepository;
    @Override
    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public Organization findByPublicId(int id) {
        return null;
    }

    @Override
    public void deleteByPublicId(int id) {

    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return null;
    }
}
