package Advinador;
import java.util.ArrayList;
import java.util.Scanner;
public class Advinador {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
    final int oportunidades=3;
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
System.out.println("Piense en un número de 4 cifras distintas. Yo lo voy a adivinar en "+oportunidades+" oportunidades.");
System.out.println("Responda con las fijas (dígito y posición correctos) y las picas (dígito correcto en otra posición).");
int intentos=0;
while (intentos<oportunidades && !candidatos.isEmpty()){
    int[] propuesta=mejorPropuesta(candidatos);
    intentos++;
    System.out.println("Oportunidad "+intentos+" de "+oportunidades+": ¿su número es "+texto(propuesta)+"?");
    int fijas;
    int picas;
    do {
        System.out.println("Digite las fijas:");
        fijas=teclado.nextInt();
        System.out.println("Digite las picas:");
        picas=teclado.nextInt();
    } while (fijas<0 || picas<0 || fijas+picas>4);
    if (fijas==4){
        System.out.println("¡Lo adiviné! Su número es "+texto(propuesta)+" (intentos: "+intentos+").");
        return;
    }
    ArrayList<int[]> nuevos=new ArrayList<>();
    for (int[] c : candidatos){
        if (fijasEntre(propuesta,c)==fijas && picasEntre(propuesta,c)==picas) nuevos.add(c);
    }
    if (nuevos.isEmpty()){
        System.out.println("Sus respuestas no coinciden con ningún número. Revise lo digitado.");
        return;
    }
    candidatos=nuevos;
}
System.out.println("No lo adiviné en "+oportunidades+" oportunidades.");

}

static int[] mejorPropuesta(ArrayList<int[]> candidatos){
    int[] mejor=candidatos.get(0);
    int mejorPeor=Integer.MAX_VALUE;
    for (int[] g : candidatos){
        int[] cuenta=new int[25];
        for (int[] c : candidatos){
            cuenta[fijasEntre(g,c)*5+picasEntre(g,c)]++;
        }
        int peor=0;
        for (int x : cuenta){
            if (x>peor) peor=x;
        }
        if (peor<mejorPeor){
            mejorPeor=peor;
            mejor=g;
        }
    }
    return mejor;
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
