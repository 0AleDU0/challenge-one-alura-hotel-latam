package com.hotel.conversor;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ConversorValores {

	public static BigDecimal calcularPorFechaTarifa(LocalDate fechaEntrada, LocalDate fechaSalida, BigDecimal tarifa) {
        long diferenciaDias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        BigDecimal valorFinal = tarifa.multiply(BigDecimal.valueOf(diferenciaDias));
        
        return valorFinal;
	}
	
	public static Date fechaUtilDateToFechaSqlDate(java.util.Date fecha) {
		return java.sql.Date.valueOf(fecha.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
	}

}
