package TallerMatriz;
import java.util.Scanner;

public class Punto4_ImprimirTodo {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;
    int suma = 0;
    int acumulado = 0;

    // Pedir los valores de la matriz, fila por fila
    System.out.println("Digite los valores de la matriz (5 filas y 5 columnas):");
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Valor de la posicion [" + i + "][" + j + "]:");
            matriz[i][j] = teclado.nextInt();
        }
    }

    // Imprimir la matriz completa
    System.out.println("Matriz:");
    // Mostrar la matriz: cada valor entre corchetes, por ejemplo [4][9]
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.printf("[%2d]", matriz[i][j]);
        }
        System.out.println();
    }

    // Imprimir los acumulados (uno por uno, con su condicion)
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i == j) suma = suma + matriz[i][j];
        }
    }
    System.out.println("Diagonal principal: " + suma);

    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i + j == n - 1) suma = suma + matriz[i][j];
        }
    }
    System.out.println("Diagonal secundaria: " + suma);

    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i < j) suma = suma + matriz[i][j];
        }
    }
    System.out.println("Triangular superior (diagonal principal): " + suma);

    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i > j) suma = suma + matriz[i][j];
        }
    }
    System.out.println("Triangular inferior (diagonal principal): " + suma);

    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i + j < n - 1) suma = suma + matriz[i][j];
        }
    }
    System.out.println("Triangular superior (diagonal secundaria): " + suma);

    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i + j > n - 1) suma = suma + matriz[i][j];
        }
    }
    System.out.println("Triangular inferior (diagonal secundaria): " + suma);

    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            suma = suma + matriz[i][j];
        }
    }
    System.out.println("Toda la matriz: " + suma);

    for (i = 0; i < n; i++){
        acumulado = 0;
        for (j = 0; j < n; j++){
            acumulado = acumulado + matriz[i][j];
        }
        System.out.println("Fila " + i + ": " + acumulado);
    }

    for (j = 0; j < n; j++){
        acumulado = 0;
        for (i = 0; i < n; i++){
            acumulado = acumulado + matriz[i][j];
        }
        System.out.println("Columna " + j + ": " + acumulado);
    }
}

}
