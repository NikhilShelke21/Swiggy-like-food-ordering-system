package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.ResturantFood;
import com.helper.Connect;

import pojo.FoodPojo;
import pojo.ResturantPojo;

public class ResturantFoddimpl implements ResturantFood{
	Connection con=Connect.getConnect();
	PreparedStatement ps;
	@Override
	public List<FoodPojo> fetchFoodByRid(int rid) {
		List<FoodPojo> l=new ArrayList<FoodPojo>();
		try {
			String q="select * from food where fid in(select fid from RestaurantFood where rid=?)";
			ps=con.prepareStatement(q);
			ps.setInt(1, rid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodPojo foodPojo=new FoodPojo();
				foodPojo.setFid(rs.getInt("fid"));
				foodPojo.setFname(rs.getString("fname"));
				foodPojo.setPrice(rs.getFloat("price"));
				foodPojo.setDiscount(rs.getInt("discount"));
				foodPojo.setFprice(rs.getFloat("fprice"));
				foodPojo.setFimage(rs.getString("fimage"));
				foodPojo.setCategory(rs.getString("category"));
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
	public List<ResturantPojo> fetchResturantByFid(int fid) {
		List<ResturantPojo> l=new ArrayList<ResturantPojo>();
		try {
			String q="select * from resturant where rid in(select rid from RestaurantFood where fid=?)";
			ps=con.prepareStatement(q);
			ps.setInt(1, fid);
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
	
	public List<FoodPojo> fetchFoodByName(int rid,String fname){
		List<FoodPojo> l=fetchFoodByRid(rid);
		List<FoodPojo> ans=new ArrayList<FoodPojo>();
		for(FoodPojo f:l) {
			if(f.getFname().contains(fname)) {
				ans.add(f);
			}
		}
		return ans;
	}

}
