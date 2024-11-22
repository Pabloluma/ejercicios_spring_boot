package com.ejercicio.estructuras.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class controlador {
    @PostMapping("/parImpar")
    String parImpar(@RequestParam int numero) {
        if (numero % 2 == 0) {
            return "Par";
        }else{
            return "Impar";
        }
    }

    @PostMapping("/tablaMultiplicar")
    String tablaMultiplicar(@RequestParam int numero) {
        String[] resultado = new String[10];
        String resultado1 = "";
        for (int i = 0; i < 10; i++) {
            resultado[i] = numero + " * " + i + " = " + (numero * i);
        }
        for(String res : resultado){
            resultado1 += "<h2>" + res + "</h2><br>" ;
        }
        return resultado1;
    }


}
