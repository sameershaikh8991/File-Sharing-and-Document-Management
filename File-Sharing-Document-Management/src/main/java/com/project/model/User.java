package com.project.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String password;


	

}
