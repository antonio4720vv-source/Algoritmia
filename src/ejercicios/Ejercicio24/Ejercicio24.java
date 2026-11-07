package ejercicios.Ejercicio24;
import java.util.Scanner;
public class Ejercicio24 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int num1;
int num2;
System.out.println("Digite el primer numero entero:");
num1=teclado.nextInt();
System.out.println("Digite el segundo numero entero:");
num2=teclado.nextInt();
int suma=num1+num2;
int multiplicacion=num1*num2;
// Se divide por 2.0 para que el promedio tenga decimales (ej: 3 y 4 = 3.5)
double promedio=suma/2.0;
System.out.println("La suma es: "+suma);
System.out.println("La multiplicacion es: "+multiplicacion);
System.out.println("El promedio es: "+promedio);

}

}
