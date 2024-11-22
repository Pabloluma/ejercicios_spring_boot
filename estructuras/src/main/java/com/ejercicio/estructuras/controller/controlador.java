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

    @PostMapping("/promedioCalificaciones")
    String promedioCalificaciones(@RequestParam String calificaciones) {
        String[] arrayCalificaciones = calificaciones.split(",");
        int suma = 0;
        for (int i = 0; i < arrayCalificaciones.length; i++) {
            suma += Integer.parseInt(arrayCalificaciones[i]);
        }
        int avg = suma / arrayCalificaciones.length;
        String pass = "";
        if (avg >= 5){
            pass =  "Aprueba";
        }else {
            pass =  "No aprueba";
        }
        return "La nota media es " + avg + ". El alumno " + pass;
    }

    @PostMapping("/calcularIMC")
    String CalculaIMC(@RequestParam int peso, @RequestParam int altura) {
//        Formula del IMC
        double calcula = peso / Math.pow((double) altura /100, 2);

        String categoria = "";
        if (calcula < 18.5){
            categoria = "bajo peso";
        } else if (calcula >= 18.5 && calcula <= 24.9) {
            categoria = "normal";
        } else if (calcula >= 25 && calcula <= 29.9) {
            categoria = "sobrepeso";
        } else if (calcula >= 30) {
            categoria = "obesidad";
        }
        return "El usuario tiene " + categoria + " su IMC es " + calcula;

    }



}
