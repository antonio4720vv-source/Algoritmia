package ejercicios.Ejercicio25;
import java.util.Scanner;
public class Ejercicio25 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double num1;
double num2;
System.out.println("Digite el primer numero:");
num1=teclado.nextDouble();
System.out.println("Digite el segundo numero:");
num2=teclado.nextDouble();
System.out.println("Los numeros en orden ascendente son:");
if (num1<=num2){
    System.out.println(num1+" , "+num2);
} else {
    System.out.println(num2+" , "+num1);
}

}

}
