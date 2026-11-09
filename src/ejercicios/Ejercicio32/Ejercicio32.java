package ejercicios.Ejercicio32;
import java.util.Scanner;
public class Ejercicio32 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int numero;
do {
    System.out.println("Digite un numero entero positivo:");
    numero=teclado.nextInt();
} while (numero<1);
// Contar cuantos divisores tiene el numero
int divisores=0;
int i;
for (i=1; i<=numero; i++){
    if (numero%i==0){
        divisores=divisores+1;
    }
}
// Un numero es primo si solo se divide por 1 y por si mismo (2 divisores)
if (divisores==2){
    System.out.println(numero+" es primo");
} else {
    System.out.println(numero+" no es primo");
}

}

}
