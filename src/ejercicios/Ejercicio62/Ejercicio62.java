package ejercicios.Ejercicio62;

import java.util.Scanner;

public class Ejercicio62 {

    public static void main(String[] args) {

        int i, j;
        int n;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.print("Digite el tamaño de la matriz: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El tamaño de la matriz debe ser positivo !!!\n");
            }
        }while(n<=0);

        int M1[][] = new int [n][n];

        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print("Digite un valor para M1[" + i + "][" + j + "]: ");
                M1[i][j]=leer.nextInt();
            }
        }

        System.out.println("");
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print("[" + M1[i][j] + "]");
            }
            System.out.println();
        }

        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print("[" + M1[j][i] + "]");
            }
            System.out.println();
        }

        /*
        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                if(i==j || i+j==n-1) {
                    System.out.print("[" + M1[i][j] + "]");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }*/
    }
}
