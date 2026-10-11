package Ejercicio18;
import java.util.Scanner;
public class Ejercicio18 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double parcial;
do {
    System.out.println("Digite la nota del parcial (0.0 a 5.0) - vale 30%:");
    parcial=teclado.nextDouble();
} while (parcial<0 || parcial>5);
double proyecto;
do {
    System.out.println("Digite la nota del proyecto (0.0 a 5.0) - vale 30%:");
    proyecto=teclado.nextDouble();
} while (proyecto<0 || proyecto>5);
double examen;
do {
    System.out.println("Digite la nota del examen final (0.0 a 5.0) - vale 40%:");
    examen=teclado.nextDouble();
} while (examen<0 || examen>5);
double definitiva=(parcial*30+proyecto*30+examen*40)/100;
System.out.println("Nota definitiva: "+definitiva);
if (definitiva>=3.0){
    System.out.println("El estudiante aprueba");
} else {
    System.out.println("El estudiante reprueba");
}

}

}
