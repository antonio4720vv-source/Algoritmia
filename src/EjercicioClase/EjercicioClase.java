package EjercicioClase;
import java.util.Scanner;
public class EjercicioClase {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
do {
    System.out.println("Digite el tamaño de los vectores (n):");
    n=teclado.nextInt();
} while (n<=0);
int[] vector1=new int[n];
int[] vector2=new int[n];
int[] vector3=new int[n];
for (int i=0; i<n; i++){
    System.out.println("Vector 1 - digite el valor de la posicion "+i+":");
    vector1[i]=teclado.nextInt();
}
for (int i=0; i<n; i++){
    System.out.println("Vector 2 - digite el valor de la posicion "+i+":");
    vector2[i]=teclado.nextInt();
}
for (int i=0; i<n; i++){
    vector3[i]=vector1[i]+vector2[i];
}
System.out.print("Vector 1: ");
for (int i=0; i<n; i++){
    System.out.print(vector1[i]+" ");
}
System.out.println();
System.out.print("Vector 2: ");
for (int i=0; i<n; i++){
    System.out.print(vector2[i]+" ");
}
System.out.println();
System.out.print("Vector 3 (suma): ");
for (int i=0; i<n; i++){
    System.out.print(vector3[i]+" ");
}
System.out.println();

}

}
