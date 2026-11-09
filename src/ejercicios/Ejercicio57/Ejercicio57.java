package ejercicios.Ejercicio57;

import java.util.Scanner;

public class Ejercicio57 {

    public static void main(String[] args) {

        int i, j;
        int Mat[][] = new int [3][3];

        Scanner leer = new Scanner(System.in);

        for(i=0; i<3; i++) {
            for(j=0; j<3; j++) {
                System.out.print("Digite un valor para Mat[" + i + "][" + j + "]: ");
                Mat[i][j]=leer.nextInt();
            }
        }

        System.out.println();
        for(i=0; i<3; i++) {
            for(j=0; j<3; j++) {
                System.out.print("[" + Mat[i][j] + "]");
            }
            System.out.println();
        }
    }
}
