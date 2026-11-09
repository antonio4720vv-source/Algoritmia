package ejercicios.Ejercicio42;
import java.util.Scanner;
public class Ejercicio42 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double valor;
double total=0;
int productos=0;
String respuesta;
do {
    do {
        System.out.println("Digite el valor del producto "+(productos+1)+":");
        valor=teclado.nextDouble();
    } while (valor<0);
    total=total+valor;
    productos=productos+1;
    // Preguntar hasta que responda S o N
    do {
        System.out.println("¿Desea seguir comprando? (S/N):");
        respuesta=teclado.next();
    } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
} while (respuesta.equalsIgnoreCase("S"));
System.out.println("Cantidad de productos comprados: "+productos);
System.out.println("El total a pagar es: "+total);

}

}
