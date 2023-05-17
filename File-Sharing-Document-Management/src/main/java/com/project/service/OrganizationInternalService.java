package com.project.service;

import com.project.model.Organization;

public interface OrganizationInternalService {

    Organization saveOrganization(Organization organization);

    Organization findByPublicId(int id);

    void deleteByPublicId(int id);

    Organization updateOrganization(Organization organization);


}
