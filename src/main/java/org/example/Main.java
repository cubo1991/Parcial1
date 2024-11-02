package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {  // Bucle infinito para reiniciar el programa si el usuario elige continuar
            int[][] matriz = ejercicio1(sc);
            int[] matrizValoresCentral = obtenerValoresCentrales(matriz);
            double resultado = calcularPromedioDeMatrices(matriz, matrizValoresCentral);
            System.out.println("El promedio calculado es: " + resultado);

            System.out.println("");
            System.out.println("Si desea finalizar el programa, presione 1. Si desea empezar desde el principio, ingrese 2.");
            n = sc.nextInt();

            if (n == 1) {
                System.out.println("Hasta la próxima!");
                break;  // Sale del bucle y termina el programa
            }
        }
    }

    public static int [][] ejercicio1 (Scanner sc){

        int N;
        int [][] matriz;
        while(true){

            System.out.println("Por favor, ingrese el valor para las dimensiones de una matriz cuadrada. Tiene que se un numero impar entre 3 y 15");
            N = sc.nextInt();
            if(N%2 !=0 && N>3 && N<15){

                break;

            } else {
                System.out.println("Por favor, vuelva a ingresar un nuevo valor");

            }

        }

        matriz = new int[N][N];
        int valor = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                Random random = new Random();
                int numeroAleatorio = 10 + random.nextInt(90);
                matriz[i][j] = numeroAleatorio;

            }
        }
        for (int i = 0; i < matriz[0].length; i++) {
                while(true){
                    System.out.println("Por favor, ingrese un valor entre 10 y 99");
                    valor = sc.nextInt();
                    if(valor > 10 && valor < 99){
                        matriz[N-1][i] = valor;
                        break;
                    }

            }
        }
        System.out.println("Valores del array:");
        for (int i = 0; i < matriz.length; i++) {//filas
            for (int j = 0; j < matriz[0].length; j++) {//columnas
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println();
        }

        return matriz;



    }
    public static int[] obtenerValoresCentrales (int [][] matriz){

        int valorMedio = matriz[0].length/2;
        int [] array = new int[9];
        int index = 0;
        for (int i = valorMedio - 1; i <= valorMedio + 1; i++) {
            for (int j = valorMedio - 1; j <= valorMedio + 1; j++) {
                array[index++] = matriz[i][j];
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();

    burbuja(array,"Asc");
        return array;
    }

    public static void burbuja (int array[], String orden) {
        int n = array.length;
        boolean intercambiado;
        do {
            intercambiado = false;
            for (int i = 1; i < n; i++){
                if (orden.equals("Asc") && array[i-1] > array[i] ) {
                    int aux = array[i-1];
                    array[i-1] = array[i];
                    array[i] = aux;
                    intercambiado = true;
                } else if ( orden.equals("Desc") && array[i-1] < array[i] ) {
                    int aux = array[i-1];
                    array[i-1] = array[i];
                    array[i] = aux;
                    intercambiado = true;
                }
            }
        } while (intercambiado);

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
        }
    }

    public static double calcularPromedioDeMatrices (int[][] matriz, int[] matrizValoresCentral){
        int matrizDivisor=0;
        int matrizTotal=0;
        int matrizPromedio=0;
        for(int i =0 ; i < matriz.length; i++){
            for(int j =0 ; j < matriz[0].length; j++){
                matrizTotal += matriz[i][j];
              matrizDivisor++;

            }
        }
        matrizPromedio= matrizTotal/ matrizDivisor;
        System.out.println("");
        System.out.println("La suma total de la matriz es: "+ matrizTotal);
        System.out.println("La cantidad de elementos es: "+ matrizDivisor);
        System.out.println("El promedio es: "+ matrizPromedio);

        int arregloDivisor=0;
        int arregloTotal=0;
        int arregloPromedio=0;
        for(int i =0 ; i < matrizValoresCentral.length; i++){
            arregloTotal+=matrizValoresCentral[i];
            arregloDivisor++;
        }

        arregloPromedio= arregloTotal / arregloDivisor;
        System.out.println("La suma total del arreglo es: "+ arregloTotal);
        System.out.println("La cantidad de elementos es: "+ arregloDivisor);
        System.out.println("El promedio es: "+ arregloPromedio);


        return (arregloPromedio+matrizPromedio)/2;
    }


}

