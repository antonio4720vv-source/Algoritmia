package TallerMatriz;
import java.util.Scanner;

public class Punto3_7_AcumuladoFilas {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];

    // Pedir la matriz y calcular el acumulado de cada fila
    matriz = Operaciones.leerMatriz(teclado, n);
    int[] filas = Operaciones.sumaFilas(matriz);
    System.out.println("3.7 Acumulado de cada fila:");
    for (int i = 0; i < n; i++){
        System.out.println("Fila " + i + ": " + filas[i]);
    }
}

}
