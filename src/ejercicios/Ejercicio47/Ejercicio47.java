package ejercicios.Ejercicio47;

public class Ejercicio47 {

    public static void main(String[] args) {
        int horas=0, minutos=0, segundos=0;
        for (horas=0; horas<24; horas++) {
            for (minutos=0; minutos<60; minutos++) {
                for (segundos=0; segundos<60; segundos++) {
                    System.out.println(horas + ":" + minutos + ":" + segundos);
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e) {
                    }
                }
            }
        }

    }
}
