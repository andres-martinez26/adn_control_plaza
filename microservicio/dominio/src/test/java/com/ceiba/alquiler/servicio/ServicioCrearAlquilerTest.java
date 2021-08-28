package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearAlquilerTest {

    private static final String EL_USUARIO_YA_TIENE_ALQUILADO_UN_LOCAL = "El usuario ya tiene alquilado un local";
    private static final String EL_LOCAL_YA_FUE_ALQUILADO = "El local ya fue alquilado";

    @Test
    public void validarLocalExistenciaLocalTest(){
        //arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existeLocal(Mockito.anyString())).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler);
        //act
        String ejecutar = servicioCrearAlquiler.ejecutar(alquiler);
        //assert
        Assert.assertArrayEquals(EL_LOCAL_YA_FUE_ALQUILADO.toCharArray(),ejecutar.toCharArray());

    }

    @Test
    public void validarExistenciaPreviaTest(){
        //arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.existeCompleto(alquiler)).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler);
        //act
        String ejecutar = servicioCrearAlquiler.ejecutar(alquiler);
        //assert
        Assert.assertArrayEquals(EL_USUARIO_YA_TIENE_ALQUILADO_UN_LOCAL.toCharArray(),ejecutar.toCharArray());
    }
}