package ejercicios.Ejercicio40;
import java.util.Scanner;
public class Ejercicio40 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Dos numeros son amigos si la suma de los divisores de uno (sin contarlo a el)
// es igual al otro, y al reves. Ejemplo: 220 y 284
//   divisores de 220: 1+2+4+5+10+11+20+22+44+55+110 = 284
//   divisores de 284: 1+2+4+71+142 = 220
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
// Sumar los divisores del primer numero
int suma1=0;
for (i=1; i<num1; i++){
    if (num1%i==0){
        suma1=suma1+i;
    }
}
// Sumar los divisores del segundo numero
int suma2=0;
for (i=1; i<num2; i++){
    if (num2%i==0){
        suma2=suma2+i;
    }
}
System.out.println("Suma de divisores de "+num1+": "+suma1);
System.out.println("Suma de divisores de "+num2+": "+suma2);
// Deben ser numeros diferentes
if (suma1==num2 && suma2==num1 && num1!=num2){
    System.out.println(num1+" y "+num2+" son numeros amigos");
} else {
    System.out.println(num1+" y "+num2+" no son numeros amigos");
}

}

}
