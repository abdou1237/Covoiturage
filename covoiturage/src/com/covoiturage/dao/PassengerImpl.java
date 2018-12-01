package com.covoiturage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.covoiturage.entities.Passenger;

public class PassengerImpl implements IPassenger{

	@Override
	public void addPassenger(Passenger passenger) {
		
		String sql = "insert into passager values(null,?,?)";
		
		Connection conn = DBInteraction.connection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, passenger.getIdUser());
			ps.setInt(2, 0);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

	
