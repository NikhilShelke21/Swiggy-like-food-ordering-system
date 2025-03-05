package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.Address;
import com.helper.Connect;
import com.servlet.register_servlet;

import pojo.AddressPojo;

public class Addressimpl implements Address{
	Connection con=Connect.getConnect();
	PreparedStatement ps;
	@Override
	public boolean addAddress(String address,String email) {
		// TODO Auto-generated method stub
		try {
			String q="insert into address(address,email)values(?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,address);
			ps.setString(2,email);
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<AddressPojo> getAddressByEmail(String email) {
		List<AddressPojo> l=new ArrayList<AddressPojo>();
		try {
			String q="select * from address where email=? ";
			ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AddressPojo addressPojo=new AddressPojo();
				addressPojo.setAid(rs.getInt("aid"));
				addressPojo.setAddress(rs.getString("address"));
				addressPojo.setEmail(rs.getString("email"));
				l.add(addressPojo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public boolean deleteAddressById(int id) {
		try {
			String q="delete from address where aid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1,id);
			int x=ps.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
