package MatrizTranspuesta;
import java.util.Scanner;
public class MatrizTranspuesta {

public static void main(String[] args){
    // Variables del programa principal, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 0;
    int i = 0;
    int j = 0;
    int[][] matriz;
    int[][] transpuesta;

    // Paso 1: leer el tamaño n (de 1 a 10)
    do {
        System.out.println("Digite el tamaño n de la matriz (de 1 a 10):");
        n = teclado.nextInt();
    } while (n < 1 || n > 10);

    // Paso 2: leer la matriz
    matriz = new int[n][n];
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Digite el valor de la posición " + i + "," + j + ":");
            matriz[i][j] = teclado.nextInt();
        }
    }

    // Paso 3: la transpuesta cambia filas por columnas: el valor de (i, j) pasa a (j, i)
    transpuesta = new int[n][n];
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            transpuesta[j][i] = matriz[i][j];
        }
    }

    // Paso 4: imprimir las dos matrices
    System.out.println("Matriz original:");
    imprimirMatriz(matriz);
    System.out.println("Matriz transpuesta:");
    imprimirMatriz(transpuesta);
}

static void imprimirMatriz(int[][] matriz){
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            System.out.printf("[%4d] ", matriz[i][j]);
        }
        System.out.println();
    }
}

}
