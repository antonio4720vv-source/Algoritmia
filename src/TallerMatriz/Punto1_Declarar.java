package TallerMatriz;
import java.util.Scanner;

public class Punto1_Declarar {

public static void main(String[] args){
    // Variables, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;

    // Punto 1: la matriz ya esta declarada; se muestra vacia (todo vale 0)
    System.out.println("Matriz declarada de " + n + "x" + n + ":");
    // Mostrar la matriz: cada valor entre corchetes, por ejemplo [4][9]
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.printf("[%2d]", matriz[i][j]);
        }
        System.out.println();
    }
}

}
