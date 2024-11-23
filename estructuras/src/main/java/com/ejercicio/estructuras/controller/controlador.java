package com.ejercicio.estructuras.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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
    @PostMapping("/encuesta")
    String encuesta(@RequestParam String satisfaccion) {
        return "La encuesta de satisfaccion es " + satisfaccion;
    }

    @PostMapping("/generarContrasena")
    String generarContrasena(@RequestParam int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 !@#$%^&*()_-+=<>?";
      Random random = new Random();
        String contrasena = "";
        for (int i = 0; i < longitud; i++) {
//      Obtiene el indice de un caracter aleatorio
            int indice = random.nextInt(caracteres.length());
//      Añade la letra al String cadena
            contrasena += caracteres.charAt(indice);
        }
        return contrasena;
    }

    @PostMapping("/sumatoria")
    String sumatorio(@RequestParam int numero) {
        int suma = 0;
        for (int i = 1; i < numero+1 ; i++) {
            suma += i;
        }
        return "El sumatorio es " + suma;
    }

    @PostMapping("/factorial")
    String factorial(@RequestParam int numero) {
        String[] numeroF = resuelveFactorial(numero);
        return "El factorial es " + numeroF[1] + "\n" + numeroF[0];
    }

String[] resuelveFactorial(int numero) {
    int factorial = 1;
    String valores = "";
    for (int i = 1; i <= numero; ++i) {
        factorial *= i;
        if (i == numero) {
            valores +=  i + " = " + factorial;
        }else if (i == 1){
            valores += "<p>" + i + " * ";
        }else{
            valores += i + " * ";
        }

    }
    valores += "</p";
    String[] resultado = new String[2];
    resultado[0] = valores;  // Convertimos el resultado a String
    resultado[1] = factorial + "";
    return resultado;
}

}
