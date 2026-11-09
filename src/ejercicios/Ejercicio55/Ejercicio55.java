package ejercicios.Ejercicio55;

import java.util.Scanner;
import java.util.Random;

public class Ejercicio55 {

    public static void main(String[] args) {

        Random aleatorio = new Random();
        int[] secreto = new int[4];
        int[] intento = new int[4];

        int picas = 0;
        int fijas = 0;
        int intentos = 0;
        boolean repetido = false;

        Scanner teclado = new Scanner(System.in);

        // Generar los cuatro dígitos sin repetir.
        for (int i = 0; i < 4; i++) {
            do {
                secreto[i] = aleatorio.nextInt(10);
                repetido = false;

                // Comparar con los dígitos ya generados.
                for (int j = 0; j < i; j++) {
                    if (secreto[i] == secreto[j]) {
                        repetido = true;
                    }
                }
            } while (repetido == true);
        }

        System.out.println("...::: JUEGO DE PICAS Y FIJAS :::...\n");

        do{

            // Leer y validar el vector del jugador.
            for (int i = 0; i < 4; i++) {
                do {
                    System.out.print("Digite el numero en el intento [" + i + "]: ");
                    intento[i] = teclado.nextInt();

                    repetido = false;

                    for (int j = 0; j < i; j++) {
                        if (intento[i] == intento[j]) {
                            repetido = true;
                        }
                    }

                    if (intento[i] < 0 || intento[i] > 9) {
                        System.out.println("El número debe estar entre 0 a 9.");
                    }

                    if (repetido == true) {
                        System.out.println("El número ya fue ingresado.");
                    }

                } while (intento[i] < 0 || intento[i] > 9 || repetido == true);
            }

            intentos++;
            picas = 0;
            fijas = 0;

            // Comparar cada dígito del intento con todo el secreto.
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (intento[i] == secreto[j]) {
                        if (i == j) {
                            fijas++;
                        } else {
                            picas++;
                        }
                    }
                }
            }

            System.out.print("\nTu numero: ");
            for (int i = 0; i < 4; i++) {
                System.out.print(intento[i]);
            }

            System.out.println("\nPicas: " + picas);
            System.out.println("Fijas: " + fijas + "\n");
        } while (fijas < 4);

        System.out.println("\n¡Felicitaciones! Adivinaste el numero.");
        System.out.println("Cantidad de intentos: " + intentos);

        teclado.close();
    }
}
