package Ejercicio49;
import java.util.Scanner;
public class Ejercicio49 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
System.out.println("Digite la cantidad de posiciones (s) del vector:");
int s=teclado.nextInt();
int[] vector=new int[s];
int suma=0;
for (int i=0;i<s;i++){
    System.out.println("Digite el valor de la posicion "+i+":");
    vector[i]=teclado.nextInt();
    suma=suma+vector[i];
}
System.out.println("Vector cargado:");
for (int i=0;i<s;i++){
    System.out.print("["+vector[i]+"]");
    if (i<s-1){
        System.out.print("-");
    }
}
System.out.println();
System.out.println("La suma de todos los valores es: "+suma);

}

}
