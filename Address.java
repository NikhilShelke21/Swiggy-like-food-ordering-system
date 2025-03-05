package com.dao;

import java.util.List;

import pojo.AddressPojo;

public interface Address {
public boolean addAddress(String address,String email);
public List<AddressPojo> getAddressByEmail(String email);
public boolean deleteAddressById(int id);
}
