package TallerMatriz;
import java.util.Scanner;

public class Punto4_ImprimirTodo {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];

    // Punto 4: imprimir la matriz y todos los acumulados
    matriz = Operaciones.leerMatriz(teclado, n);
    System.out.println("Matriz:");
    Operaciones.imprimirMatriz(matriz);

    System.out.println("Diagonal principal: " + Operaciones.diagonalPrincipal(matriz));
    System.out.println("Diagonal secundaria: " + Operaciones.diagonalSecundaria(matriz));
    System.out.println("Triangular superior (diagonal principal): " + Operaciones.triangularSuperiorPrincipal(matriz));
    System.out.println("Triangular inferior (diagonal principal): " + Operaciones.triangularInferiorPrincipal(matriz));
    System.out.println("Triangular superior (diagonal secundaria): " + Operaciones.triangularSuperiorSecundaria(matriz));
    System.out.println("Triangular inferior (diagonal secundaria): " + Operaciones.triangularInferiorSecundaria(matriz));
    System.out.println("Toda la matriz: " + Operaciones.sumaTotal(matriz));

    int[] filas = Operaciones.sumaFilas(matriz);
    for (int i = 0; i < n; i++){
        System.out.println("Fila " + i + ": " + filas[i]);
    }
    int[] columnas = Operaciones.sumaColumnas(matriz);
    for (int j = 0; j < n; j++){
        System.out.println("Columna " + j + ": " + columnas[j]);
    }
}

}
