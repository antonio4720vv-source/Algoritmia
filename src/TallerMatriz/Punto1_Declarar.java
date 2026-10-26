package TallerMatriz;
import java.util.Scanner;

public class Punto1_Declarar {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];

    // Punto 1: la matriz ya esta declarada (todas las posiciones valen 0)
    System.out.println("Matriz declarada de " + n + "x" + n + ":");
    Operaciones.imprimirMatriz(matriz);
}

}
