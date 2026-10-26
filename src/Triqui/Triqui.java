package Triqui;
import java.util.Scanner;

public class Triqui {

public static void main(String[] args){
    Scanner teclado = new Scanner(System.in);
    char[][] tablero = new char[3][3];
    int i = 0;
    int j = 0;
    char jugador = 'X';
    int fila = 0;
    int columna = 0;
    int turnos = 0;
    boolean ganador = false;

    // Tablero vacio: todas las casillas en blanco
    for (i = 0; i < 3; i++){
        for (j = 0; j < 3; j++){
            tablero[i][j] = ' ';
        }
    }

    // El juego sigue hasta que alguien gane o se llenen las 9 casillas
    while (!ganador && turnos < 9){
        imprimirTablero(tablero);
        System.out.println("Turno de " + jugador);

        // Pedir una casilla libre (fila y columna de 1 a 3)
        do {
            System.out.println("Digite fila (1 a 3):");
            fila = teclado.nextInt() - 1;
            System.out.println("Digite columna (1 a 3):");
            columna = teclado.nextInt() - 1;
            if (fila < 0 || fila > 2 || columna < 0 || columna > 2 || tablero[fila][columna] != ' '){
                System.out.println("Casilla no valida u ocupada. Intente de nuevo.");
            }
        } while (fila < 0 || fila > 2 || columna < 0 || columna > 2 || tablero[fila][columna] != ' ');

        tablero[fila][columna] = jugador;
        turnos = turnos + 1;

        ganador = hayGanador(tablero, jugador);

        // Cambiar de jugador
        if (jugador == 'X'){
            jugador = 'O';
        } else {
            jugador = 'X';
        }
    }

    imprimirTablero(tablero);
    if (ganador){
        // Como el jugador ya cambio, el ganador es el anterior
        if (jugador == 'X'){
            System.out.println("Gano O!");
        } else {
            System.out.println("Gano X!");
        }
    } else {
        System.out.println("Empate!");
    }
}

static void imprimirTablero(char[][] tablero){
    int i = 0;
    int j = 0;
    System.out.println();
    for (i = 0; i < 3; i++){
        System.out.println(" " + tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2]);
        if (i < 2){
            System.out.println("---+---+---");
        }
    }
    System.out.println();
}

static boolean hayGanador(char[][] t, char jugador){
    int i = 0;
    boolean gana = false;
    // Filas y columnas
    for (i = 0; i < 3; i++){
        if (t[i][0] == jugador && t[i][1] == jugador && t[i][2] == jugador) gana = true;
        if (t[0][i] == jugador && t[1][i] == jugador && t[2][i] == jugador) gana = true;
    }
    // Diagonales
    if (t[0][0] == jugador && t[1][1] == jugador && t[2][2] == jugador) gana = true;
    if (t[0][2] == jugador && t[1][1] == jugador && t[2][0] == jugador) gana = true;
    return gana;
}

}
