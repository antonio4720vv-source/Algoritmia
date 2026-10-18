package Advinador;
import java.util.ArrayList;
import java.util.Scanner;
public class Advinador {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int cifras;
do {
    System.out.println("¿De cuántas cifras es el número? (de 1 a 5):");
    cifras=teclado.nextInt();
} while (cifras<1 || cifras>5);
int minimo=oportunidadesGarantizadas(cifras);
int oportunidades;
do {
    System.out.println("¿Cuántas oportunidades tengo? (de "+minimo+" a 10):");
    oportunidades=teclado.nextInt();
} while (oportunidades<minimo || oportunidades>10);
ArrayList<int[]> candidatos=new ArrayList<>();
generar(new int[cifras],0,candidatos);
System.out.println("Piense en un número de "+cifras+" cifras distintas. Yo lo voy a adivinar en "+oportunidades+" oportunidades.");
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
    } while (fijas<0 || picas<0 || fijas+picas>cifras);
    if (fijas==cifras){
        System.out.println("¡Lo adiviné! Su número es "+texto(propuesta)+" (oportunidades usadas: "+intentos+").");
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

static int oportunidadesGarantizadas(int cifras){
    int[] minimos={0,10,9,8,8,9};
    return minimos[cifras];
}

static void generar(int[] actual, int pos, ArrayList<int[]> res){
    if (pos==actual.length){
        res.add(actual.clone());
        return;
    }
    for (int d=0; d<10; d++){
        boolean usado=false;
        for (int j=0; j<pos; j++){
            if (actual[j]==d) usado=true;
        }
        if (!usado){
            actual[pos]=d;
            generar(actual,pos+1,res);
        }
    }
}

static int[] mejorPropuesta(ArrayList<int[]> candidatos){
    int[] mejor=candidatos.get(0);
    int mejorPeor=Integer.MAX_VALUE;
    int n=mejor.length;
    for (int[] g : candidatos){
        int[] cuenta=new int[(n+1)*(n+1)];
        for (int[] c : candidatos){
            cuenta[fijasEntre(g,c)*(n+1)+picasEntre(g,c)]++;
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

static int fijasEntre(int[] intento, int[] secreto){
    int fijas=0;
    for (int i=0; i<intento.length; i++){
        if (intento[i]==secreto[i]) fijas++;
    }
    return fijas;
}

static int picasEntre(int[] intento, int[] secreto){
    int picas=0;
    for (int i=0; i<intento.length; i++){
        for (int j=0; j<secreto.length; j++){
            if (i!=j && intento[i]==secreto[j]) picas++;
        }
    }
    return picas;
}

static String texto(int[] n){
    String s="";
    for (int d : n) s+=d;
    return s;
}

}
