package com.ceiba.alquiler.puerto.dao;


import com.ceiba.alquiler.modelo.dto.DtoAlquiler;

import java.util.List;

public interface DaoAlquiler {

    /**
     * Permite listar registros de alquiler
     * @return los registros
     */
    List<DtoAlquiler> listar(boolean pendiente);
}
