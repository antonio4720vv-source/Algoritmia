package TallerMatriz;
import java.util.Scanner;

public class Punto2_Llenar {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;

    // Punto 2: llenar la matriz con valores enteros
    // Pedir los valores de la matriz, fila por fila
    System.out.println("Digite los valores de la matriz (5 filas y 5 columnas):");
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Valor de la posicion [" + i + "][" + j + "]:");
            matriz[i][j] = teclado.nextInt();
        }
    }

    System.out.println("Matriz llena:");
    // Mostrar la matriz: cada valor entre corchetes, por ejemplo [4][9]
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.printf("[%2d]", matriz[i][j]);
        }
        System.out.println();
    }
}

}
