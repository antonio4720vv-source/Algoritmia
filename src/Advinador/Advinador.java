package Advinador;
import java.util.ArrayList;
import java.util.Scanner;
public class Advinador {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
ArrayList<int[]> candidatos=new ArrayList<>();
for (int a=0; a<10; a++){
    for (int b=0; b<10; b++){
        for (int c=0; c<10; c++){
            for (int d=0; d<10; d++){
                int[] n={a,b,c,d};
                if (distintos(n)) candidatos.add(n);
            }
        }
    }
}
System.out.println("Piense en un número de 4 cifras distintas. Yo lo voy a adivinar.");
System.out.println("Responda con las fijas (dígito y posición correctos) y las picas (dígito correcto en otra posición).");
int intentos=0;
while (!candidatos.isEmpty()){
    int[] propuesta=candidatos.get(0);
    intentos++;
    System.out.println("Intento "+intentos+": ¿su número es "+texto(propuesta)+"?");
    System.out.println("Digite las fijas:");
    int fijas=teclado.nextInt();
    System.out.println("Digite las picas:");
    int picas=teclado.nextInt();
    if (fijas==4){
        System.out.println("¡Lo adiviné! Su número es "+texto(propuesta)+" (intentos: "+intentos+").");
        return;
    }
    ArrayList<int[]> nuevos=new ArrayList<>();
    for (int[] c : candidatos){
        if (fijasEntre(propuesta,c)==fijas && picasEntre(propuesta,c)==picas) nuevos.add(c);
    }
    candidatos=nuevos;
}
System.out.println("Ningún número cumple con sus respuestas. Revise lo digitado.");

}

static boolean distintos(int[] n){
    for (int i=0; i<n.length; i++){
        for (int j=0; j<i; j++){
            if (n[i]==n[j]) return false;
        }
    }
    return true;
}

static int fijasEntre(int[] intento, int[] secreto){
    int fijas=0;
    for (int i=0; i<4; i++){
        if (intento[i]==secreto[i]) fijas++;
    }
    return fijas;
}

static int picasEntre(int[] intento, int[] secreto){
    int picas=0;
    for (int i=0; i<4; i++){
        for (int j=0; j<4; j++){
            if (i!=j && intento[i]==secreto[j]) picas++;
        }
    }
    return picas;
}

static String texto(int[] n){
    return ""+n[0]+n[1]+n[2]+n[3];
}

}
