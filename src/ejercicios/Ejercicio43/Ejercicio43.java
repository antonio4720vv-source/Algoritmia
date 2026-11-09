package ejercicios.Ejercicio43;
import java.util.Scanner;
public class Ejercicio43 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double dinero;
do {
    System.out.println("Digite el dinero disponible:");
    dinero=teclado.nextDouble();
} while (dinero<=0);
double valor;
double total=0;
int productos=0;
String respuesta="S";
do {
    do {
        System.out.println("Digite el valor del producto:");
        valor=teclado.nextDouble();
    } while (valor<0);
    // Solo se compra si el dinero que queda alcanza
    if (total+valor<=dinero){
        total=total+valor;
        productos=productos+1;
        System.out.println("Producto comprado. Le quedan: "+(dinero-total));
    } else {
        System.out.println("No le alcanza el dinero para este producto. Le quedan: "+(dinero-total));
    }
    // Si ya no queda dinero, se termina la compra
    if (total==dinero){
        System.out.println("Ya no le queda dinero");
        respuesta="N";
    } else {
        do {
            System.out.println("Desea seguir comprando? (S/N):");
            respuesta=teclado.next();
        } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
    }
} while (respuesta.equalsIgnoreCase("S"));
double vueltas=dinero-total;
System.out.println("Cantidad de productos comprados: "+productos);
System.out.println("Total a pagar: "+total);
System.out.println("Vueltas: "+vueltas);

}

}
