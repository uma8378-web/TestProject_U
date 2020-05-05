package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.BidderBean;

public class BidderDao {

	public static int save(BidderBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_bidder(name,email,postal,mobile) values(?,?,?,?)");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPostal());
			ps.setLong(4,bean.getMobile());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int update(BidderBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update e_bidder set name=?,email=?,postal=?,mobile=? where id=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPostal());
			ps.setLong(4,bean.getMobile());
			ps.setInt(5,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<BidderBean> view(){
		List<BidderBean> list=new ArrayList<BidderBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_bidder");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BidderBean bean=new BidderBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPostal(rs.getString("postal"));
				bean.setMobile(rs.getLong("mobile"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static BidderBean viewById(int id){
		BidderBean bean=new BidderBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_bidder where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPostal(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getLong(5));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from e_bidder where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	} 

	public static boolean authenticate(String email,String postal){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_bidder where email=? and postal=?");
			ps.setString(1,email);
			ps.setString(2,postal);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}
