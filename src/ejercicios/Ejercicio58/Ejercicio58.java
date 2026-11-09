package ejercicios.Ejercicio58;
import java.util.Scanner;
public class Ejercicio58 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
do {
    System.out.println("Digite el tamano n de la matriz (n x n):");
    n=teclado.nextInt();
} while (n<1);
// Declarar la matriz cuadrada de n x n
int[][] matriz=new int[n][n];
int i;
int j;
// Cargar la matriz
for (i=0; i<n; i++){
    for (j=0; j<n; j++){
        System.out.println("Digite el valor de la posicion ["+i+"]["+j+"]:");
        matriz[i][j]=teclado.nextInt();
    }
}
// Sumar todos los valores
int suma=0;
for (i=0; i<n; i++){
    for (j=0; j<n; j++){
        suma=suma+matriz[i][j];
    }
}
// Imprimir la matriz
System.out.println("La matriz es:");
for (i=0; i<n; i++){
    for (j=0; j<n; j++){
        System.out.printf("[%3d]", matriz[i][j]);
    }
    System.out.println();
}
System.out.println("La suma de todos los valores es: "+suma);

}

}
