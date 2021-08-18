package com.ceiba.alquiler.adaptador.repositorio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="alquiler", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="alquiler", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="alquiler", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="alquiler", value="existeCompleto")
    private static String sqlExisteCompleto;

    @SqlStatement(namespace="alquiler", value="existeLocal")
    private static String sqlExisteLocal;


    public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public void crear(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.crearSinIdIncrementable(alquiler, sqlCrear);
    }

    @Override
    public void actualizar(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.actualizar(alquiler,sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,parameterSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().
                queryForObject(sqlExiste, parameterSource, Boolean.class));
    }

    @Override
    public boolean existeCompleto(Alquiler alquiler) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", alquiler.getId());
        parameterSource.addValue("nombre", alquiler.getNombre());
        parameterSource.addValue("numero", alquiler.getNumero());
        parameterSource.addValue("fechaPago", alquiler.getFechaPago().toString());
        parameterSource.addValue("estadoPago", alquiler.getEstadoPago());
        parameterSource.addValue("letraLocal", alquiler.getLetraLocal());
        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().
                queryForObject(sqlExisteCompleto, parameterSource, Boolean.class));
    }

    @Override
    public boolean existeLocal(String letraLocal) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("letraLocal", letraLocal);
        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().
                queryForObject(sqlExisteLocal, parameterSource, Boolean.class));
    }
}
