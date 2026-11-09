package ejercicios.Ejercicio29;
import java.util.Scanner;
public class Ejercicio29 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
do {
    System.out.println("Digite cuantos productos va a comprar:");
    n=teclado.nextInt();
} while (n<1);
double valor;
double total=0;
int i;
for (i=1; i<=n; i++){
    do {
        System.out.println("Digite el valor del producto "+i+":");
        valor=teclado.nextDouble();
    } while (valor<0);
    total=total+valor;
}
System.out.println("El total a pagar es: "+total);

}

}
