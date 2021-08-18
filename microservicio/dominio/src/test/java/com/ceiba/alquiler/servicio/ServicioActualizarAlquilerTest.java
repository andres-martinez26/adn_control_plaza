package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarAlquilerTest {

    private static final String EL_REGISTRO_YA_EXISTE_EN_EL_SISTEMA = "El registro ya existe en el sistema";
    private static final String EL_LOCAL_YA_FUE_ALQUILADO = "El local ya fue alquilado";

    @Test
    public void validarLocalExistenciaLocalTest(){
        //arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existeLocal(Mockito.anyString())).thenReturn(true);
        ServicioActualizarAlquiler servicioActualizarAlquiler = new ServicioActualizarAlquiler(repositorioAlquiler);
        //act-assert
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.ejecutar(alquiler), ExcepcionDuplicidad.class,EL_LOCAL_YA_FUE_ALQUILADO);
    }

    @Test
    public void validarExistenciaPreviaTest(){
        //arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existeCompleto(alquiler)).thenReturn(true);
        ServicioActualizarAlquiler servicioActualizarAlquiler = new ServicioActualizarAlquiler(repositorioAlquiler);
        //act-assert
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.ejecutar(alquiler), ExcepcionDuplicidad.class,EL_REGISTRO_YA_EXISTE_EN_EL_SISTEMA);
    }
}