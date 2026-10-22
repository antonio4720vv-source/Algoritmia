package MatrizInversa;
import java.util.Scanner;
public class MatrizInversa {

public static void main(String[] args){
    // Variables del programa principal, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 0;
    int columnas = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int fila = 0;
    double pivote = 0;
    double factor = 0;
    double temporal = 0;
    boolean singular = false;
    double[][] aumentada;

    // Paso 1: leer el tamaño n (de 1 a 10)
    do {
        System.out.println("Digite el tamaño n de la matriz (de 1 a 10):");
        n = teclado.nextInt();
    } while (n < 1 || n > 10);

    // La matriz aumentada es [A | I]: a la izquierda la matriz A, a la derecha la identidad
    columnas = 2 * n;
    aumentada = new double[n][columnas];

    // Paso 2: leer la matriz A
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Digite el valor de la posición " + i + "," + j + ":");
            aumentada[i][j] = teclado.nextDouble();
        }
    }

    // Paso 3: poner la identidad a la derecha
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (i == j){
                aumentada[i][n + j] = 1;
            } else {
                aumentada[i][n + j] = 0;
            }
        }
    }

    // Paso 4: Gauss-Jordan. Se hacen ceros arriba y abajo de cada pivote
    for (k = 0; k < n && !singular; k++){
        // 4a: buscar la fila con el valor más grande en la columna k (pivoteo parcial)
        fila = k;
        for (i = k + 1; i < n; i++){
            if (Math.abs(aumentada[i][k]) > Math.abs(aumentada[fila][k])){
                fila = i;
            }
        }

        if (Math.abs(aumentada[fila][k]) < 1e-12){
            // 4b: si el pivote es cero, la matriz no tiene inversa
            singular = true;
        } else {
            // 4c: intercambiar la fila k con la fila del pivote
            for (j = 0; j < columnas; j++){
                temporal = aumentada[k][j];
                aumentada[k][j] = aumentada[fila][j];
                aumentada[fila][j] = temporal;
            }

            // 4d: dividir la fila k entre el pivote para que el pivote valga 1
            pivote = aumentada[k][k];
            for (j = 0; j < columnas; j++){
                aumentada[k][j] = aumentada[k][j] / pivote;
            }

            // 4e: hacer cero la columna k en las demás filas
            for (i = 0; i < n; i++){
                if (i != k){
                    factor = aumentada[i][k];
                    for (j = 0; j < columnas; j++){
                        aumentada[i][j] = aumentada[i][j] - factor * aumentada[k][j];
                    }
                }
            }
        }
    }

    // Paso 5: mostrar el resultado
    if (singular){
        System.out.println("La matriz no tiene inversa (es singular).");
    } else {
        System.out.println("Matriz inversa:");
        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                System.out.printf("%10.4f", aumentada[i][n + j]);
            }
            System.out.println();
        }
    }
}

}
