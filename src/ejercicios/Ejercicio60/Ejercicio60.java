package ejercicios.Ejercicio60;

import java.util.Scanner;

public class Ejercicio60 {

    public static void main(String[] args) {

        int i, j;
        int n;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.print("Digite el tamaño de la matriz y el vector: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El tamaño de la matriz debe ser positivo !!!\n");
            }
        }while(n<=0);

        int V[] = new int [n];
        int M1[][] = new int [n][n];
        int M2[][] = new int [n][n];

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("Digite un valor para V[" + i + "]: ");
            V[i]=leer.nextInt();
        }

        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print("Digite un valor para M1[" + i + "][" + j + "]: ");
                M1[i][j]=leer.nextInt();
            }
        }

        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                M2[i][j]=V[j]+M1[i][j];
            }
        }

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("[" + V[i] + "]");
        }

        System.out.println("\n");
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print("[" + M1[i][j] + "]");
            }
            System.out.println();
        }

        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print("[" + M2[i][j] + "]");
            }
            System.out.println();
        }
    }
}
