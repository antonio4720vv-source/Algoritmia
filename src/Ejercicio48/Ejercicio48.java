package Ejercicio48;
import java.util.Scanner;
public class Ejercicio48 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
System.out.println("Digite la cantidad de posiciones (s) del vector:");
int s=teclado.nextInt();
int[] vector=new int[s];
for (int i=0;i<s;i++){
    System.out.println("Digite el valor de la posicion "+i+":");
    vector[i]=teclado.nextInt();
}
System.out.println("Vector cargado:");
for (int i=0;i<s;i++){
    System.out.print("["+vector[i]+"]");
    if (i<s-1){
        System.out.print("-");
    }
}
System.out.println();

}

}
