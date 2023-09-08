package com.hotel.dao;

import java.sql.*;

import com.hotel.modelo.Usuario;

public class UsuarioDAO {
	
	Connection con;

	public UsuarioDAO(Connection con) {
		this.con = con;
	}

	public Boolean loginUser(Usuario usuario) {
        String sqlComando = "SELECT * FROM USUARIOS WHERE NOMBRE = ? AND CLAVE_ACCESO = ?";
        
        try (PreparedStatement statement = con.prepareStatement(sqlComando, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getContrasenha());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}	
}
