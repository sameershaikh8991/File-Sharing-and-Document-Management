package com.project.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String userEmail;
	private String password;


	

}
