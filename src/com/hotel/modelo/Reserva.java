package com.hotel.modelo;

import java.math.BigDecimal;
import java.sql.Date;

public class Reserva {
	
	private Integer id;
	private String tipoHabitacion;
	private Date fechaEntrada;
	private Date fechaSalida;
	private BigDecimal valorReserva;
	private String formaDePago;

	public Reserva(Integer id,String tipoHabitacion, Date fechaEntrada, Date fechaSalida, BigDecimal valorReserva, String formaDePago) {
		this.id = id;
		this.tipoHabitacion = tipoHabitacion;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valorReserva = valorReserva;
		this.formaDePago = formaDePago;
	}

	public Reserva(String tipoHabitacion, Date fechaEntrada, Date fechaSalida, BigDecimal valorReserva, String formaDePago) {
		this.tipoHabitacion = tipoHabitacion;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valorReserva = valorReserva;
		this.formaDePago = formaDePago;
	}

	public String getFormaDePago() {
		return formaDePago;
	}
	public BigDecimal getValorReserva() {
		return valorReserva;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

}
