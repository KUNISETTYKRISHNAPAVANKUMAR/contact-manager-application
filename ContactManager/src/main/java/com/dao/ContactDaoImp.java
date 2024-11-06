package com.dao;

import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.conn.DBConnection;
import com.model.Contact;

import jakarta.servlet.http.HttpSession;

public class ContactDaoImp implements ContactDAO{
	public boolean create(Contact contact) {
		String query="INSERT INTO contact(userId,name,phone,address,about) VALUES(?,?,?,?,?)";
		try (
				Connection connection=DBConnection.getConn();
				PreparedStatement stmt=connection.prepareStatement(query);
				){
			stmt.setInt(1, contact.getUserId());
			stmt.setString(2, contact.getName());
			stmt.setString(3, contact.getPhone());
			stmt.setString(4, contact.getEmail());
			stmt.setString(5, contact.getAbout());

			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Contact> getAllContacts(int id){
		String query="SELECT * FROM contact WHERE userId=?";
		try (
				Connection connection=DBConnection.getConn();
				PreparedStatement stmt=connection.prepareStatement(query);
				){
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			ArrayList<Contact>list=new ArrayList<>();
			while(rs.next()) {
				Contact c=new Contact();
				c.setAbout(rs.getString("about"));
				c.setEmail(rs.getString("address"));
				c.setName(rs.getString("name"));
				c.setUserId(rs.getInt("userId"));
				c.setPhone(rs.getString("phone"));
				c.setId(rs.getInt(id));
				list.add(c);
			}
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
		return null;
	}
	public Contact getContact(int id) {
		String query="SELECT * FROM contact WHERE id=?";
		try(
				Connection connection=DBConnection.getConn();
				PreparedStatement stmt=connection.prepareStatement(query);
				) {
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			Contact c =new Contact();
			c.setAbout(rs.getString("about"));
			c.setEmail(rs.getString("address"));
			c.setName(rs.getString("name"));
			c.setUserId(rs.getInt("userId"));
			c.setPhone(rs.getString("phone"));
			return c;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public boolean editContact(Contact c) {
		String query="UPDATE contact SET name=?,address=?,phone=?,about=? WHERE id=?";
		try(
				Connection connection=DBConnection.getConn();
				PreparedStatement stmt=connection.prepareStatement(query);
				) {
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getPhone());
			stmt.setString(4, c.getAbout());
			stmt.setInt(5, c.getId());
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteContact(int id) {
		String query="DELETE FROM contact WHERE id=?";
		try(
				Connection connection=DBConnection.getConn();
				PreparedStatement stmt=connection.prepareStatement(query);
				) {
			stmt.setInt(1, id);
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
}
