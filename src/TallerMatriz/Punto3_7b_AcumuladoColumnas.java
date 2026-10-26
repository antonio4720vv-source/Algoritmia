package TallerMatriz;
import java.util.Scanner;

public class Punto3_7b_AcumuladoColumnas {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];

    // Pedir la matriz y calcular el acumulado de cada columna
    matriz = Operaciones.leerMatriz(teclado, n);
    int[] columnas = Operaciones.sumaColumnas(matriz);
    System.out.println("3.7 Acumulado de cada columna:");
    for (int j = 0; j < n; j++){
        System.out.println("Columna " + j + ": " + columnas[j]);
    }
}

}
