package TallerMatriz;

public class Punto3_7b_AcumuladoColumnas {

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
    // Se reinicia el acumulado cada vez que termina una columna
    int acumulado = 0;
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
