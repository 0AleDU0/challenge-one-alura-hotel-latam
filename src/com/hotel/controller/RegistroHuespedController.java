package com.hotel.controller;

import com.hotel.dao.HuespedDao;
import com.hotel.factory.ConnectionFactory;
import com.hotel.modelo.Huesped;

public class RegistroHuespedController {
	HuespedDao registroHuespedDao;
	
    public RegistroHuespedController() {
        ConnectionFactory factory = new ConnectionFactory();
        this.registroHuespedDao = new HuespedDao(factory.recuperaConexion());
    }

    public void registrarHuesped(Huesped huesped) {
        this.registroHuespedDao.guardar(huesped);
    }

}
