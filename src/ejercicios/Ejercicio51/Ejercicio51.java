package ejercicios.Ejercicio51;

import java.util.Scanner;

public class Ejercicio51 {

    public static void main(String[] args) {

        int i, n, pares=0, impares=0;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.print("Digite el tamaño del vector: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El tamaño del vector debe ser positivo !!!\n");
            }
        }while(n<=0);

        // 1. Declarar el vector de n posiciones
        int Vec[] = new int [n];

        // 2. Cargar el vector con valores enteros
        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("Digite un valor para Vec[" + i + "]: ");
            Vec[i]=leer.nextInt();
        }

        // Contar pares e impares
        for(i=0; i<n; i++) {
            if(Vec[i]%2==0) {
                pares++;
            }else {
                impares++;
            }
        }

        // 3. Imprimir el vector y cuantos fueron pares e impares
        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("[" + Vec[i] + "]");
        }
        System.out.println("\n\nCantidad de numeros pares: " + pares);
        System.out.println("Cantidad de numeros impares: " + impares);
    }
}
