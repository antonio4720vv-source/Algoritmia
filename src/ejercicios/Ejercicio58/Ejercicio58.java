package ejercicios.Ejercicio58;

import java.util.Scanner;

public class Ejercicio58 {

    public static void main(String[] args) {

        int i, j;
        int n;
        int acu=0;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.print("Digite el tamaño de la matriz: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El tamaño de la matriz debe ser positivo !!!\n");
            }
        }while(n<=0);

        int Mat[][] = new int [n][n];

        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print("Digite un valor para Mat[" + i + "][" + j + "]: ");
                Mat[i][j]=leer.nextInt();
            }
        }

        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                acu = acu + Mat[i][j];
            }
        }

        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                System.out.print("[" + Mat[i][j] + "]");
            }
            System.out.println();
        }

        System.out.println("\nEl resultado de la suma es: " + acu);
    }
}
