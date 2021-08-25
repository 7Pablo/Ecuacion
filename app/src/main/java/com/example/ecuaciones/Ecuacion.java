package com.example.ecuaciones;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Ecuacion {

    public String[] obtenerRaices(double a, double b, double c) {

        String raices[] = new String[]{"",""};

        if (a == 0) {
            raices[0] = "No es ecuación de segundo grado";
        } else {
            double argRaiz = pow(b, 2) - 4 * a * c;
            if (argRaiz >= 0) {
                if (argRaiz == 0) {
                    double x1 = -b / (2 * a);
                    raices[0] = String.valueOf(x1);
                } else {
                    double x1, x2;
                    x1 = (-b + sqrt(argRaiz)) / (2 * a);
                    x2 = (-b - sqrt(argRaiz)) / (2 * a);
                    raices[0] = String.valueOf(x1);
                    raices[1] = String.valueOf(x2);
                }
            } else {
                double real, imaginario;
                argRaiz = abs(argRaiz);
                real = -b / (2 * a);
                imaginario = sqrt(argRaiz) / (2 * a);

                raices[0] = String.valueOf(real) + " + " +  String.valueOf(imaginario);
                raices[1] = String.valueOf(real) + " - " +  String.valueOf(imaginario);
            }
        }

        return raices;
    }
}
