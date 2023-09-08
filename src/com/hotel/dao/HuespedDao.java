package com.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.modelo.Huesped;

public class HuespedDao {
	
	Connection con;

	public HuespedDao(Connection con) {
		this.con = con;
	}

	public void guardar(Huesped huesped) {
		String sqlComando = "INSERT INTO HUESPEDES "
				+ "(NOMBRE , APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try(PreparedStatement statement = con.prepareStatement(sqlComando, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setDate(3, huesped.getFechaNacimiento());
			statement.setString(4, huesped.getNacionalidad());
			statement.setInt(5, huesped.getTelefono());
			statement.setInt(6, huesped.getIdReservacion());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huesped> listarHuespedes() {
		List<Huesped> huespedes = new ArrayList<Huesped>();
		String sql = "SELECT ID, NOMBRE , APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM huespedes";
		
		try (PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.execute();
			transformarResultSetEnHuesped(huespedes, pstm);
			
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huesped> buscarPorDatosIncertados(String datoTxt) {
		List<Huesped> huespedes = new ArrayList<Huesped>();
		String sql = "SELECT ID, NOMBRE , APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM huespedes "
				+ "WHERE ID_RESERVA = ? OR NOMBRE = ? OR APELLIDO = ? OR NACIONALIDAD = ? OR TELEFONO = ? ";
		
		try(PreparedStatement statement = con.prepareStatement(sql)) {

			statement.setString(1, datoTxt);
			statement.setString(2, datoTxt);
			statement.setString(3, datoTxt);
			statement.setString(4, datoTxt);
			statement.setString(5, datoTxt);
			statement.execute();
			transformarResultSetEnHuesped(huespedes, statement);
			
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Actualizar(Huesped huesped) {
		String sql = "UPDATE HUESPEDES SET NOMBRE = ?, APELLIDO = ?, FECHA_NACIMIENTO = ?, NACIONALIDAD = ?, TELEFONO = ?, ID_RESERVA = ? WHERE ID = ?";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setString(1, huesped.getNombre());
			stm.setString(2, huesped.getApellido());
			stm.setDate(3, huesped.getFechaNacimiento());
			stm.setString(4, huesped.getNacionalidad());
			stm.setInt(5, huesped.getTelefono());
			stm.setInt(6, huesped.getIdReservacion());
			stm.setInt(7, huesped.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Eliminar(Integer id) {
		String sql = "DELETE FROM HUESPEDES WHERE ID = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void transformarResultSetEnHuesped(List<Huesped> reservas, PreparedStatement statement) throws SQLException {
		try (ResultSet resultSet = statement.getResultSet()) {
			while (resultSet.next()) {
				Huesped huespedes = new Huesped(
						resultSet.getInt(1),
						resultSet.getString(2), 
						resultSet.getString(3),
						resultSet.getDate(4), 
						resultSet.getString(5), 
						resultSet.getInt(6));
				huespedes.setIdReserva(resultSet.getInt(7));
				reservas.add(huespedes);
			}
		}				
	}

}
