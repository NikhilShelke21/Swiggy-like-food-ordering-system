package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.helper.Connect;

import pojo.Profilepojo;

public interface Profile {
	
public boolean addProfile(Profilepojo profilepojo);
public Profilepojo getProfileByEmail(String email);
public boolean updateProfileByEmail(Profilepojo profilepojo);
	

}
