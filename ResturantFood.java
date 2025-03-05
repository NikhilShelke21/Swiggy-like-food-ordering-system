package com.dao;

import java.util.List;

import pojo.FoodPojo;
import pojo.ResturantPojo;

public interface ResturantFood {
public List<FoodPojo> fetchFoodByRid(int rid);
public List<ResturantPojo> fetchResturantByFid(int fid);
}
