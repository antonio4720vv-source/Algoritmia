package TallerMatriz;

public class Punto4_ImprimirTodo {

public static void main(String[] args){
    // Punto 1: declarar la matriz de n x n (n = 5)
    int n = 5;
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;
    // Punto 2: llenar la matriz con valores enteros
    matriz = new int[][]{
            {81, 47, 67, 76, 24},
            {20,  1, 62, 30, 58},
            {59, 80, 94,  1, 91},
            {23, 17, 63, 25, 29},
            {86, 70, 16, 63, 35}
        };
    // Imprimir la matriz completa
    System.out.println("Matriz:");
    // Mostrar la matriz
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.printf("[%4d] ", matriz[i][j]);
        }
        System.out.println();
    }
    // Imprimir los acumulados
    System.out.println();
    System.out.println("Acumulados:");
    int suma = 0;
    int acumulado = 0;
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
