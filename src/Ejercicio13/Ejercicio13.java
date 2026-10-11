package Ejercicio13;
import java.util.Scanner;
public class Ejercicio13 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
System.out.println("Digite un numero entero:");
int numero=teclado.nextInt();
if (numero%2==0){
    System.out.println("El numero "+numero+" es par");
} else {
    System.out.println("El numero "+numero+" es impar");
}

}

}
