package ejercicios.Ejercicio50;

import java.util.Scanner;

public class Ejercicio50 {

    public static void main(String[] args) {

        int i, n, numLetras=0, opo=0;
        String letra;
        boolean bandera=false;

        Scanner leer = new Scanner(System.in);

        System.out.println("...::: JUEGO DEL AHORCADO :::...\n");

        do {
            System.out.print("Digite el número de letras que tiene la palabra: ");
            n=leer.nextInt();
            if(n<=0) {
                System.out.println("\n\t!!! Error... El número de letras debe ser positivo !!!\n");
            }
        }while(n<=0);

        String Pal[] = new String [n];
        String PalEsc[] = new String [n];

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print("Digite un valor para Pal[" + i + "]: ");
            Pal[i]=leer.next();
            PalEsc[i]="_";
        }

        System.out.println();
        for(i=0; i<n; i++) {
            System.out.print(" " + PalEsc[i] + " ");
        }

        System.out.println("");
        do {

            System.out.print("\nDigite la letra que cree que está en la palabra: ");
            letra=leer.next();

            for(i=0; i<n; i++) {
                if(letra.equals(Pal[i])) {
                    numLetras++;
                    bandera=true;
                    PalEsc[i]=letra;
                }
            }

            if(bandera==false) {
                opo++;
                if(opo==1) {
                    System.out.println("\nMUÑECO");
                }else {
                    if(opo==2) {
                        System.out.println("\nMUÑECO y ÁRBOL");
                    }else {
                        System.out.println("\nMUÑECO y ÁRBOL y CUERDA");
                    }
                }
            }

            bandera=false;

            System.out.println();
            for(i=0; i<n; i++) {
                System.out.print(" " + PalEsc[i] + " ");
            }
            System.out.println();

        }while(n!=numLetras && opo!=3);

        if(n==numLetras) {
            System.out.println("\nGANASTE");
        }else {
            System.out.println("\nAHORCADO");
        }
    }
}
