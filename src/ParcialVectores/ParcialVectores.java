package ParcialVectores;
import java.util.Scanner;
public class ParcialVectores {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
    int x=0, n, k=0;
    System.out.println("Digite el valor de n:");
    n=teclado.nextInt();
    while (n>0) {
        k=n%10;
        x=x*10+k;
        n=n/10;
    }
    System.out.println("El resultado de x es: "+x);
}
}
