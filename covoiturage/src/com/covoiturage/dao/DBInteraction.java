package com.covoiturage.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBInteraction {

	static String url="jdbc:mysql://localhost/covoiturage";
	static Connection conn;
	static Statement st;
	
	public static Connection connection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//etablir la connection
			 conn = DriverManager.getConnection(url,"root","");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	public static void connect()
	{
		//chargement du pilot
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//etablir la connection
			 conn = DriverManager.getConnection(url,"root","");
			 //preparation d instruction
			  st = conn.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void disconnect()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int Maj(String sql)
	{
		int nb = 0;
		try {
			 nb=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	public static ResultSet select(String sql)
	{
		ResultSet rs = null;
		try {
			 rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int getLastId(String sql) throws SQLException{
		int last = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet res = st.getGeneratedKeys();
		if(res.next()){
			last = res.getInt(1);
		}
		return last;
	}
	
	public static String md5(String pass) {
		// TODO Auto-generated method stub
		String generatedPass = null;
        MessageDigest md = null;
        
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			md.update(pass.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPass = sb.toString();
			return generatedPass;
	}
}

