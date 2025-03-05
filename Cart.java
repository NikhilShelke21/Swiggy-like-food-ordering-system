package com.dao;

import java.util.List;

import pojo.Cartpojo;

public interface Cart {
public boolean addCart(Cartpojo cartpojo);
public List<Cartpojo> getCartByEmail(String email);
public float getTotalByEmail(String email);
public float getOpriceByEmail(String email);
public boolean increaseQuantity(int cid);
}
