package ejercicios.Ejercicio48;

import java.util.Scanner;

public class Ejercicio48 {

    public static void main(String[] args) {

        int i;
        int Vec[] = new int [5];

        Scanner leer = new Scanner(System.in);

        for(i=0; i<5; i++) {
            System.out.print("Digite un valor para Vec[" + i + "]: ");
            Vec[i]=leer.nextInt();
        }

        /*
        System.out.println();
        for(i=0; i<5; i++) {
            System.out.print("[" + Vec[i] + "]");
        }*/

        System.out.println();
        for(i=0; i<5; i++) {
            if(i!=4) {
                System.out.print("|" + Vec[i]);
            }else {
                System.out.print("|" + Vec[i] + "|");
            }
        }
    }
}
