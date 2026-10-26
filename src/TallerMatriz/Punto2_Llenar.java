package TallerMatriz;

public class Punto2_Llenar {

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
    System.out.println("Matriz llena:");
    // Mostrar la matriz
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.printf("[%4d] ", matriz[i][j]);
        }
        System.out.println();
    }
}

}
