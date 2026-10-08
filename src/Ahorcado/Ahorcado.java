package Ahorcado;
import java.util.Scanner;
public class Ahorcado {

public static void main(String[] args){
    String[] palabras={"java","programa","computadora","algoritmo","vector"};
    String palabra=palabras[(int)(Math.random()*palabras.length)];
    char[] adivinado=new char[palabra.length()];
    for (int i=0;i<adivinado.length;i++){
        adivinado[i]='_';
    }
    int intentosMax=6;
    int errores=0;
    Scanner teclado=new Scanner(System.in);
System.out.println("*** JUEGO DEL AHORCADO ***");
do {
    System.out.println();
    System.out.println(new String(adivinado).replace("", " ").trim());
    System.out.println("Errores: "+errores+" de "+intentosMax);
    System.out.println("Digite una letra:");
    char letra=teclado.next().toLowerCase().charAt(0);
    boolean acierto=false;
    for (int i=0;i<palabra.length();i++){
        if (palabra.charAt(i)==letra && adivinado[i]=='_'){
            adivinado[i]=letra;
            acierto=true;
        }
    }
    if (!acierto){
        errores++;
        System.out.println("La letra '"+letra+"' no esta en la palabra.");
    }
} while (errores<intentosMax && new String(adivinado).indexOf('_')!=-1);

if (new String(adivinado).indexOf('_')==-1){
    System.out.println("\nGanaste! La palabra era: "+palabra);
} else {
    System.out.println("\nPerdiste. La palabra era: "+palabra);
}

}

}
