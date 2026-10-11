package Ejercicio15;
import java.util.Scanner;
public class Ejercicio15 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
double sueldo;
do {
    System.out.println("Digite el sueldo del empleado (mayor que 0):");
    sueldo=teclado.nextDouble();
} while (sueldo<=0);
double nuevoSueldo;
if (sueldo<1000){
    nuevoSueldo=sueldo+sueldo*0.10;
} else {
    nuevoSueldo=sueldo+sueldo*0.05;
}
System.out.println("Salario anterior: "+sueldo);
System.out.println("Salario nuevo: "+nuevoSueldo);

}

}
