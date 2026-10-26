package TallerMatrizSencillo;
import java.util.Scanner;
public class TallerMatrizSencillo {

public static void main(String[] args){
    // ---------- PUNTO 1: declarar la matriz de n x n ----------
    // Vamos a suponer que n es 5
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];

    // Variables que vamos a usar en los puntos siguientes (todas al inicio)
    int i = 0;
    int j = 0;
    int suma = 0;
    int[] filas = new int[n];
    int[] columnas = new int[n];
    int acumulado = 0;

    // ---------- PUNTO 2: llenar la matriz con valores enteros ----------
    System.out.println("PUNTO 2: llenar la matriz");
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Digite el valor de la posicion " + i + "," + j + ":");
            matriz[i][j] = teclado.nextInt();
        }
    }

    // Mostrar la matriz completa (lo usamos para revisar)
    System.out.println();
    System.out.println("Matriz:");
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.printf("[%4d] ", matriz[i][j]);
        }
        System.out.println();
    }

    // ---------- PUNTO 3.1: acumulado de la diagonal principal ----------
    // La diagonal principal son las posiciones donde i es igual a j
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i == j){
                suma = suma + matriz[i][j];
            }
        }
    }
    System.out.println();
    System.out.println("3.1 Diagonal principal = " + suma);

    // ---------- PUNTO 3.2: acumulado de la diagonal secundaria ----------
    // La diagonal secundaria son las posiciones donde i + j es igual a n - 1
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i + j == n - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    System.out.println("3.2 Diagonal secundaria = " + suma);

    // ---------- PUNTO 3.3: triangular superior (diagonal principal) ----------
    // Son las posiciones donde i es menor que j (arriba de la diagonal principal)
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i < j){
                suma = suma + matriz[i][j];
            }
        }
    }
    System.out.println("3.3 Triangular superior (diagonal principal) = " + suma);

    // ---------- PUNTO 3.4: triangular inferior (diagonal principal) ----------
    // Son las posiciones donde i es mayor que j (abajo de la diagonal principal)
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i > j){
                suma = suma + matriz[i][j];
            }
        }
    }
    System.out.println("3.4 Triangular inferior (diagonal principal) = " + suma);

    // ---------- PUNTO 3.5: triangular superior (diagonal secundaria) ----------
    // Son las posiciones donde i + j es menor que n - 1
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i + j < n - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    System.out.println("3.5 Triangular superior (diagonal secundaria) = " + suma);

    // ---------- PUNTO 3.6: triangular inferior (diagonal secundaria) ----------
    // Son las posiciones donde i + j es mayor que n - 1
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i + j > n - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    System.out.println("3.6 Triangular inferior (diagonal secundaria) = " + suma);

    // ---------- PUNTO 3.7: acumulado de toda la matriz ----------
    // Se suman todas las posiciones, sin condicion
    suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            suma = suma + matriz[i][j];
        }
    }
    System.out.println("3.7 Toda la matriz = " + suma);

    // ---------- PUNTO 3.8: acumulado de cada fila ----------
    // Se reinicia el acumulado cada vez que termina una fila
    for (i = 0; i < n; i++){
        acumulado = 0;
        for (j = 0; j < n; j++){
            acumulado = acumulado + matriz[i][j];
        }
        filas[i] = acumulado;
    }
    System.out.print("3.8 Acumulado de cada fila: ");
    for (i = 0; i < n; i++){
        System.out.print(filas[i] + " ");
    }
    System.out.println();

    // ---------- PUNTO 3.9: acumulado de cada columna ----------
    // Se reinicia el acumulado cada vez que termina una columna
    for (j = 0; j < n; j++){
        acumulado = 0;
        for (i = 0; i < n; i++){
            acumulado = acumulado + matriz[i][j];
        }
        columnas[j] = acumulado;
    }
    System.out.print("3.9 Acumulado de cada columna: ");
    for (j = 0; j < n; j++){
        System.out.print(columnas[j] + " ");
    }
    System.out.println();

    // ---------- PUNTO 4: imprimir toda la matriz y cada acumulado ----------
    // Ya se imprimio la matriz arriba, y cada acumulado en su punto.
    System.out.println();
    System.out.println("PUNTO 4 terminado: se imprimio la matriz y todos los acumulados.");
}

}
