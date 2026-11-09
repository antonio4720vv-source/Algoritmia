package ejercicios.Ejercicio33;
import java.util.Scanner;
public class Ejercicio33 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Serie de Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, ...
// Cada termino es la suma de los dos anteriores
int n;
do {
    System.out.println("Digite que termino de la serie quiere ver (1 a 92):");
    n=teclado.nextInt();
} while (n<1 || n>92);
long anterior=0;
long actual=1;
long siguiente;
long termino;
if (n==1){
    termino=0;
} else {
    int i;
    for (i=3; i<=n; i++){
        siguiente=anterior+actual;
        anterior=actual;
        actual=siguiente;
    }
    termino=actual;
}
System.out.println("El termino "+n+" de la serie Fibonacci es: "+termino);

}

}
