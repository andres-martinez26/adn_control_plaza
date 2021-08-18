package com.ceiba.alquiler.comando.fabrica;

import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import org.springframework.stereotype.Component;

@Component
public class FabricaAlquiler {

    public Alquiler crear(ComandoAlquiler comandoAlquiler){
        return new Alquiler(
                comandoAlquiler.getId(),
                comandoAlquiler.getNombre(),
                comandoAlquiler.getNumero(),
                comandoAlquiler.getFechaPago(),
                comandoAlquiler.getEstadoPago(),
                comandoAlquiler.getLetraLocal()
        );
    }
}
