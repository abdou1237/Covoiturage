package com.covoiturage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.covoiturage.entities.User;

public class UserImpl implements IUser{

	@Override
	public void register(User user) {
		
		String sql = "insert into utilisateur values(null,?,?,?,?)";
		
		Connection conn = DBInteraction.connection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User login(String email, String password) {
		
		User user = null;
		
		String sql = "select * from utilisateur where email=? and motdepasse = ?";
		
		Connection conn = DBInteraction.connection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				user = new User();
				user.setId(rs.getInt("id_utilisateur"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("motdepasse"));
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		
		User user = null;
		
		String sql = "select * from utilisateur where email=?";
		
		Connection conn = DBInteraction.connection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				user = new User();
				user.setId(rs.getInt("id_utilisateur"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("motdepasse"));
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
