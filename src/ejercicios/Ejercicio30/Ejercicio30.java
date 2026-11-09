package ejercicios.Ejercicio30;
import java.util.Scanner;
public class Ejercicio30 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int num1;
int num2;
System.out.println("Digite el primer numero entero:");
num1=teclado.nextInt();
System.out.println("Digite el segundo numero entero:");
num2=teclado.nextInt();
// Las veces que se suma num1 debe ser positivo
int veces=num2;
if (num2<0){
    veces=-num2;
}
int resultado=0;
int i;
for (i=1; i<=veces; i++){
    resultado=resultado+num1;
}
// Si num2 era negativo, el resultado cambia de signo
if (num2<0){
    resultado=-resultado;
}
System.out.println(num1+" x "+num2+" = "+resultado);

}

}
