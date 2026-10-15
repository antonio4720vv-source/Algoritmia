package Ejercicio54;
import java.util.Scanner;
public class Ejercicio54 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
do {
    System.out.println("Digite el tamaño de los vectores (n):");
    n=teclado.nextInt();
} while (n<=0);
int[] v1=new int[n];
int[] v2=new int[n];
int[] v3=new int[n];
for (int i=0; i<n; i++){
    System.out.println("V1 - digite el valor de la posicion "+i+":");
    v1[i]=teclado.nextInt();
}
for (int i=0; i<n; i++){
    System.out.println("V2 - digite el valor de la posicion "+i+":");
    v2[i]=teclado.nextInt();
}
for (int i=0; i<n; i++){
    v3[i]=v1[i]+v2[i];
}
System.out.print("V1: ");
for (int i=0; i<n; i++){
    System.out.print(v1[i]+" ");
}
System.out.println();
System.out.print("V2: ");
for (int i=0; i<n; i++){
    System.out.print(v2[i]+" ");
}
System.out.println();
System.out.print("V3 (V1[i]+V2[i]): ");
for (int i=0; i<n; i++){
    System.out.print(v3[i]+" ");
}
System.out.println();

}

}
