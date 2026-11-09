package ejercicios.Ejercicio36;
import java.util.Scanner;
public class Ejercicio36 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Un numero es perfecto si la suma de sus divisores (sin contarlo a el) es igual al numero
// Ejemplo: 6 -> 1 + 2 + 3 = 6, entonces 6 es perfecto
int num1;
int num2;
do {
    System.out.println("Digite el primer numero entero positivo:");
    num1=teclado.nextInt();
} while (num1<1);
do {
    System.out.println("Digite el segundo numero entero positivo:");
    num2=teclado.nextInt();
} while (num2<1);
int i;
// Revisar el primer numero
int suma1=0;
for (i=1; i<num1; i++){
    if (num1%i==0){
        suma1=suma1+i;
    }
}
if (suma1==num1){
    System.out.println(num1+" es perfecto");
} else {
    System.out.println(num1+" no es perfecto");
}
// Revisar el segundo numero
int suma2=0;
for (i=1; i<num2; i++){
    if (num2%i==0){
        suma2=suma2+i;
    }
}
if (suma2==num2){
    System.out.println(num2+" es perfecto");
} else {
    System.out.println(num2+" no es perfecto");
}

}

}
