package EjercicioMatriz;
import java.util.Scanner;
public class EjercicioMatriz {

static final String RESET = "\u001B[0m";

public static void main(String[] args){
    // Variables del programa principal, todas declaradas al inicio
    Scanner teclado = new Scanner(System.in);
    int n = 5;
    int[][] matriz = new int[n][n];
    int i = 0;
    int j = 0;
    int[] filas = new int[n];
    int[] columnas = new int[n];

    // Paso 2: llenar la matriz, fila por fila
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            System.out.println("Digite el valor de la posición " + i + "," + j + ":");
            matriz[i][j] = teclado.nextInt();
        }
    }

    // Paso 4: imprimir la matriz
    System.out.println("Matriz:");
    imprimirMatriz(matriz);

    // Paso 3: cada operación se imprime con su color, como en el taller
    imprimirOperacion(matriz, 1, "3.1 Diagonal principal (i == j)", sumaDiagonalPrincipal(matriz));
    imprimirOperacion(matriz, 2, "3.2 Diagonal secundaria (i + j == n-1)", sumaDiagonalSecundaria(matriz));
    imprimirOperacion(matriz, 3, "3.3 Triangular superior (diagonal principal, i < j)", sumaTriangularSuperior(matriz));
    imprimirOperacion(matriz, 4, "3.4 Triangular inferior (diagonal principal, i > j)", sumaTriangularInferior(matriz));
    imprimirOperacion(matriz, 5, "3.5 Triangular superior (diagonal secundaria, i + j < n-1)", sumaSuperiorSecundaria(matriz));
    imprimirOperacion(matriz, 6, "3.6 Triangular inferior (diagonal secundaria, i + j > n-1)", sumaInferiorSecundaria(matriz));
    imprimirOperacion(matriz, 7, "3.7 Acumulado de toda la matriz", sumaTotal(matriz));

    filas = sumaFilas(matriz);
    System.out.println();
    System.out.println("3.8 Acumulado de cada fila:");
    imprimirFilas(matriz, filas);

    columnas = sumaColumnas(matriz);
    System.out.println();
    System.out.println("3.9 Acumulado de cada columna:");
    imprimirColumnas(matriz, columnas);
}

static String colorOperacion(int tipo){
    String color = "";
    if (tipo == 1){
        color = "\u001B[48;5;226m\u001B[30m";
    } else if (tipo == 2){
        color = "\u001B[48;5;34m\u001B[97m";
    } else if (tipo == 3){
        color = "\u001B[48;5;27m\u001B[97m";
    } else if (tipo == 4){
        color = "\u001B[48;5;208m\u001B[30m";
    } else if (tipo == 5){
        color = "\u001B[48;5;245m\u001B[30m";
    } else if (tipo == 6){
        color = "\u001B[48;5;92m\u001B[97m";
    } else if (tipo == 7){
        color = "\u001B[48;5;28m\u001B[97m";
    }
    return color;
}

static boolean perteneceOperacion(int tipo, int i, int j, int n){
    boolean pertenece = false;
    if (tipo == 1){
        pertenece = (i == j);
    } else if (tipo == 2){
        pertenece = (i + j == n - 1);
    } else if (tipo == 3){
        pertenece = (i < j);
    } else if (tipo == 4){
        pertenece = (i > j);
    } else if (tipo == 5){
        pertenece = (i + j < n - 1);
    } else if (tipo == 6){
        pertenece = (i + j > n - 1);
    } else if (tipo == 7){
        pertenece = true;
    }
    return pertenece;
}

static void imprimirOperacion(int[][] matriz, int tipo, String nombre, int resultado){
    int i = 0;
    int j = 0;
    int n = matriz.length;
    int ancho = anchoMaximo(matriz);
    System.out.println();
    System.out.println(nombre + ":");
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (perteneceOperacion(tipo, i, j, n)){
                System.out.print(colorOperacion(tipo) + celda(matriz[i][j], ancho) + RESET + " ");
            } else {
                System.out.print(celda(matriz[i][j], ancho) + " ");
            }
        }
        System.out.println();
    }
    System.out.println("Resultado: " + colorOperacion(tipo) + " " + resultado + " " + RESET);
}

static void imprimirFilas(int[][] matriz, int[] filas){
    int i = 0;
    int j = 0;
    int ancho = anchoMaximo(matriz);
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            System.out.print(colorOperacion(i + 1) + celda(matriz[i][j], ancho) + RESET + " ");
        }
        System.out.println("  Resultado: " + colorOperacion(i + 1) + " " + filas[i] + " " + RESET);
    }
}

static void imprimirColumnas(int[][] matriz, int[] columnas){
    int i = 0;
    int j = 0;
    int ancho = anchoMaximo(matriz);
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            System.out.print(colorOperacion(j + 1) + celda(matriz[i][j], ancho) + RESET + " ");
        }
        System.out.println();
    }
    System.out.print("Resultado:  ");
    for (j = 0; j < matriz.length; j++){
        System.out.print(colorOperacion(j + 1) + celda(columnas[j], ancho) + RESET + " ");
    }
    System.out.println();
}

static void imprimirMatriz(int[][] matriz){
    int i = 0;
    int j = 0;
    int ancho = anchoMaximo(matriz);
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            System.out.print(celda(matriz[i][j], ancho) + " ");
        }
        System.out.println();
    }
}

static String celda(int valor, int ancho){
    String texto = String.valueOf(valor);
    int izquierda = (ancho - texto.length()) / 2;
    int derecha = ancho - texto.length() - izquierda;
    return "[" + espacios(izquierda) + texto + espacios(derecha) + "]";
}

static int anchoMaximo(int[][] matriz){
    int ancho = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (String.valueOf(matriz[i][j]).length() > ancho){
                ancho = String.valueOf(matriz[i][j]).length();
            }
        }
    }
    return ancho;
}

static String espacios(int cantidad){
    String resultado = "";
    int k = 0;
    for (k = 0; k < cantidad; k++){
        resultado = resultado + " ";
    }
    return resultado;
}

static int sumaDiagonalPrincipal(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i == j){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

static int sumaDiagonalSecundaria(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i + j == matriz.length - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

static int sumaTriangularSuperior(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i < j){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

static int sumaTriangularInferior(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i > j){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

static int sumaSuperiorSecundaria(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i + j < matriz.length - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

static int sumaInferiorSecundaria(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i + j > matriz.length - 1){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}

static int sumaTotal(int[][] matriz){
    int suma = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            suma = suma + matriz[i][j];
        }
    }
    return suma;
}

static int[] sumaFilas(int[][] matriz){
    int[] resultado = new int[matriz.length];
    int acumulado = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < matriz.length; i++){
        acumulado = 0;
        for (j = 0; j < matriz.length; j++){
            acumulado = acumulado + matriz[i][j];
        }
        resultado[i] = acumulado;
    }
    return resultado;
}

static int[] sumaColumnas(int[][] matriz){
    int[] resultado = new int[matriz.length];
    int acumulado = 0;
    int i = 0;
    int j = 0;
    for (j = 0; j < matriz.length; j++){
        acumulado = 0;
        for (i = 0; i < matriz.length; i++){
            acumulado = acumulado + matriz[i][j];
        }
        resultado[j] = acumulado;
    }
    return resultado;
}

}
