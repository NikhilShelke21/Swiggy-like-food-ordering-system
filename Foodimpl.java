package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.Food;
import com.helper.Connect;

import pojo.FoodPojo;

public class Foodimpl implements Food {
	Connection con=Connect.getConnect();
	PreparedStatement ps;

	@Override
	public boolean addFood(FoodPojo foodPojo) {
		// TODO Auto-generated method stub
		try {
			String q="insert into food(fname,price,discount,fprice,fimage,category,type)values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,foodPojo.getFname());
			ps.setFloat(2,foodPojo.getPrice());
			ps.setInt(3,foodPojo.getDiscount());
			ps.setFloat(4,foodPojo.getFprice());
			ps.setString(5,foodPojo.getFimage());
			ps.setString(6,foodPojo.getCategory());
			ps.setString(7,foodPojo.getType());
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
	public List<FoodPojo> getAllFood() {
		List<FoodPojo> l=new ArrayList<FoodPojo>();
		try {
			String q="select * from food";
			ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodPojo foodPojo=new FoodPojo();
				foodPojo.setFid(rs.getInt("fid"));
				foodPojo.setFname(rs.getString("fname"));
				foodPojo.setCategory(rs.getString("category"));
				foodPojo.setDiscount(rs.getInt("discount"));
				foodPojo.setFimage(rs.getString("fimage"));
				foodPojo.setFprice(rs.getFloat("fprice"));
				foodPojo.setPrice(rs.getFloat("price"));
				foodPojo.setType(rs.getString("type"));
				l.add(foodPojo);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public FoodPojo getFoodByfid(int fid) {
		FoodPojo foodPojo=new FoodPojo();
		try {
			String q="select * from food where fid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, fid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				foodPojo.setFid(rs.getInt("fid"));
				foodPojo.setFname(rs.getString("fname"));
				foodPojo.setCategory(rs.getString("category"));
				foodPojo.setDiscount(rs.getInt("discount"));
				foodPojo.setFimage(rs.getString("fimage"));
				foodPojo.setFprice(rs.getFloat("fprice"));
				foodPojo.setPrice(rs.getFloat("price"));
				foodPojo.setType(rs.getString("type"));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return foodPojo;
	}
	
	

}
