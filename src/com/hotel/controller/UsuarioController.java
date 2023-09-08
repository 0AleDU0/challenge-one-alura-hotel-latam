package com.hotel.controller;

import com.hotel.dao.UsuarioDAO;
import com.hotel.factory.ConnectionFactory;
import com.hotel.modelo.Usuario;

public class UsuarioController {
	UsuarioDAO usuarioDao;
	
    public UsuarioController() {
        ConnectionFactory factory = new ConnectionFactory();
        this.usuarioDao = new UsuarioDAO(factory.recuperaConexion());
    }
    
    public Boolean LoginUser(Usuario usuario) {
    	return this.usuarioDao.loginUser(usuario);
    }
    
    
}
