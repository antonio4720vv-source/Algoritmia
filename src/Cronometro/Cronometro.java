package Cronometro;
import java.util.Scanner;
public class Cronometro {
public static void main(String[] args){
    int Hora=0,Minuto=0,Segundo=0;
    Scanner scanner=new Scanner(System.in);
System.out.println("Cronometro");
    System.out.println("presiona enter para iniciar:");
scanner.nextLine();
while (true){
    System.out.printf("%02d:%02d:%02d\n", Hora,Minuto,Segundo);
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e){
        System.out.println("Error####");
    }
    Segundo++;
    if (Segundo==60){
        Segundo=0;
        Minuto++;
    }
    if (Minuto==60);
        Minuto=0;
        Hora++;

}
}
}
