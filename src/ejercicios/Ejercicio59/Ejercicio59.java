package ejercicios.Ejercicio59;
import java.util.Scanner;
public class Ejercicio59 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
int m;
do {
    System.out.println("Digite el numero de filas (n):");
    n=teclado.nextInt();
} while (n<1);
do {
    System.out.println("Digite el numero de columnas (m):");
    m=teclado.nextInt();
} while (m<1);
// Declarar la matriz de n filas x m columnas
int[][] matriz=new int[n][m];
int i;
int j;
// Cargar la matriz
for (i=0; i<n; i++){
    for (j=0; j<m; j++){
        System.out.println("Digite el valor de la posicion ["+i+"]["+j+"]:");
        matriz[i][j]=teclado.nextInt();
    }
}
// Sumar todos los valores
int suma=0;
for (i=0; i<n; i++){
    for (j=0; j<m; j++){
        suma=suma+matriz[i][j];
    }
}
// Imprimir la matriz
System.out.println("La matriz es:");
for (i=0; i<n; i++){
    for (j=0; j<m; j++){
        System.out.printf("[%3d]", matriz[i][j]);
    }
    System.out.println();
}
System.out.println("La suma de todos los valores es: "+suma);

}

}
