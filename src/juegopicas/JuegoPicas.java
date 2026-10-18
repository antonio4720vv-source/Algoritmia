package juegopicas;
import java.util.Random;
import java.util.Scanner;
public class JuegoPicas {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
    Random azar=new Random();
int cifras;
do {
    System.out.println("¿De cuántas cifras es el número? (de 1 a 6):");
    cifras=teclado.nextInt();
} while (cifras<1 || cifras>6);
int oportunidades;
do {
    System.out.println("¿Cuántas oportunidades desea? (de 1 a 3):");
    oportunidades=teclado.nextInt();
} while (oportunidades<1 || oportunidades>3);
int[] secreto=new int[cifras];
for (int i=0; i<cifras; i++){
    int d;
    boolean repetido;
    do {
        d=azar.nextInt(10);
        repetido=false;
        for (int j=0; j<i; j++){
            if (secreto[j]==d) repetido=true;
        }
    } while (repetido);
    secreto[i]=d;
}
System.out.println("Juego de picas: adivine el número secreto de "+cifras+" cifras distintas.");
System.out.println("Fija = dígito correcto en la posición correcta. Pica = dígito correcto en otra posición.");
int intentos=0;
int fijas=0;
while (intentos<oportunidades && fijas<cifras){
    System.out.println("Oportunidad "+(intentos+1)+" de "+oportunidades+".");
    int[] intento=leerIntento(teclado,cifras);
    intentos++;
    fijas=0;
    int picas=0;
    for (int i=0; i<cifras; i++){
        if (intento[i]==secreto[i]) fijas++;
        for (int j=0; j<cifras; j++){
            if (i!=j && intento[i]==secreto[j]) picas++;
        }
    }
    System.out.println("Fijas: "+fijas+"  Picas: "+picas);
}
if (fijas==cifras){
    System.out.println("¡Felicidades! Adivinó el número en "+intentos+" intentos.");
} else {
    System.out.println("Se acabaron las oportunidades. Perdió.");
}
String numeroSecreto="";
for (int d : secreto) numeroSecreto+=d;
System.out.println("El número era "+numeroSecreto+".");

}

static int[] leerIntento(Scanner teclado, int cifras){
    while (true){
        System.out.println("Digite un número de "+cifras+" cifras distintas:");
        String texto=teclado.next();
        if (texto.length()!=cifras || !texto.matches("[0-9]+")){
            System.out.println("Debe digitar exactamente "+cifras+" dígitos.");
            continue;
        }
        int[] n=new int[cifras];
        boolean valido=true;
        for (int i=0; i<cifras; i++){
            n[i]=texto.charAt(i)-'0';
            for (int j=0; j<i; j++){
                if (n[j]==n[i]) valido=false;
            }
        }
        if (!valido){
            System.out.println("Los dígitos no pueden repetirse.");
            continue;
        }
        return n;
    }
}

}
