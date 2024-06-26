package com.dao;
import java.sql.*;
import java.util.*;

import com.bean.User;

public class UserDao {
	public static List<User> getAllRecords(){
		List<User> list = new ArrayList<User>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from details");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setBname(rs.getString("bname"));
				u.setBno(rs.getInt("bno"));
				u.setCost(rs.getInt("cost"));
				u.setSeats(rs.getInt("seats"));
				u.setBoard(rs.getString("board"));
				u.setDest(rs.getString("dest"));
				u.setDate(rs.getString("jdate"));
				list.add(u);
			}
		}
		catch(Exception e){
			System.out.println(e);	
		}
		return list;
		
	}
	
	public static List<User> getFilteredRecords(String from, String to, String date) {
        List<User> list = new ArrayList<User>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "root");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM details WHERE board = ? AND dest = ? AND jdate = ?");
            ps.setString(1, from);
            ps.setString(2, to);
            ps.setString(3, date);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setBname(rs.getString("bname"));
                u.setBno(rs.getInt("bno"));
                u.setCost(rs.getInt("cost"));
                u.setSeats(rs.getInt("seats"));
                u.setBoard(rs.getString("board"));
                u.setDest(rs.getString("dest"));
                u.setDate(rs.getString("jdate"));
                list.add(u);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }
	
	public static User getUserById(int id){
		User u = new User();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from details where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				u.setId(rs.getInt("id"));
				u.setBname(rs.getString("bname"));
				u.setBno(rs.getInt("bno"));
				u.setCost(rs.getInt("cost"));
				u.setSeats(rs.getInt("seats"));
				u.setBoard(rs.getString("board"));
				u.setDest(rs.getString("dest"));
				u.setDate(rs.getString("jdate"));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return u;
	}
	
	public static void printUserDetails(int id){
		User u = getUserById(id);
		if(u.getId() != 0){
			System.out.println("User ID: " + u.getId());
			System.out.println("Busname: " + u.getBname());
			System.out.println("Busno: " + u.getBno());
			System.out.println("Cost: " + u.getCost());
			System.out.println("Seats: " + u.getSeats());
			System.out.println("Boarding: " + u.getBoard());
			System.out.println("Destination: " + u.getDest());
			System.out.println("Date: " + u.getDate());
			
		} else {
			System.out.println("Bus not found.");
		}
	}
	
}

