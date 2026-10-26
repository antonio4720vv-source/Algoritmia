package TallerMatriz;
import java.util.Scanner;

public class Punto3_6b_TodaLaMatriz {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];

    // Pedir la matriz y calcular la operacion con la clase Operaciones
    matriz = Operaciones.leerMatriz(teclado, n);
    System.out.println("3.6 Acumulado de toda la matriz: " + Operaciones.sumaTotal(matriz));
}

}
