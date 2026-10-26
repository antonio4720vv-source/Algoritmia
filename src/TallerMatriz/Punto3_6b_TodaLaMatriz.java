package TallerMatriz;

public class Punto3_6b_TodaLaMatriz {

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
    // Se suman todas las posiciones de la matriz
    int suma = 0;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (true){
                suma = suma + matriz[i][j];
            }
        }
    }
    System.out.println("3.6 Acumulado de toda la matriz: " + suma);
}

}
