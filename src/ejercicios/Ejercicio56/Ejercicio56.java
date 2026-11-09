package ejercicios.Ejercicio56;

import java.util.Scanner;

public class Ejercicio56 {

    public static void main(String[] args) {

        int i, n;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.print("Digite el tamaño del vector: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El tamaño del vector debe ser positivo !!!\n");
            }
        }while(n<=0);

        int V1[] = new int [n];
        int V2[] = new int [n];
        int V3[] = new int [n];

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

        for(i=0; i<n; i++) {
            V3[i]=V1[i]+V2[n-1-i];
        }

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("[" + V1[i] + "]\t");
        }

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("[" + V2[i] + "]\t");
        }

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("[" + V3[i] + "]\t");
        }
        leer.close();
    }
}
