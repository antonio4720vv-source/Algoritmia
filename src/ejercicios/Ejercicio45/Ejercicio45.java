package ejercicios.Ejercicio45;
import java.util.Scanner;
public class Ejercicio45 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Conjetura de Ullman: si n es par se divide entre 2,
// si es impar se multiplica por 3 y se le suma 1, hasta llegar a 1
int n;
do {
    System.out.println("Digite un numero entero mayor que 1:");
    n=teclado.nextInt();
} while (n<=1);
System.out.print(n+" ");
while (n!=1){
    if (n%2==0){
        n=n/2;
    } else {
        n=n*3+1;
    }
    System.out.print(n+" ");
}
System.out.println();

}

}
