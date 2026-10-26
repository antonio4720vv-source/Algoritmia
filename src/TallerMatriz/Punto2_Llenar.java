package TallerMatriz;
import java.util.Scanner;

public class Punto2_Llenar {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];

    // Punto 2: llenar la matriz
    matriz = Operaciones.leerMatriz(teclado, n);
    System.out.println("Matriz llena:");
    Operaciones.imprimirMatriz(matriz);
}

}
