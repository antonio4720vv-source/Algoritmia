# Taller: total de una matriz n x n

Programa en Java que declara una matriz de 5 x 5, la llena con valores enteros y calcula los acumulados pedidos en el taller.

Archivo: `EjercicioMatriz.java`

## Paso 1. Declarar la matriz de n x n

Se supone que `n = 5`:

```java
int n = 5;
int[][] matriz = new int[n][n];
```

`int[][]` es una matriz (un vector de vectores). Cada posición se identifica con dos índices: `matriz[i][j]`, donde `i` es la fila y `j` es la columna. Las posiciones van de `0` a `n-1`.

## Paso 2. Llenar la matriz

```java
for (int i = 0; i < n; i++){
    for (int j = 0; j < n; j++){
        System.out.println("Digite el valor de la posición " + i + "," + j + ":");
        matriz[i][j] = teclado.nextInt();
    }
}
```

El ciclo de afuera recorre las filas (`i`) y el de adentro las columnas (`j`). Se puede digitar cualquier valor entero.

Con los valores del taller:

| | 0 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|
| **0** | 81 | 47 | 67 | 76 | 24 |
| **1** | 20 | 1 | 62 | 30 | 58 |
| **2** | 59 | 80 | 94 | 1 | 91 |
| **3** | 23 | 17 | 63 | 25 | 29 |
| **4** | 86 | 70 | 16 | 63 | 35 |

## Paso 3. Operaciones

Cada operación recorre toda la matriz con dos ciclos y suma solo las posiciones que cumplen una condición sobre `i` y `j`.

| Operación | Condición de la posición (i, j) | Resultado |
|---|---|---|
| 3.1 Diagonal principal | `i == j` | 236 |
| 3.2 Diagonal secundaria | `i + j == n-1` | 251 |
| 3.3 Triangular superior (diagonal principal) | `i < j` | 485 |
| 3.4 Triangular inferior (diagonal principal) | `i > j` | 497 |
| 3.5 Triangular superior (diagonal secundaria) | `i + j < n-1` | 516 |
| 3.6 Triangular inferior (diagonal secundaria) | `i + j > n-1` | 451 |
| 3.7 Toda la matriz | sin condición | 1218 |

Ejemplo de la diagonal principal:

```java
static int sumaDiagonalPrincipal(int[][] matriz){
    int suma;
    int i;
    int j;
    suma = 0;
    for (i = 0; i < matriz.length; i++){
        for (j = 0; j < matriz.length; j++){
            if (i == j){
                suma = suma + matriz[i][j];
            }
        }
    }
    return suma;
}
```

Las variables (`suma`, `i`, `j`) se declaran al inicio del método, y después se les asigna el valor.

Por ejemplo, en la diagonal principal la posición `(0,0)` vale 81, `(1,1)` vale 1, `(2,2)` vale 94, `(3,3)` vale 25 y `(4,4)` vale 35. Su suma es 81 + 1 + 94 + 25 + 35 = 236.

**Acumulado por fila (3.8):** se reinicia el acumulado en cada fila. Un ciclo para la fila `i` y dentro otro para recorrer sus columnas `j`.

```java
acumulado = 0;
for (j = 0; j < n; j++){
    acumulado = acumulado + matriz[i][j];
}
resultado[i] = acumulado;
```

Resultados: 295, 171, 325, 157, 270.

**Acumulado por columna (3.9):** igual que las filas, pero se recorre `i` para cada columna `j`.

Resultados: 269, 215, 302, 195, 237.

## Paso 4. Imprimir

El programa imprime la matriz completa con `imprimirMatriz` y después cada uno de los acumulados con su nombre.

Salida esperada con los valores del taller:

```
Matriz:
[ 81	47	67	76	24 ]
[ 20	1	62	30	58 ]
[ 59	80	94	1	91 ]
[ 23	17	63	25	29 ]
[ 86	70	16	63	35 ]
3.1 Diagonal principal (i == j): 236
3.2 Diagonal secundaria (i + j == n-1): 251
3.3 Triangular superior (diagonal principal, i < j): 485
3.4 Triangular inferior (diagonal principal, i > j): 497
3.5 Triangular superior (diagonal secundaria, i + j < n-1): 516
3.6 Triangular inferior (diagonal secundaria, i + j > n-1): 451
3.7 Acumulado de toda la matriz: 1218
3.8 Acumulado de cada fila: 295 171 325 157 270
3.9 Acumulado de cada columna: 269 215 302 195 237
```

## Cómo ejecutar

```
javac src/EjercicioMatriz/EjercicioMatriz.java
java EjercicioMatriz.EjercicioMatriz
```

Digite los 25 valores por filas, uno por uno.
