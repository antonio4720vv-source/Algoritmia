package TallerMatriz;
import java.util.Scanner;

public class Punto3_4_TriangularInferiorPrincipal {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;
    int suma = 0;

    // Pedir los valores de la matriz, fila por fila
    System.out.println("Digite los valores de la matriz (5 filas y 5 columnas):");
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Valor de la posicion [" + i + "][" + j + "]:");
            matriz[i][j] = teclado.nextInt();
        }
    }

    // Abajo de la diagonal principal: i es mayor que j
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i > j){
                suma = suma + matriz[i][j];
            }
        }
    }
    System.out.println("3.4 Triangular inferior (diagonal principal): " + suma);
}

}
