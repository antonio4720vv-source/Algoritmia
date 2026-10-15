package juegopicas;
import java.util.Random;
import java.util.Scanner;
public class JuegoPicas {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
    Random azar=new Random();
int[] secreto=new int[4];
for (int i=0; i<4; i++){
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
System.out.println("Juego de picas: adivine el número secreto de 4 cifras distintas.");
System.out.println("Fija = dígito correcto en la posición correcta. Pica = dígito correcto en otra posición.");
int intentos=0;
int fijas;
do {
    int[] intento=leerIntento(teclado);
    intentos++;
    fijas=0;
    int picas=0;
    for (int i=0; i<4; i++){
        if (intento[i]==secreto[i]) fijas++;
        for (int j=0; j<4; j++){
            if (i!=j && intento[i]==secreto[j]) picas++;
        }
    }
    System.out.println("Fijas: "+fijas+"  Picas: "+picas);
} while (fijas<4);
System.out.println("¡Felicidades! Adivinó el número en "+intentos+" intentos.");

}

static int[] leerIntento(Scanner teclado){
    while (true){
        System.out.println("Digite un número de 4 cifras distintas:");
        String texto=teclado.next();
        if (texto.length()!=4 || !texto.matches("[0-9]{4}")){
            System.out.println("Debe digitar exactamente 4 dígitos.");
            continue;
        }
        int[] n=new int[4];
        boolean valido=true;
        for (int i=0; i<4; i++){
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
