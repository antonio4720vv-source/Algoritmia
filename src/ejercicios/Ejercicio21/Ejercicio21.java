package ejercicios.Ejercicio21;
import java.util.Scanner;
public class Ejercicio21 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int edad;
// Validar que sea una edad valida (no negativa)
do {
    System.out.println("Digite la edad de la persona:");
    edad=teclado.nextInt();
} while (edad<0);
if (edad<4){
    System.out.println("Bebe");
} else if (edad<12){
    System.out.println("Nino");
} else if (edad<18){
    System.out.println("Joven");
} else if (edad<50){
    System.out.println("Adulto");
} else if (edad<120){
    System.out.println("Adulto mayor");
} else {
    System.out.println("Muerto");
}

}

}
