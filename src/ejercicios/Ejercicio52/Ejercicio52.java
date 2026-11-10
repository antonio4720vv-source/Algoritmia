package ejercicios.Ejercicio52;

import java.util.Scanner;

public class Ejercicio52 {

    public static void main(String[] args) {

        int i, j, n, iguales=0;
        boolean encontrado;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.print("Digite el tamaño de los vectores: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El tamaño del vector debe ser positivo !!!\n");
            }
        }while(n<=0);

        // 1. Declarar 2 vectores de n posiciones
        int V1[] = new int [n];
        int V2[] = new int [n];

        // 2. Cargar los vectores con valores enteros
        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("Digite un valor para V1[" + i + "]: ");
            V1[i]=leer.nextInt();
        }

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("Digite un valor para V2[" + i + "]: ");
            V2[i]=leer.nextInt();
        }

        // Contar cuantos numeros de V1 estan en V2, sin importar la posicion
        for(i=0; i<n; i++) {
            encontrado=false;
            for(j=0; j<n; j++) {
                if(V1[i]==V2[j]) {
                    encontrado=true;
                }
            }
            if(encontrado==true) {
                iguales++;
            }
        }

        // 3. Imprimir los vectores y cuantos numeros son iguales
        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("[" + V1[i] + "]");
        }

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("[" + V2[i] + "]");
        }
        System.out.println("\n\nCantidad de numeros iguales entre los vectores: " + iguales);
    }
}
