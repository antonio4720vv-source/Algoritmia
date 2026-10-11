package Ejercicio8;
import java.util.Scanner;
public class Ejercicio8 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
long dias;
do {
    System.out.println("Digite el numero de dias (mayor o igual a 0):");
    dias=teclado.nextLong();
} while (dias<0);
long segundos=dias*24*60*60;
System.out.println(dias+" dias tienen "+segundos+" segundos");

}

}
