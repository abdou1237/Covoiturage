package com.covoiturage.entities;

public class Driver {

	private int idDriver;
	private int idUser;
	private int stars;
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(int idUser, int stars) {
		super();
		this.idUser = idUser;
		this.stars = stars;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getIdDriver() {
		return idDriver;
	}

	@Override
	public String toString() {
		return "Driver [idDriver=" + idDriver + ", idUser=" + idUser + ", stars=" + stars + "]";
	}
	
	
}
