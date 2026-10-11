package Ejercicio5;
import java.util.Scanner;
public class Ejercicio5 {

public static void main(String[] args){
    double Base=0,Altura=0,Area=0;
Scanner teclado=new Scanner(System.in);
System.out.println("Digite la base:");
Base=teclado.nextDouble();
System.out.println("Digite la Altura:");
Altura= teclado.nextDouble();
Area=(Base*Altura)/2;
System.out.println("El Area es:"+Area);

}

}
