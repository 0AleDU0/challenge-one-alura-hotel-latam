package com.hotel.controller;

import java.util.List;

import com.hotel.dao.ReservaDAO;
import com.hotel.factory.ConnectionFactory;
import com.hotel.modelo.Reserva;

public class ReservaController {
	
	ReservaDAO reservaDao;
	
    public ReservaController() {
        ConnectionFactory factory = new ConnectionFactory();
        this.reservaDao = new ReservaDAO(factory.recuperaConexion());
    }

	public Integer guardar(Reserva reserva) {
		return this.reservaDao.guardar(reserva);
	}
		
	public List<Reserva> buscar() {
		return this.reservaDao.buscar();
	}
	
	public List<Reserva> buscarPorDatosIncertados(String datoTxt) {
		return this.reservaDao.buscarPorDatosIncertados(datoTxt);
	}
	
	public void actualizar(Reserva reserva) {
		this.reservaDao.Actualizar(reserva);
	}
	
	public void Eliminar(Integer id) {
		this.reservaDao.Eliminar(id);
	}
}
