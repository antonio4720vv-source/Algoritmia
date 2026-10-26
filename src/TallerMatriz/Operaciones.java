package TallerMatriz;
import java.util.Scanner;

// Clase con todas las operaciones del taller.
// Los demas programas la usan llamando a sus metodos.
public class Operaciones {

// Pide los valores de la matriz, fila por fila
static int[][] leerMatriz(Scanner teclado, int n){
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Valor de la posicion [" + i + "][" + j + "]:");
            matriz[i][j] = teclado.nextInt();
        }
    }
    return matriz;
}

// Muestra la matriz, cada valor entre corchetes: [81][47]...
static void imprimirMatriz(int[][] matriz){
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            System.out.printf("[%2d]", matriz[i][j]);
        }
        System.out.println();
    }
}

// 3.1 Diagonal principal: i == j
static int diagonalPrincipal(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i == j){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

// 3.2 Diagonal secundaria: i + j == n - 1
static int diagonalSecundaria(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i + j == matriz.length - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

// 3.3 Triangular superior (diagonal principal): i < j
static int triangularSuperiorPrincipal(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i < j){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

// 3.4 Triangular inferior (diagonal principal): i > j
static int triangularInferiorPrincipal(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i > j){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

// 3.5 Triangular superior (diagonal secundaria): i + j < n - 1
static int triangularSuperiorSecundaria(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i + j < matriz.length - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

// 3.6 Triangular inferior (diagonal secundaria): i + j > n - 1
static int triangularInferiorSecundaria(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i + j > matriz.length - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

// 3.6 (segundo) Toda la matriz
static int sumaTotal(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            suma = suma + matriz[i][j];
        }
    }
    return suma;
}

// 3.7 Acumulado de cada fila (se reinicia en cada fila)
static int[] sumaFilas(int[][] matriz){
    int[] resultado = new int[matriz.length];
    int acumulado = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        acumulado = 0;
        for (j = 0; j < matriz.length; j++){
            acumulado = acumulado + matriz[i][j];
        }
        resultado[i] = acumulado;
    }
    return resultado;
}

// 3.7 (segundo) Acumulado de cada columna (se reinicia en cada columna)
static int[] sumaColumnas(int[][] matriz){
    int[] resultado = new int[matriz.length];
    int acumulado = 0;
    int i = 0;
    int j = 0;
    for (j = 0; j < matriz.length; j++){
        acumulado = 0;
        for (i = 0; i < matriz.length; i++){
            acumulado = acumulado + matriz[i][j];
        }
        resultado[j] = acumulado;
    }
    return resultado;
}

}
