package ejercicios.Ejercicio37;
import java.util.Scanner;
public class Ejercicio37 {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
// Matriz de 5 alumnos (filas) x 6 materias (columnas)
int alumnos=5;
int materias=6;
double[][] notas=new double[alumnos][materias];
int i;
int j;
// Pedir las notas de cada alumno
for (i=0; i<alumnos; i++){
    System.out.println("--- Alumno "+(i+1)+" ---");
    for (j=0; j<materias; j++){
        do {
            System.out.println("Digite la nota de la materia "+(j+1)+" (0.0 a 5.0):");
            notas[i][j]=teclado.nextDouble();
        } while (notas[i][j]<0 || notas[i][j]>5);
    }
}
// Calcular el promedio de cada alumno y el promedio del curso
double suma;
double promedio;
double sumaCurso=0;
System.out.println();
for (i=0; i<alumnos; i++){
    suma=0;
    for (j=0; j<materias; j++){
        suma=suma+notas[i][j];
    }
    promedio=suma/materias;
    System.out.println("Promedio del alumno "+(i+1)+": "+promedio);
    sumaCurso=sumaCurso+promedio;
}
double promedioCurso=sumaCurso/alumnos;
System.out.println("Promedio total del curso: "+promedioCurso);

}

}
