package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.Profile;
import com.helper.Connect;

import pojo.Profilepojo;

public class Profileimpl implements Profile{
	Connection con=Connect.getConnect();
	PreparedStatement ps;
	@Override
	public boolean addProfile(Profilepojo profilepojo) {
		// TODO Auto-generated method stub
		try {
			String q="insert into profile(name,contact,state,city,street,pincode,landmark,image,email) values(?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,profilepojo.getName());
			ps.setString(2,profilepojo.getContact());
			ps.setString(3,profilepojo.getState());
			ps.setString(4,profilepojo.getCity());
			ps.setString(5,profilepojo.getStreet());
			ps.setInt(6,profilepojo.getPincode());
			ps.setString(7,profilepojo.getLandmark());
			ps.setString(8,profilepojo.getImage());
			ps.setString(9,profilepojo.getEmail());
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
	public Profilepojo getProfileByEmail(String email) {
		Profilepojo profilepojo=new Profilepojo();
		try {
			String q="select * from profile where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				profilepojo.setPid(rs.getInt("pid"));
				profilepojo.setName(rs.getString("name"));
				profilepojo.setContact(rs.getString("contact"));
				profilepojo.setState(rs.getString("state"));
				profilepojo.setCity(rs.getString("city"));
				profilepojo.setStreet(rs.getString("street"));
				profilepojo.setPincode(rs.getInt("pincode"));
				profilepojo.setLandmark(rs.getString("landmark"));
				profilepojo.setImage(rs.getString("image"));
				profilepojo.setEmail(rs.getString("email"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return profilepojo;
	}
	@Override
	public boolean updateProfileByEmail(Profilepojo profilepojo) {
		try {
			String q="update profile set name=?,contact=?,state=?,city=?,street=?,pincode=?,landmark=?,image=? where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,profilepojo.getName());
			ps.setString(2,profilepojo.getContact());
			ps.setString(3,profilepojo.getState());
			ps.setString(4,profilepojo.getCity());
			ps.setString(5,profilepojo.getStreet());
			ps.setInt(6,profilepojo.getPincode());
			ps.setString(7,profilepojo.getLandmark());
			ps.setString(8,profilepojo.getImage());
			ps.setString(9,profilepojo.getEmail());
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
