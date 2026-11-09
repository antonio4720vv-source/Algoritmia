package ejercicios.Ejercicio20;
import java.util.Scanner;
public class Ejercicio20 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double numero;
System.out.println("Digite un numero:");
numero=teclado.nextDouble();
if (numero>0){
    System.out.println("+ Positivo");
} else {
    if (numero<0){
        System.out.println("- Negativo");
    } else {
        System.out.println("+- Neutro");
    }
}

}

}
