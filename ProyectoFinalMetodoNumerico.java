package com.mycompany.proyectofinalmetodonumerico;

import java.util.Scanner;

public class ProyectoFinalMetodoNumerico {

    // Raíz cuadrada de un número
    public static double raizCuadrada(double N, double tolerancia) {
        double bajo, alto;

        // Límites inferior y superior del intervalo inicial
        if (N < 1) {
            bajo = N;
            alto = 1;
        } else {
            bajo = 0;
            alto = N;
        }

        // Valor medio del intervalo
        double medio = (bajo + alto) / 2;

        // Método de bisección para alcanzar la precisión deseada
        while ((alto - bajo) > tolerancia) {
            if (medio * medio > N) {
                alto = medio; // Ajuste del límite superior
            } else {
                bajo = medio; // Ajuste del límite inferior
            }
            medio = (bajo + alto) / 2; // Nuevo valor medio
        }

        return medio; // Resultado final
    }

    // Punto de equilibrio térmico
    public static double equilibrioTermico(double T1, double T2, double C1, double C2, double tolerancia) {
        double bajo = Math.min(T1, T2);
        double alto = Math.max(T1, T2);
        double medio = (bajo + alto) / 2;

        // Método de bisección para encontrar el punto de equilibrio térmico
        while ((alto - bajo) > tolerancia) {
            double energiaRestante = C1 * (T1 - medio) + C2 * (T2 - medio);

            if (energiaRestante > 0) {
                bajo = medio; // Ajuste del límite inferior
            } else {
                alto = medio; // Ajuste del límite superior
            }
            medio = (bajo + alto) / 2; // Nuevo valor medio
        }

        return medio; // Resultado final
    }

    // Radio de un cilindro con volumen fijo
    public static double radioCilindro(double V, double h, double tolerancia) {
        double bajo = 0;
        double alto = V / (Math.PI * h);
        double medio = (bajo + alto) / 2;

        // Método de bisección para encontrar el radio del cilindro
        while ((alto - bajo) > tolerancia) {
            double volumen = Math.PI * medio * medio * h;

            if (volumen > V) {
                alto = medio; // Ajuste del límite superior
            } else {
                bajo = medio; // Ajuste del límite inferior
            }
            medio = (bajo + alto) / 2; // Nuevo valor medio
        }

        return medio; // Resultado final
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar las opciones al usuario
        System.out.println("Seleccione el ejercicio que desea resolver:");
        System.out.println("1. Calculo de la raiz cuadrada de un numero");
        System.out.println("2. Punto de equilibrio termico");
        System.out.println("3. Calculo del volumen de un cilindro con altura fija");
        System.out.println("4. Salir");
        System.out.println("Seleccione la opcion: ");
        int opcion = scanner.nextInt();

        double tolerancia;
        switch (opcion) {
            case 1 -> {
                // Datos para el cálculo de la raíz cuadrada
                System.out.print("Ingrese el numero del que desea encontrar la raiz cuadrada: ");
                double N = scanner.nextDouble();
                System.out.print("Ingrese la tolerancia para la precision: ");
                tolerancia = scanner.nextDouble();
                // Raíz cuadrada y muestra del resultado
                double resultadoRaiz = raizCuadrada(N, tolerancia);
                System.out.println("La raiz cuadrada de " + N + " es aproximadamente: " + resultadoRaiz);
            }
            case 2 -> {
                // Datos para el cálculo del punto de equilibrio térmico
                System.out.print("Ingrese la temperatura inicial del primer objeto (T1): ");
                double T1 = scanner.nextDouble();
                System.out.print("Ingrese la temperatura inicial del segundo objeto (T2): ");
                double T2 = scanner.nextDouble();
                System.out.print("Ingrese la capacidad calorifica del primer objeto (C1): ");
                double C1 = scanner.nextDouble();
                System.out.print("Ingrese la capacidad calorifica del segundo objeto (C2): ");
                double C2 = scanner.nextDouble();
                System.out.print("Ingrese la tolerancia para la precision: ");
                tolerancia = scanner.nextDouble();
                // Punto de equilibrio térmico y muestra el resultado
                double resultadoEquilibrio = equilibrioTermico(T1, T2, C1, C2, tolerancia);
                System.out.println("La temperatura de equilibrio es aproximadamente: " + resultadoEquilibrio);
            }
            case 3 -> {
                //Datos para el cálculo del radio del cilindro
                System.out.print("Ingrese el volumen deseado del cilindro (V): ");
                double V = scanner.nextDouble();
                System.out.print("Ingrese la altura fija del cilindro (h): ");
                double h = scanner.nextDouble();
                System.out.print("Ingrese la tolerancia para la precision: ");
                tolerancia = scanner.nextDouble();
                // Radio del cilindro y muestra el resultado
                double resultadoRadio = radioCilindro(V, h, tolerancia);
                System.out.println("El radio del cilindro es aproximadamente: " + resultadoRadio);
            }
            case 4 -> System.out.println("Salida del programa");
            default -> System.out.println("Opcion no valida");
        }
    }
}
