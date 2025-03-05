package com.dao;

import java.util.List;

import pojo.FoodPojo;

public interface Food {
public boolean addFood(FoodPojo foodPojo);
public List<FoodPojo> getAllFood();
public FoodPojo getFoodByfid(int fid);
}
