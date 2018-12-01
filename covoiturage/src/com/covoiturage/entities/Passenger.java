package com.covoiturage.entities;

public class Passenger {

	private int idPassenger;
	private int idUser;
	private int nb_reservation;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(int idUser, int nb_reservation) {
		super();
		this.idUser = idUser;
		this.nb_reservation = nb_reservation;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getNb_reservation() {
		return nb_reservation;
	}

	public void setNb_reservation(int nb_reservation) {
		this.nb_reservation = nb_reservation;
	}

	public int getIdPassenger() {
		return idPassenger;
	}

	@Override
	public String toString() {
		return "Passenger [idPassenger=" + idPassenger + ", idUser=" + idUser + ", nb_reservation=" + nb_reservation
				+ "]";
	}

}
