package ejercicios.Ejercicio22;
import java.util.Scanner;
public class Ejercicio22 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Se toma el año 2026: el 1 de enero de 2026 fue jueves y no es bisiesto
int[] diasMes={31,28,31,30,31,30,31,31,30,31,30,31};
String[] semana={"Jueves","Viernes","Sabado","Domingo","Lunes","Martes","Miercoles"};
int mes;
do {
    System.out.println("Digite el mes (1 a 12):");
    mes=teclado.nextInt();
} while (mes<1 || mes>12);
int dia;
do {
    System.out.println("Digite el dia (1 a "+diasMes[mes-1]+"):");
    dia=teclado.nextInt();
} while (dia<1 || dia>diasMes[mes-1]);
// Contar cuantos dias han pasado desde el 1 de enero
int diasPasados=0;
int i;
for (i=0; i<mes-1; i++){
    diasPasados=diasPasados+diasMes[i];
}
diasPasados=diasPasados+dia-1;
System.out.println("El "+dia+"/"+mes+"/2026 es "+semana[diasPasados%7]);

}

}
