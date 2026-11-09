package ejercicios.Ejercicio28;
import java.util.Scanner;
public class Ejercicio28 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n;
do {
    System.out.println("Digite cuantas notas tiene el estudiante:");
    n=teclado.nextInt();
} while (n<1);
double nota;
double suma=0;
int i;
for (i=1; i<=n; i++){
    do {
        System.out.println("Digite la nota "+i+" (0.0 a 5.0):");
        nota=teclado.nextDouble();
    } while (nota<0 || nota>5);
    suma=suma+nota;
}
double promedio=suma/n;
System.out.println("El promedio del estudiante es: "+promedio);

}

}
