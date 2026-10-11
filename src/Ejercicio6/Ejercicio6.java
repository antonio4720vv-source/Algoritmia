package Ejercicio6;
import java.util.Scanner;
public class Ejercicio6 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double valor;
do {
    System.out.println("Digite el valor del producto (mayor que 0):");
    valor=teclado.nextDouble();
} while (valor<=0);
System.out.println("Digite el dinero disponible:");
double dinero=teclado.nextDouble();
int ventas=(int)(dinero/valor);
double sobrante=dinero-ventas*valor;
System.out.println("Valor del producto: "+valor);
System.out.println("Dinero disponible: "+dinero);
System.out.println("Ventas (unidades que se pueden comprar): "+ventas);
System.out.println("Dinero sobrante: "+sobrante);

}

}
