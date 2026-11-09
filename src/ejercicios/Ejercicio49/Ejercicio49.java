package ejercicios.Ejercicio49;

import java.util.Scanner;

public class Ejercicio49 {

    public static void main(String[] args) {

        int i, n, suma=0;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.print("Digite el tamaño del vector: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El tamaño del vector debe ser positivo !!!\n");
            }
        }while(n<=0);

        int Vec[] = new int [n];

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("Digite un valor para Vec[" + i + "]: ");
            Vec[i]=leer.nextInt();
        }

        for(i=0; i<n; i++) {
            suma = suma + Vec[i];
        }

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("[" + Vec[i] + "]");
        }
        System.out.println("\n\nLa suma total es: " + suma);
    }
}
