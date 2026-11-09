package ejercicios.Ejercicio27;
import java.util.Scanner;
public class Ejercicio27 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int numero;
System.out.println("Digite el numero de la tabla:");
numero=teclado.nextInt();
System.out.println("Tabla del "+numero+":");
int i;
for (i=1; i<=10; i++){
    System.out.println(numero+" x "+i+" = "+(numero*i));
}

}

}
