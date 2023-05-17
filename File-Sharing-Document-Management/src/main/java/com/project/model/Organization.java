package com.project.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "organization_info")
public class Organization extends BaseEntity {


    private String OrganizationName;

    private  String description;

    private String organizationAddress;

    private int numberOfEmployee;

    private  String email;

    private String phoneNo;

    private String status;



}
