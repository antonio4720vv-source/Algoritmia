package TallerMatriz;
import java.util.Scanner;

public class Punto3_7b_AcumuladoColumnas {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;
    int acumulado = 0;

    // Pedir los valores de la matriz, fila por fila
    System.out.println("Digite los valores de la matriz (5 filas y 5 columnas):");
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Valor de la posicion [" + i + "][" + j + "]:");
            matriz[i][j] = teclado.nextInt();
        }
    }

    // Se reinicia el acumulado cada vez que termina una columna
    System.out.println("3.7 Acumulado de cada columna:");
    for (j = 0; j < n; j++){
        acumulado = 0;
        for (i = 0; i < n; i++){
            acumulado = acumulado + matriz[i][j];
        }
        System.out.println("Columna " + j + ": " + acumulado);
    }
}

}
