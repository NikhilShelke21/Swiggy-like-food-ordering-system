package com.dao;

import java.util.List;

import pojo.ResturantPojo;

public interface Resturant {
public boolean addResturant(ResturantPojo resturantPojo);
public List<ResturantPojo> showAllResturant();
public boolean deleteUser(int id);
}
