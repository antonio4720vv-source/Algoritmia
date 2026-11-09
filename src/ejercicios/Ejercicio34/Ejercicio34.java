package ejercicios.Ejercicio34;
public class Ejercicio34 {

public static void main(String[] args){
System.out.println("Numeros primos entre 1 y 100:");
int numero;
int i;
int divisores;
int cantidad=0;
for (numero=1; numero<=100; numero++){
    // Contar los divisores de cada numero
    divisores=0;
    for (i=1; i<=numero; i++){
        if (numero%i==0){
            divisores=divisores+1;
        }
    }
    // Es primo si tiene exactamente 2 divisores (1 y el mismo)
    if (divisores==2){
        System.out.print(numero+" ");
        cantidad=cantidad+1;
    }
}
System.out.println();
System.out.println("En total hay "+cantidad+" numeros primos");

}

}
