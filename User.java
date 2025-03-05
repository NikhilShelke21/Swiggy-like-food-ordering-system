package com.dao;

import java.util.List;

import pojo.AddUserPojo;
import pojo.UserPojo;

public interface User {
public boolean register(UserPojo userPojo);
public boolean login(String email,String password);
public boolean addUser(AddUserPojo addUserPojo);
public List<AddUserPojo> showAllUser();
public boolean deleteUser(int id);
public boolean updateUser(AddUserPojo addUserPojo,int id);
public AddUserPojo getUserById(int id);
}
