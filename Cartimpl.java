package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.Cart;
import com.helper.Connect;

import pojo.Cartpojo;

public class Cartimpl implements Cart {
	Connection con=Connect.getConnect();
	PreparedStatement ps;

	@Override
	public boolean addCart(Cartpojo cartpojo) {
		// TODO Auto-generated method stub
		try {
			String q="insert into cart(fid,fname,price,quantity,email,fimage,oprice)values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setInt(1,cartpojo.getFid());
			ps.setString(2,cartpojo.getFname());
			ps.setFloat(3,cartpojo.getPrice());
			ps.setInt(4,cartpojo.getQuantity());
			
			ps.setString(5,cartpojo.getEmail());
			ps.setString(6,cartpojo.getFimage());
			ps.setFloat(7,cartpojo.getOprice());
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
	public List<Cartpojo> getCartByEmail(String email) {
		List<Cartpojo> l=new ArrayList<Cartpojo>();
		try {
			String q="select * from cart where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Cartpojo cartpojo=new Cartpojo();
				cartpojo.setCid(rs.getInt("cid"));
				cartpojo.setFid(rs.getInt("fid"));
				cartpojo.setFname(rs.getString("fname"));
				cartpojo.setPrice(rs.getFloat("price"));
				cartpojo.setQuantity(rs.getInt("quantity"));
				cartpojo.setTprice(rs.getFloat("tprice"));
				cartpojo.setEmail(rs.getString("email"));
				cartpojo.setFimage(rs.getString("fimage"));
				l.add(cartpojo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public float getTotalByEmail(String email) {
		float amt=0;
		try {
			String q="select sum(tprice) as tprice from cart where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				amt=rs.getFloat("tprice");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return amt;
	}

	@Override
	public boolean increaseQuantity(int cid) {
		try {
			String q="update cart set quantity=quantity+1 where cid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, cid);
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
	
	public boolean decreaseQuantity(int cid) {
		int quantity=getQuantityByCart(cid);
		if(quantity>1) {
		try {
			String q="update cart set quantity=quantity-1 where cid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, cid);
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
		}
		return false;
	}
	
	public int getQuantityByCart(int cid) {
		int quantity=0;
		try {
			String q="select quantity from cart where cid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1,cid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				quantity=rs.getInt("quantity");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return quantity;
	}
	
	public int checkItemIsExistOrNot(int fid,String email) {
		int cid=0;
		try {
			String q="select cid from cart where fid=? and email=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, fid);
			ps.setString(2,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				cid=rs.getInt("cid");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cid;
	}
	public boolean deleteCartByCid(int cid) {
		try {
			String q="delete from cart where cid=?";
			ps=con.prepareStatement(q);
			ps.setInt(1, cid);
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
	public float getOpriceByEmail(String email) {
		float amt=0;
		try {
			String q="select sum(oprice) as oprice from cart where email=?";
			ps=con.prepareStatement(q);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				amt=rs.getFloat("oprice");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return amt;
	}

}
