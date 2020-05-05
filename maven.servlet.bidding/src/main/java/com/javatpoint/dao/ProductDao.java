 	package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.ProductBean;
import com.javatpoint.beans.BidProductBean;
import com.javatpoint.beans.BidderBean;

public class ProductDao {

	public static int save(ProductBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_Product values(?,?,?,?,?)");
			ps.setString(1,bean.getItemno());
			ps.setString(2,bean.getName());
			ps.setInt(3,bean.getQuantity());
			ps.setInt(4,bean.getPrice());
		//	ps.setInt(5,bean.getSoldout());
			ps.setInt(5,0);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<ProductBean> view(){
		List<ProductBean> list=new ArrayList<ProductBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_Product");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProductBean bean=new ProductBean();
				bean.setItemno(rs.getString("itemno"));
				bean.setName(rs.getString("name"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setPrice(rs.getInt("price"));
    			bean.setSoldout(rs.getInt("soldout"));
				
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int delete(String itemno){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from e_Product where itemno=?");
			ps.setString(1,itemno);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int getSoldout(String itemno){
		int soldout=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_Product where itemno=?");
			ps.setString(1,itemno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				soldout=rs.getInt("soldout");
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return soldout;
	}
	public static boolean checkQuantity(String itemno){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_Product where itemno=? and quantity>soldout");
			ps.setString(1,itemno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int Bid_Product(BidProductBean bean){
		String itemno=bean.getItemno();
		boolean checkqty=checkQuantity(itemno);
		System.out.println("Check quantiry: "+checkqty);
		if(checkqty){
			int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("insert into e_BidProduct values(?,?,?,?,?,?)");
				ps.setString(1,bean.getItemno());
				ps.setString(2,bean.getName());
				ps.setInt(3,bean.getBidprice());
				ps.setInt(4,bean.getBidderid());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5,currentDate);
				ps.setString(6,"no");
				
				status=ps.executeUpdate();
				
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}else{
			return 0;
		}
	}
	public static boolean checkPrice(String itemno){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_bidProduct where itemno=? and bidprice= max(bidprice)");
			ps.setString(1,itemno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int biddingStatus(BidProductBean bean){
		String itemno=bean.getItemno();
		String name=bean.getName();
		boolean checkprice=checkPrice(itemno);
		System.out.println("Check price: "+checkprice);
		if(checkprice){
			int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("update e_BidProduct set biddingstatus='close' where itemno=? and name=?");
				ps.setString(1,itemno);
				ps.setString(2,name);
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update e_Product set soldout=? where itemno=?");
					ps2.setInt(1,getSoldout(itemno)+1);
					ps2.setString(2,itemno);
					status=ps2.executeUpdate();
							}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}else{
		return 0;}
	}
	public static List<BidProductBean> viewSoldoutProducts(){
		List<BidProductBean> list=new ArrayList<BidProductBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_BidProduct order by biddingdate desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BidProductBean bean=new BidProductBean();
				bean.setItemno(rs.getString("itemno"));
				bean.setName(rs.getString("name"));
				bean.setBidprice(rs.getInt("bidprice"));
				bean.setBidderid(rs.getInt("bidderid"));
				bean.setBiddate(rs.getDate("biddate"));
				bean.setBiddingstatus(rs.getString("biddingstatus"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
}