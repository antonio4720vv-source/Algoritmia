package ejercicios.Ejercicio44;
import java.util.Scanner;
public class Ejercicio44 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Dividir es contar cuantas veces se puede restar el divisor
// Ejemplo 17 / 5: 17-5=12, 12-5=7, 7-5=2 -> se resto 3 veces y sobran 2
int dividendo;
int divisor;
System.out.println("Digite el dividendo (numero entero):");
dividendo=teclado.nextInt();
do {
    System.out.println("Digite el divisor (numero entero diferente de 0):");
    divisor=teclado.nextInt();
} while (divisor==0);
// Se trabaja con los numeros en positivo
int a=dividendo;
if (a<0){
    a=-a;
}
int b=divisor;
if (b<0){
    b=-b;
}
int cociente=0;
while (a>=b){
    a=a-b;
    cociente=cociente+1;
}
int residuo=a;
// Si solo uno de los dos era negativo, el cociente es negativo
if ((dividendo<0 && divisor>0) || (dividendo>0 && divisor<0)){
    cociente=-cociente;
}
// El residuo lleva el signo del dividendo
if (dividendo<0){
    residuo=-residuo;
}
System.out.println(dividendo+" / "+divisor+" = "+cociente);
System.out.println("Residuo: "+residuo);

}

}
