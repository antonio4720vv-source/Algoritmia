package Ejercicio16;
import java.util.Scanner;
public class Ejercicio16 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
System.out.println("Digite el primer numero (dividendo):");
double a=teclado.nextDouble();
double b;
do {
    System.out.println("Digite el segundo numero (divisor, diferente de 0):");
    b=teclado.nextDouble();
} while (b==0);
double division=a/b;
System.out.println(a+" / "+b+" = "+division);

}

}
