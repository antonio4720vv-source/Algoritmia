package ejercicios.Ejercicio23;
import java.util.Scanner;
public class Ejercicio23 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Se cuenta desde el 1 de enero del año 1, que fue lunes
int[] diasMes={31,28,31,30,31,30,31,31,30,31,30,31};
String[] semana={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
int anio;
do {
    System.out.println("Digite el año (mayor o igual a 1):");
    anio=teclado.nextInt();
} while (anio<1);
// Un año es bisiesto si es divisible por 4, excepto los divisibles por 100 que no lo sean por 400
boolean bisiesto=(anio%4==0 && anio%100!=0) || anio%400==0;
if (bisiesto){
    diasMes[1]=29;
}
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
// Contar los dias que han pasado desde el 1 de enero del año 1
long diasPasados=0;
int i;
for (i=1; i<anio; i++){
    if ((i%4==0 && i%100!=0) || i%400==0){
        diasPasados=diasPasados+366;
    } else {
        diasPasados=diasPasados+365;
    }
}
for (i=0; i<mes-1; i++){
    diasPasados=diasPasados+diasMes[i];
}
diasPasados=diasPasados+dia-1;
System.out.println("El "+dia+"/"+mes+"/"+anio+" es "+semana[(int)(diasPasados%7)]);

}

}
