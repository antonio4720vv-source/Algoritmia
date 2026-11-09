package ejercicios.Ejercicio13;
import java.util.Scanner;
public class Ejercicio13 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double n1, n2, n3, pro;
System.out.println("Digite la nota 1:");
n1=teclado.nextDouble();
System.out.println("Digite la nota 2:");
n2=teclado.nextDouble();
System.out.println("Digite la nota 3:");
n3=teclado.nextDouble();
pro=(n1+n2+n3)/3;
System.out.println("El promedio es: "+pro);
if (pro>=3.0){
    System.out.println("Paso");
} else {
    System.out.println("Perdio");
}

}

}
