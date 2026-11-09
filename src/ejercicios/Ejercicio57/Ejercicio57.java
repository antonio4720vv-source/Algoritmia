package ejercicios.Ejercicio57;
import java.util.Scanner;
public class Ejercicio57 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Declarar la matriz de 3 filas x 3 columnas
int[][] matriz=new int[3][3];
int i;
int j;
// Cargar la matriz: i es la fila, j es la columna
for (i=0; i<3; i++){
    for (j=0; j<3; j++){
        System.out.println("Digite el valor de la posicion ["+i+"]["+j+"]:");
        matriz[i][j]=teclado.nextInt();
    }
}
// Imprimir la matriz
System.out.println("La matriz es:");
for (i=0; i<3; i++){
    for (j=0; j<3; j++){
        System.out.printf("[%3d]", matriz[i][j]);
    }
    System.out.println();
}

}

}
