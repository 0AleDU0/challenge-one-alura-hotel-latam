package com.hotel.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.hotel.modelo.Reserva;

public class ReservaDAO {

	Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	public Integer guardar(Reserva reserva) {
	    String sql = "INSERT INTO RESERVAS (TIPO_HABITACION, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO) "
	            + "VALUES (?, ?, ?, ?, ?)";
	    try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	    	statement.setString(1, reserva.getTipoHabitacion());
	        statement.setDate(2, reserva.getFechaEntrada());
	        statement.setDate(3, reserva.getFechaSalida());
	        statement.setBigDecimal(4, reserva.getValorReserva());
	        statement.setString(5, reserva.getFormaDePago());

	        statement.executeUpdate();
	        try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
				while (generatedKeys.next()) {
					return generatedKeys.getInt(1);
                }
			}
	    } catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, "Ocurrio un error con su registro de reserva", "Error", JOptionPane.ERROR_MESSAGE);
	    }
		return null;
	}
	
	public List<Reserva> buscar() {
		List<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT ID, TIPO_HABITACION,FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO "
				+ "FROM RESERVAS";
		try(PreparedStatement statement = con.prepareStatement(sql)) {
			statement.execute();
			transformarResultSetEnReserva(reservas, statement);
			
			return reservas;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reserva> buscarPorDatosIncertados(String datoTxt) {
		List<Reserva> reservas = new ArrayList<Reserva>();
		String sql = "SELECT ID, TIPO_HABITACION, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM"
				+ " reservas WHERE ID = ? OR VALOR = ? OR FORMA_PAGO = ? OR TIPO_HABITACION = ?";
		try(PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, datoTxt);
			statement.setDouble(2, Double.parseDouble(datoTxt));
			statement.setString(3, datoTxt);
			statement.setString(4, datoTxt);
			statement.execute();

			transformarResultSetEnReserva(reservas, statement);
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transformarResultSetEnReserva(List<Reserva> reservas, PreparedStatement statement) throws SQLException {
		try(ResultSet resultSet = statement.getResultSet()) {
			while(resultSet.next()) {
				Reserva reserva = new Reserva(
						Integer.valueOf(resultSet.getInt(1)),
						resultSet.getString(2),
						resultSet.getDate(3),
						resultSet.getDate(4),
						BigDecimal.valueOf(resultSet.getDouble(5)),
						resultSet.getString(6));
				reservas.add(reserva);
			}
		}
	}

	public void Actualizar(Reserva reserva) {
		String sql = "UPDATE RESERVAS SET TIPO_HABITACION = ?, FECHA_ENTRADA = ?, FECHA_SALIDA = ?, FORMA_PAGO = ? WHERE ID = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, reserva.getTipoHabitacion());
			statement.setDate(2, reserva.getFechaEntrada());
			statement.setDate(3, reserva.getFechaSalida());
			statement.setString(4, reserva.getFormaDePago());
			statement.setInt(5, reserva.getId());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Eliminar(Integer id) {
		String sql = "DELETE FROM reservas WHERE id = ?";
		try (PreparedStatement stm = con.prepareStatement(sql)) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
