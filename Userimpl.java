package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.User;
import com.helper.Connect;

import pojo.AddUserPojo;
import pojo.UserPojo;

public class Userimpl implements User {
	Connection con=Connect.getConnect();
	PreparedStatement ps;
	@Override
	public boolean register(UserPojo userPojo) {
		// TODO Auto-generated method stub
		try {
			String q="insert into register(username,email,password)values(?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,userPojo.getUsername());
			ps.setString(2,userPojo.getEmail());
			ps.setString(3,userPojo.getPassword());
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
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		try {
			String q="select * from register where email=? and password=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
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
	public boolean addUser(AddUserPojo addUserPojo) {
		// TODO Auto-generated method stub
		try {
			String q="insert into user(fname,lname,email,contact,address) values(?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,addUserPojo.getFname());
			ps.setString(2,addUserPojo.getLname());
			ps.setString(3,addUserPojo.getEmail());
			ps.setString(4,addUserPojo.getContact());
			ps.setString(5,addUserPojo.getAddress());
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
	public List<AddUserPojo> showAllUser() {
		List<AddUserPojo> l=new ArrayList<AddUserPojo>();
		try {
			String q="select * from user";
			ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AddUserPojo addUserPojo =new AddUserPojo();
				addUserPojo.setUid(rs.getInt("uid"));
				addUserPojo.setFname(rs.getString("fname"));
				addUserPojo.setLname(rs.getString("lname"));
				addUserPojo.setEmail(rs.getString("email"));
				addUserPojo.setContact(rs.getString("contact"));
				addUserPojo.setAddress(rs.getString("address"));
				l.add(addUserPojo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public boolean deleteUser(int id) {
		try {
			String q="delete from user where uid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, id);
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
	public boolean updateUser(AddUserPojo addUserPojo,int id) {
		try {
			String q="update user set fname=?,lname=?,email=?,contact=?,address=? where uid=?";
			ps=con.prepareStatement(q);
			ps.setString(1,addUserPojo.getFname());
			ps.setString(2,addUserPojo.getLname());
			ps.setString(3,addUserPojo.getEmail());
			ps.setString(4,addUserPojo.getContact());
			ps.setString(5,addUserPojo.getAddress());
			ps.setInt(6, id);
			
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
	public AddUserPojo getUserById(int id) {
		AddUserPojo addUserPojo=new AddUserPojo();
		try {
			String q="select * from user where uid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				addUserPojo.setUid(rs.getInt("uid"));
				addUserPojo.setFname(rs.getString("fname"));
				addUserPojo.setLname(rs.getString("lname"));
				addUserPojo.setEmail(rs.getString("email"));
				addUserPojo.setContact(rs.getString("contact"));
				addUserPojo.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return addUserPojo;
	}
	
	public String getUsernameByEmail(String email) {
		String username=null;
		try {
			String q="select username from register where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				username=rs.getString("username");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return username;
	}

}
