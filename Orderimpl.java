package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dao.Order;
import com.helper.Connect;

import pojo.OrderPojo;

public class Orderimpl implements Order{
	Connection con=Connect.getConnect();
	PreparedStatement ps;
	@Override
	public boolean placeOrder(OrderPojo orderPojo) {
		// TODO Auto-generated method stub
		try {
			String q="insert into orders(name,price,quantity,tprice,email,image,status)values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setString(1,orderPojo.getName());
			ps.setFloat(2,orderPojo.getPrice());
			ps.setInt(3,orderPojo.getQuantity());
			ps.setFloat(4, orderPojo.getTprice());
			ps.setString(5,orderPojo.getEmail());
			ps.setString(6,orderPojo.getImage());
			ps.setString(7,orderPojo.getStatus());
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
