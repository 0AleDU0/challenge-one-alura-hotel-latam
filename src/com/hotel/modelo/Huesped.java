package com.hotel.modelo;

import java.sql.Date;

public class Huesped {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private Integer telefono;
	private Integer idReservacion;
	
	public Huesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, Integer telefono,
			Integer idReservacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReservacion = idReservacion;
	}
	
	public Huesped(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, Integer telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}

	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public Integer getIdReservacion() {
		return idReservacion;
	}
	public void setIdReserva(Integer idReservacion) {
		this.idReservacion = idReservacion;
	}
}

