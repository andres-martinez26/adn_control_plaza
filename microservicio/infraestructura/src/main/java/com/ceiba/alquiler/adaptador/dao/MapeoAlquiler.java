package com.ceiba.alquiler.adaptador.dao;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoAlquiler implements RowMapper<DtoAlquiler>, MapperResult {

    @Override
    public DtoAlquiler mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String numero = rs.getString("numero");
        LocalDateTime fechaPago = extraerLocalDateTime(rs, "fecha_pago");
        Boolean estadoPago = rs.getBoolean("estado_pago");
        String local = rs.getString("local");

        return new DtoAlquiler(id,nombre,numero,fechaPago,estadoPago,local);
    }
}
