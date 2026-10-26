package TallerMatriz;
import java.util.Scanner;

public class Punto3_6_TriangularInferiorSecundaria {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];

    // Pedir la matriz y calcular la operacion con la clase Operaciones
    matriz = Operaciones.leerMatriz(teclado, n);
    System.out.println("3.6 Triangular inferior (diagonal secundaria): " + Operaciones.triangularInferiorSecundaria(matriz));
}

}
