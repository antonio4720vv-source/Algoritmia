package ejercicios.Ejercicio38;
import java.util.Scanner;
public class Ejercicio38 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Sumatoria de i elevado a la i, desde i=1 hasta n
// Ejemplo n=3: 1^1 + 2^2 + 3^3 = 1 + 4 + 27 = 32
int n;
do {
    System.out.println("Digite un numero entero (1 a 15):");
    n=teclado.nextInt();
} while (n<1 || n>15);
long sumatoria=0;
long potencia;
int i;
int j;
for (i=1; i<=n; i++){
    // Calcular i^i con multiplicaciones sucesivas
    potencia=1;
    for (j=1; j<=i; j++){
        potencia=potencia*i;
    }
    System.out.println(i+"^"+i+" = "+potencia);
    sumatoria=sumatoria+potencia;
}
System.out.println("El resultado de la sumatoria es: "+sumatoria);

}

}
