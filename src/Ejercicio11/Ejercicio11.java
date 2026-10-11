package Ejercicio11;
import java.util.Scanner;
public class Ejercicio11 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double capital;
do {
    System.out.println("Digite el valor del prestamo (mayor que 0):");
    capital=teclado.nextDouble();
} while (capital<=0);
double interesMensual=capital*0.02;
double interesAnual=interesMensual*12;
double total=capital+interesAnual;
System.out.println("Interes mensual (2%): "+interesMensual);
System.out.println("Interes total en 12 meses: "+interesAnual);
System.out.println("Monto total a pagar al cabo de 12 meses: "+total);

}

}
