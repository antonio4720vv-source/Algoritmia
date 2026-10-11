package Ejercicio7;
import java.util.Scanner;
public class Ejercicio7 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
System.out.println("Digite el valor de A:");
double a=teclado.nextDouble();
System.out.println("Digite el valor de B:");
double b=teclado.nextDouble();
System.out.println("Digite el valor de C:");
double c=teclado.nextDouble();
double d;
do {
    System.out.println("Digite el valor de D (diferente de 0):");
    d=teclado.nextDouble();
} while (d==0);
double x=(Math.pow(a,2)+Math.pow(b,2))+c/Math.pow(d,3)+4;
System.out.println("x=(A^2+B^2)+C/D^3+4");
System.out.println("El resultado de x es: "+x);

}

}
