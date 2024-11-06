package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.DBConnection;
import com.model.User;

public class UserDaoImp implements UserDAO{
	public User login(String email,String password) {
		String query="SELECT * FROM user WHERE email=? and password=?";
		try (Connection connection=DBConnection.getConn();
				PreparedStatement stmt=connection.prepareStatement(query);){
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				User user=new User();
				user.setEmail(email);
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean register(String email,String name,String password) {
		String query="INSERT INTO user(name,email,password) VALUES(?,?,?)";
		try (Connection connection=DBConnection.getConn();
				PreparedStatement stmt=connection.prepareStatement(query);				
				){
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, password);
			int r=stmt.executeUpdate();
			return r>0;
		} catch (SQLException e) {
			System.out.println("Exception occurred at register function");
		}
		return false;
	}
}
