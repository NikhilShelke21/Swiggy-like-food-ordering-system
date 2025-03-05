package daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.helper.Connect;

public class SendEmail {
	

	
	public boolean sendmail(String from,String to,String sub,String text) {
		boolean f=false;
		Properties prop=new Properties();
		prop.put("mail.smtp.auth",true);
		prop.put("mail.smtp.starttls.enable",true);
		prop.put("mail.smtp.port","587");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.protocols","TLSv1.2");
		
		String username="carts195@gmail.com";
		String password="ymibobldqigmvzjn";
		
		Session session=Session.getInstance(prop,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message msg=new MimeMessage(session);
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			msg.setFrom(new InternetAddress(from,"Shoppify"));
			msg.setSubject(sub);
//			msg.setText(text);
			text="<h1>"+text+"</h1>";
			msg.setContent(text, "text/html; charset=utf-8");
			Transport.send(msg);
			f=true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	Connection con=Connect.getConnect();
	PreparedStatement ps;
	public boolean storeOtp(String otp) {
		try {
			String q="insert into otp(otp) values(?)";
			ps=con.prepareStatement(q);
			ps.setString(1,otp);
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
	
	public String getOtp() {
		String otp=null;
		try {
			String q="select otp from otp order by time desc limit 1";
			ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				otp=rs.getString("otp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return otp;
	}
	public String getTime() {
		String time=null;
		try {
			String q="select time from otp order by time desc limit 1";
			ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				time=rs.getString("time");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return time;
	}
	
	}


