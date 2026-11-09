package ejercicios.Ejercicio35;
import java.util.Scanner;
public class Ejercicio35 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// El factorial de n es: n! = 1 x 2 x 3 x ... x n   (ej: 5! = 120)
int numero;
do {
    System.out.println("Digite un numero entero positivo (0 a 20):");
    numero=teclado.nextInt();
} while (numero<0 || numero>20);
// Se empieza en 1 porque 0! = 1
long factorial=1;
int i;
for (i=1; i<=numero; i++){
    factorial=factorial*i;
}
System.out.println("El factorial de "+numero+" es: "+factorial);

}

}
