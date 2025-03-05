package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.Resturant;
import com.helper.Connect;

import pojo.AddUserPojo;
import pojo.ResturantPojo;

public class Resturantimpl implements Resturant {
	Connection con=Connect.getConnect();
	PreparedStatement ps;
	@Override
	public boolean addResturant(ResturantPojo resturantPojo) {
		try {
			String q="insert into resturant(name,location,rating,contact,rimage)values(?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,resturantPojo.getRname());
			ps.setString(2,resturantPojo.getRlocation());
			ps.setInt(3,resturantPojo.getRrating());
			ps.setString(4,resturantPojo.getRcontact());
			ps.setString(5,resturantPojo.getRimage());
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
	public List<ResturantPojo> showAllResturant() {
		List<ResturantPojo> l=new ArrayList<ResturantPojo>();
		try {
			String q="select * from resturant";
			ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ResturantPojo resturantPojo=new ResturantPojo();
				resturantPojo.setRid(rs.getInt("rid"));
				resturantPojo.setRname(rs.getString("name"));
				resturantPojo.setRlocation(rs.getString("location"));
				resturantPojo.setRrating(rs.getInt("rating"));
				resturantPojo.setRcontact(rs.getString("contact"));
				resturantPojo.setRimage(rs.getString("rimage"));
				l.add(resturantPojo);
				
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
			String q="delete from resturant where rid=?";
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
	
}
