package Ejercicio10;
import java.util.Scanner;
public class Ejercicio10 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double a;
do {
    System.out.println("Digite el valor de A (diferente de 0):");
    a=teclado.nextDouble();
} while (a==0);
System.out.println("Digite el valor de B:");
double b=teclado.nextDouble();
System.out.println("Digite el valor de C:");
double c=teclado.nextDouble();
System.out.println("Digite el valor de E:");
double e=teclado.nextDouble();
double x=a*b-b*c/a*e-8;
System.out.println("X=A*B-B*C/A*E-8");
System.out.println("El resultado de X es: "+x);

}

}
