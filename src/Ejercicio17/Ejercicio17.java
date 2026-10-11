package Ejercicio17;
import java.util.Scanner;
public class Ejercicio17 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double boleta;
do {
    System.out.println("Digite el valor de la boleta (mayor que 0):");
    boleta=teclado.nextDouble();
} while (boleta<=0);
int opcion;
do {
    System.out.println("La persona es estudiante o adulto mayor? (1=si, 2=no):");
    opcion=teclado.nextInt();
} while (opcion!=1 && opcion!=2);
double total;
if (opcion==1){
    total=boleta-boleta*0.20;
    System.out.println("Tiene descuento del 20%");
} else {
    total=boleta;
    System.out.println("No tiene descuento");
}
System.out.println("Total a pagar: "+total);

}

}
