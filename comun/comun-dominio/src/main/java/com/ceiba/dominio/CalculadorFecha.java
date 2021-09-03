package com.ceiba.dominio;

import java.time.LocalDateTime;

public class CalculadorFecha {

    private CalculadorFecha() {
    }

    public static String sumarUnMesFechaActual(LocalDateTime localDateTime, int lenghtMonth){
        LocalDateTime plusMonths = localDateTime.plusMonths(lenghtMonth);
        return  plusMonths.toLocalDate().toString();
    }
}
