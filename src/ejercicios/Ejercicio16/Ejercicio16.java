package ejercicios.Ejercicio16;
import java.util.Scanner;
public class Ejercicio16 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double dinero, valorP, vueltas;
System.out.println("Digite el precio del producto:");
valorP=teclado.nextDouble();
System.out.println("Digite el dinero disponible:");
dinero=teclado.nextDouble();
if (valorP>dinero){
    System.out.println("No se puede comprar");
} else {
    System.out.println("Felicidades por la compra");
    vueltas=dinero-valorP;
    System.out.println("Sus vueltas son de: "+vueltas);
}

}

}
