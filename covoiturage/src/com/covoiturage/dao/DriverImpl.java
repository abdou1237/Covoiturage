package com.covoiturage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.covoiturage.entities.Driver;

public class DriverImpl implements IDriver{

	@Override
	public void addDriver(Driver driver) {
		
		String sql = "insert into conducteur values(null,?,?)";
		
		Connection conn = DBInteraction.connection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, driver.getIdUser());
			ps.setInt(2, driver.getStars());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
