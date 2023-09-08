package com.hotel.controller;

import java.util.List;

import com.hotel.dao.HuespedDao;
import com.hotel.factory.ConnectionFactory;
import com.hotel.modelo.Huesped;


public class HuespedController {
	
	HuespedDao huespedDao;
	
    public HuespedController() {
        ConnectionFactory factory = new ConnectionFactory();
        this.huespedDao = new HuespedDao(factory.recuperaConexion());
    }

	public void guardar(Huesped huesped) {
		huespedDao.guardar(huesped);
	}

	public List<Huesped> listarHuespedes() {
		return this.huespedDao.listarHuespedes();
	}
	
	public List<Huesped> buscarPorDatosIncertados(String datoTxt) {
		return this.huespedDao.buscarPorDatosIncertados(datoTxt);
	}
	
	public void actualizar(Huesped huesped) {
		this.huespedDao.Actualizar(huesped);
	}
	
	public void Eliminar(Integer id) {
		this.huespedDao.Eliminar(id);
	}
    
}
