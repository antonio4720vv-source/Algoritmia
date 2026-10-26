package TallerMatriz;

public class Punto1_Declarar {

public static void main(String[] args){
    // Punto 1: declarar la matriz de n x n (n = 5)
    int n = 5;
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;
    // Mostrar la matriz vacia (todas las posiciones valen 0)
    System.out.println("Matriz declarada de " + n + "x" + n + ":");
    // Mostrar la matriz
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.printf("[%4d] ", matriz[i][j]);
        }
        System.out.println();
    }
}

}
