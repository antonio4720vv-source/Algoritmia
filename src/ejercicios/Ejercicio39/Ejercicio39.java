package ejercicios.Ejercicio39;
import java.util.Scanner;
public class Ejercicio39 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
do {
    System.out.println("Digite cuantos numeros va a ingresar:");
    n=teclado.nextInt();
} while (n<1);
int numero;
int pares=0;
int impares=0;
int i;
for (i=1; i<=n; i++){
    System.out.println("Digite el numero "+i+":");
    numero=teclado.nextInt();
    // Un numero es par si al dividirlo entre 2 el residuo es 0
    if (numero%2==0){
        pares=pares+1;
    } else {
        impares=impares+1;
    }
}
System.out.println("Cantidad de numeros pares: "+pares);
System.out.println("Cantidad de numeros impares: "+impares);

}

}
