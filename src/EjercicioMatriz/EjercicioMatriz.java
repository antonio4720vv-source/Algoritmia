package EjercicioMatriz;
import java.util.Scanner;
public class EjercicioMatriz {

public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
int n=5;
int[][] matriz=new int[n][n];
for (int i=0; i<n; i++){
    for (int j=0; j<n; j++){
        System.out.println("Digite el valor de la posición "+i+","+j+":");
        matriz[i][j]=teclado.nextInt();
    }
}
System.out.println("Matriz:");
imprimirMatriz(matriz);
System.out.println("3.1 Diagonal principal (i == j): "+sumaDiagonalPrincipal(matriz));
System.out.println("3.2 Diagonal secundaria (i + j == n-1): "+sumaDiagonalSecundaria(matriz));
System.out.println("3.3 Triangular superior (diagonal principal, i < j): "+sumaTriangularSuperior(matriz));
System.out.println("3.4 Triangular inferior (diagonal principal, i > j): "+sumaTriangularInferior(matriz));
System.out.println("3.5 Triangular superior (diagonal secundaria, i + j < n-1): "+sumaSuperiorSecundaria(matriz));
System.out.println("3.6 Triangular inferior (diagonal secundaria, i + j > n-1): "+sumaInferiorSecundaria(matriz));
System.out.println("3.7 Acumulado de toda la matriz: "+sumaTotal(matriz));
int[] filas=sumaFilas(matriz);
System.out.print("3.8 Acumulado de cada fila: ");
for (int i=0; i<n; i++){
    System.out.print(filas[i]+" ");
}
System.out.println();
int[] columnas=sumaColumnas(matriz);
System.out.print("3.9 Acumulado de cada columna: ");
for (int j=0; j<n; j++){
    System.out.print(columnas[j]+" ");
}
System.out.println();

}

static void imprimirMatriz(int[][] matriz){
    for (int i=0; i<matriz.length; i++){
        for (int j=0; j<matriz.length; j++){
            System.out.print(matriz[i][j]+"\t");
        }
        System.out.println();
    }
}

static int sumaDiagonalPrincipal(int[][] matriz){
    int suma=0;
    for (int i=0; i<matriz.length; i++){
        for (int j=0; j<matriz.length; j++){
            if (i==j) suma+=matriz[i][j];
        }
    }
    return suma;
}

static int sumaDiagonalSecundaria(int[][] matriz){
    int suma=0;
    for (int i=0; i<matriz.length; i++){
        for (int j=0; j<matriz.length; j++){
            if (i+j==matriz.length-1) suma+=matriz[i][j];
        }
    }
    return suma;
}

static int sumaTriangularSuperior(int[][] matriz){
    int suma=0;
    for (int i=0; i<matriz.length; i++){
        for (int j=0; j<matriz.length; j++){
            if (i<j) suma+=matriz[i][j];
        }
    }
    return suma;
}

static int sumaTriangularInferior(int[][] matriz){
    int suma=0;
    for (int i=0; i<matriz.length; i++){
        for (int j=0; j<matriz.length; j++){
            if (i>j) suma+=matriz[i][j];
        }
    }
    return suma;
}

static int sumaSuperiorSecundaria(int[][] matriz){
    int suma=0;
    for (int i=0; i<matriz.length; i++){
        for (int j=0; j<matriz.length; j++){
            if (i+j<matriz.length-1) suma+=matriz[i][j];
        }
    }
    return suma;
}

static int sumaInferiorSecundaria(int[][] matriz){
    int suma=0;
    for (int i=0; i<matriz.length; i++){
        for (int j=0; j<matriz.length; j++){
            if (i+j>matriz.length-1) suma+=matriz[i][j];
        }
    }
    return suma;
}

static int sumaTotal(int[][] matriz){
    int suma=0;
    for (int i=0; i<matriz.length; i++){
        for (int j=0; j<matriz.length; j++){
            suma+=matriz[i][j];
        }
    }
    return suma;
}

static int[] sumaFilas(int[][] matriz){
    int[] resultado=new int[matriz.length];
    for (int i=0; i<matriz.length; i++){
        int acumulado=0;
        for (int j=0; j<matriz.length; j++){
            acumulado+=matriz[i][j];
        }
        resultado[i]=acumulado;
    }
    return resultado;
}

static int[] sumaColumnas(int[][] matriz){
    int[] resultado=new int[matriz.length];
    for (int j=0; j<matriz.length; j++){
        int acumulado=0;
        for (int i=0; i<matriz.length; i++){
            acumulado+=matriz[i][j];
        }
        resultado[j]=acumulado;
    }
    return resultado;
}

}
