package EjerTaller2;
import java.util.Scanner;
public class EjerTaller2 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
do {
    System.out.println("Digite la cantidad de posiciones (n) de los vectores (mayor que 0):");
    n=teclado.nextInt();
} while (n<=0);
int[] vectorA=new int[n];
int[] vectorB=new int[n];
for (int i=0;i<n;i++){
    System.out.println("Vector A - digite el valor de la posicion "+i+":");
    vectorA[i]=teclado.nextInt();
}
for (int i=0;i<n;i++){
    System.out.println("Vector B - digite el valor de la posicion "+i+":");
    vectorB[i]=teclado.nextInt();
}
int iguales=0;
for (int i=0;i<n;i++){
    for (int j=0;j<n;j++){
        if (vectorA[i]==vectorB[j]){
            iguales++;
        }
    }
}
System.out.println("Vector A:");
for (int i=0;i<n;i++){
    System.out.print("["+vectorA[i]+"]");
    if (i<n-1){
        System.out.print("-");
    }
}
System.out.println();
System.out.println("Vector B:");
for (int i=0;i<n;i++){
    System.out.print("["+vectorB[i]+"]");
    if (i<n-1){
        System.out.print("-");
    }
}
System.out.println();
System.out.println("Cantidad de numeros iguales entre los vectores: "+iguales);

}

}
