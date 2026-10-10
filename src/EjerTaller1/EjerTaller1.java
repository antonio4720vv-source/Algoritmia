package EjerTaller1;
import java.util.Scanner;
public class EjerTaller1 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
do {
    System.out.println("Digite la cantidad de posiciones (n) del vector (mayor que 0):");
    n=teclado.nextInt();
} while (n<=0);
int[] vector=new int[n];
int pares=0;
int impares=0;
for (int i=0;i<n;i++){
    System.out.println("Digite el valor de la posicion "+i+":");
    vector[i]=teclado.nextInt();
    if (vector[i]%2==0){
        pares++;
    } else {
        impares++;
    }
}
System.out.println("Vector cargado:");
for (int i=0;i<n;i++){
    System.out.print("["+vector[i]+"]");
    if (i<n-1){
        System.out.print("-");
    }
}
System.out.println();
System.out.println("Cantidad de numeros pares: "+pares);
System.out.println("Cantidad de numeros impares: "+impares);

}

}
