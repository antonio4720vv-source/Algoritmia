package ejercicios.Ejercicio31;
import java.util.Scanner;
public class Ejercicio31 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int base;
int exponente;
System.out.println("Digite la base (numero entero):");
base=teclado.nextInt();
do {
    System.out.println("Digite el exponente (entero mayor o igual a 0):");
    exponente=teclado.nextInt();
} while (exponente<0);
// Se empieza en 1 porque todo numero elevado a 0 es 1
long resultado=1;
int i;
for (i=1; i<=exponente; i++){
    resultado=resultado*base;
}
System.out.println(base+" ^ "+exponente+" = "+resultado);

}

}
