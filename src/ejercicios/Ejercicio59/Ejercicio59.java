package ejercicios.Ejercicio59;

import java.util.Scanner;

public class Ejercicio59 {

    public static void main(String[] args) {

        int i, j;
        int n, m;
        int acu=0;

        Scanner leer = new Scanner(System.in);

        do {
            System.out.print("Digite el tamaño de las filas: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El tamaño de las filas debe ser positivo !!!\n");
            }
        }while(n<=0);

        do {
            System.out.print("Digite el tamaño de las columnas: ");
            m=leer.nextInt();
            if(m<=0) {
                System.out.println("\n\t!!! Error... El tamaño de las columnas debe ser positivo !!!\n");
            }
        }while(m<=0);

        int Mat[][] = new int [n][m];

        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<m; j++) {
                System.out.print("Digite un valor para Mat[" + i + "][" + j + "]: ");
                Mat[i][j]=leer.nextInt();
            }
        }

        for(i=0; i<n; i++) {
            for(j=0; j<m; j++) {
                acu = acu + Mat[i][j];
            }
        }

        System.out.println();
        for(i=0; i<n; i++) {
            for(j=0; j<m; j++) {
                System.out.print("[" + Mat[i][j] + "]");
            }
            System.out.println();
        }

        System.out.println("\nEl resultado de la suma es: " + acu);
    }
}
