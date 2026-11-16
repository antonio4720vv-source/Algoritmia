# Guía para el parcial — Soldier Final Game

Archivo del juego: `JuegoActualizadoBaseParcial.java` (está en esta misma carpeta).

Todo lo de esta guía va **dentro del `main`, en la misma clase**, sin métodos ni clases nuevas.

> **OJO con los números de línea:** son los del archivo original, sin tocar. Apenas agregas una línea, todo lo de abajo se corre.
> Dos trucos: haz los cambios **de abajo hacia arriba**, o busca el texto con **Ctrl + F** en vez de fiarte del número.

---

## PARTE 1 — Mapa del código (qué hace cada pedazo)

| Líneas | Qué hace |
|---|---|
| 9-30 | **Variables**: cantidades de objetos, vida, balas, tamaño, contadores, posición del soldado, `ganador`, `movimientos` |
| 32 | Crea el `Scanner` para leer del teclado |
| 34-38 | Llena todo el tablero de ceros (vacío) |
| 40 | Pone al soldado (1) en la casilla (0,0) |
| 41 | Pone la salida (2) en la última casilla (9,9) |
| 43-51 | Genera los **rehenes** (3) al azar |
| 53-61 | Genera los **mercenarios** (4) al azar |
| 63-71 | Genera los **muros** (5) al azar |
| 73-81 | Genera las **recargas** (6) al azar |
| 83-91 | Genera los **botiquines** (7) al azar |
| 93-101 | Genera el **portal** (8) al azar |
| 103-111 | Genera las **minas** (9) al azar |
| 113-155 | **Imprime** el título, los datos (vida, balas…) y el tablero por primera vez |
| 157 | Empieza el ciclo del juego (`do {`) |
| 158-169 | Imprime el **menú** |
| 170 | Lee la opción y la pasa a mayúsculas |
| 171 | Empieza el `switch(opcion)` |
| 173-254 | `case "D"`: mover a la **derecha** |
| 256-337 | `case "A"`: mover a la **izquierda** |
| 339-420 | `case "S"`: mover **abajo** |
| 422-503 | `case "W"`: mover **arriba** |
| 505-529 | `case "DD"`: disparar a la derecha |
| 531-555 | `case "DA"`: disparar a la izquierda |
| 557-581 | `case "DS"`: disparar abajo |
| 583-607 | `case "DW"`: disparar arriba |
| 609-620 | `case "DM"`: desactivar minas alrededor |
| 622 | Cierra el `switch` |
| 624-630 | **Borra** todos los mercenarios del tablero |
| 632-640 | **Vuelve a poner** al azar los mercenarios vivos (así "se mueven") |
| 642-646 | Suma un movimiento; si llega a 30, game over |
| 648-690 | **Imprime** otra vez los datos y el tablero |
| 692 | Fin del ciclo: repite mientras no escribas `E` y `ganador` sea `false` |
| 694 | Cierra el `Scanner` |

### Los números del tablero

`0` vacío · `1` soldado · `2` salida · `3` rehén · `4` mercenario · `5` muro · `6` recarga · `7` botiquín · `8` portal · `9` mina · `10` muerto (X)

### Cómo funciona el generador al azar (líneas 43-51, igual en todos)

```java
for (generador = 1; generador <= rehenes; generador++) {
	fila=(int)(Math.random()*tamano);      // fila al azar de 0 a 9
	columna=(int)(Math.random()*tamano);   // columna al azar de 0 a 9
	if(tablero[fila][columna]!=0) {
		generador--;                       // casilla ocupada: repite el intento
	}else {
		tablero[fila][columna]=3;          // casilla libre: pone el objeto
	}
}
```

### Dentro de cada movimiento: qué línea es cada cosa

Los 4 movimientos son el mismo código. Solo cambia la casilla destino:

| | D (derecha) | A (izquierda) | S (abajo) | W (arriba) |
|---|---|---|---|---|
| **Casilla destino** | `[posXSoldado][posYSoldado + 1]` | `[posXSoldado][posYSoldado - 1]` | `[posXSoldado + 1][posYSoldado]` | `[posXSoldado - 1][posYSoldado]` |
| **Cómo avanza** | `posYSoldado++` | `posYSoldado--` | `posXSoldado++` | `posXSoldado--` |
| No salirse del tablero | 174 | 257 | 340 | 423 |
| Casilla vacía (0) | 175-178 | 258-261 | 341-344 | 424-427 |
| Rehén (3) | 180-184 | 263-267 | 346-350 | 429-433 |
| Mercenario (4) | 186-192 | 269-275 | 352-358 | 435-441 |
| Muro (5) | 194-195 | 277-278 | 360-361 | 443-444 |
| Recarga (6) | 197-201 | 280-284 | 363-367 | 446-450 |
| Botiquín (7) | 203-209 | 286-292 | 369-375 | 452-458 |
| Portal (8) | 211-221 | 294-304 | 377-387 | 460-470 |
| Mina (9) | 223-232 | 306-315 | 389-398 | 472-481 |
| Salida (2) | 234-243 | 317-326 | 400-409 | 483-492 |

**Recuerda:** `posXSoldado` es la **fila** (arriba/abajo) y `posYSoldado` es la **columna** (izquierda/derecha).

### Dentro de cada disparo

| | DD | DA | DS | DW |
|---|---|---|---|---|
| ¿Hay balas? / gasta una | 506-507 | 532-533 | 558-559 | 584-585 |
| `for` que recorre la bala | 508 | 534 | 560 | 586 |
| Le da a un rehén → game over | 509-513 | 535-539 | 561-565 | 587-591 |
| Le da a un mercenario | 515-518 | 541-544 | 567-570 | 593-596 |
| Le da a un muro → se detiene | 520-522 | 546-548 | 572-574 | 598-600 |
| Sin balas | 526-528 | 552-554 | 578-580 | 604-606 |
| **Casilla que revisa** | `[posXSoldado][j]` | `[posXSoldado][j]` | `[i][posYSoldado]` | `[i][posYSoldado]` |
| **Cómo corta el for** | `j=tamano+1` | `j=-1` | `i=tamano+1` | `i=-1` |

---

## PARTE 2 — Receta para CUALQUIER cambio que pida el profe

Hazte estas preguntas y ve al lugar que toca:

| Si el profe pide… | Dónde se toca |
|---|---|
| Un dato nuevo (contador, cantidad, bandera) | Declarar la variable arriba, cerca de la línea 30 |
| Cambiar cuántos hay de algo, la vida o las balas | Líneas 12-22 |
| Un **objeto nuevo** en el tablero | 4 pasos: variable + generador (después de 111) + símbolo (después de 151 **y** de 686) + qué pasa al pisarlo (en los 4 movimientos) |
| Que pase algo **al moverse** sobre algo | En los 4 `case` de movimiento (tabla de arriba) |
| Que pase algo **al disparar** | En los 4 `case` de disparo |
| Una **opción nueva** del menú | Un `println` en el menú (después de 167) + un `case` nuevo (después de 620, antes de la `}` de 622) |
| Algo que pase **en cada turno** | Después de la línea 640 (antes de `movimientos++`) |
| Algo sobre los mercenarios moviéndose | Líneas 624-640 |
| Algo sobre el límite de turnos | Líneas 642-646 |
| Mostrar un dato nuevo en pantalla | Líneas 114 **y** 649 (son dos copias) |
| Cambiar cómo se gana o se pierde | Salida: 234-243, 317-326, 400-409, 483-492 |
| Algo al **terminar** el juego (puntaje, mensaje) | Después de 692, antes de `leer.close()` |

> **Regla de oro:** casi todo está repetido. El tablero se imprime **2 veces**, los movimientos son **4** y los disparos son **4**. Si cambias uno, cambia sus copias.

### Los 4 trozos que se repiten en casi todos los cambios

**A. Revisar las casillas alrededor del soldado**

```java
for(i=posXSoldado-1; i<=posXSoldado+1; i++) {
	for(j=posYSoldado-1; j<=posYSoldado+1; j++) {
		if(i>=0 && i<tamano && j>=0 && j<tamano) {
			// aquí lo que quieras hacer con tablero[i][j]
		}
	}
}
```

**B. Recorrer todo el tablero**

```java
for (i = 0; i < tamano; i++) {
	for (j = 0; j < tamano; j++) {
		// aquí lo que quieras hacer con tablero[i][j]
	}
}
```

**C. Revisar si el soldado murió**

```java
if(vida <= 0 && ganador == false) {
	ganador = true;
	System.out.println("\n!!! GAME OVER !!!\n");
	tablero[posXSoldado][posYSoldado] = 10;
}
```

**D. Opción nueva del menú**

```java
case "X":
	// lo que haga
	break;
```

---

## PARTE 3 — Índice de los 50 cambios (del más probable al menos probable)

El orden es una **apuesta mía**, no algo que haya dicho el profe.

| # | Cambio | Dónde se toca | Nivel |
|---|---|---|---|
| 1 | Objeto nuevo en el tablero (chaleco) | 30, 111, 151, 686 y los 4 movimientos | Medio |
| 2 | Opción nueva: granada | 30, 167, 620 | Medio |
| 3 | Mercenarios que se mueven una casilla o persiguen | 624-640 | Difícil |
| 4 | Mercenarios que atacan si quedan al lado | Después de 640 | Medio |
| 5 | Límite de movimientos y mostrar los que quedan | 30, 114, 643, 649 | Fácil |
| 6 | Cambiar cantidades, vida o balas | 12-20; 237, 320, 403, 486 | Fácil |
| 7 | Contar cosas recorriendo la matriz | 30, después de 640 | Fácil |
| 8 | La bala rompe los muros | 520, 546, 572, 598 | Fácil |
| 9 | Disparo con alcance limitado | 508, 534, 560, 586 | Fácil |
| 10 | Minas ocultas, radar y minas visibles de cerca | 147, 682; después de 640 | Medio |
| 11 | Llave para poder salir | Como el 1; 237, 320, 403, 486 | Medio |
| 12 | La salida no te mata si falta algo | 234-244, 317-327, 400-410, 483-493 | Medio |
| 13 | Varias vidas | 30, después de 640 | Medio |
| 14 | Puntaje al final | 30, después de 692 | Fácil |
| 15 | Opción nueva: cuchillo | 167, 620 | Medio |
| 16 | Contar las minas desactivadas | 30, 614 | Fácil |
| 17 | Soldado o salida en posición al azar | 40, 41 | Fácil |
| 18 | Cambiar el tamaño del tablero | 22, 115, 155, 650, 690 | Fácil |
| 19 | Opción inválida | 620 | Fácil |
| 20 | Que algo no cuente como turno | Antes del `break` del case | Fácil |
| 21 | La bala atraviesa y mata a todos los de la línea | 518, 544, 570, 596 | Fácil |
| 22 | El portal desaparece al usarlo | 212, 295, 378, 461 | Fácil |
| 23 | Cambiar el botiquín | 207-209, 290-292, 373-375, 456-458 | Fácil |
| 24 | Cambiar los daños y la recarga | 187, 227, 201 y sus copias | Fácil |
| 25 | Máximo de balas | 201, 284, 367, 450 | Fácil |
| 26 | Premio al rescatar un rehén | 184, 267, 350, 433 | Fácil |
| 27 | La bala le hace algo a otro objeto | 522, 548, 574, 600 | Medio |
| 28 | Dispararle a un rehén no termina el juego | 510-511, 536-537, 562-563, 588-589 | Fácil |
| 29 | Ganar apenas completes la misión | Después de 640; 643 | Fácil |
| 30 | Mercenarios quietos o que se muevan cada N turnos | 624-640 | Fácil |
| 31 | Refuerzos: llegan más mercenarios | Antes de 624 | Medio |
| 32 | Mercenarios que disparan en línea recta | Después de 640 | Difícil |
| 33 | Pedir dificultad al empezar | Después de 32 | Fácil |
| 34 | Mostrar la posición del soldado | 114, 649 | Fácil |
| 35 | Tablero con números de fila y columna | 115, 117, 155 y sus copias | Medio |
| 36 | Niebla: solo se ve cerca del soldado | 118, 151, 653, 686 | Medio |
| 37 | Guardar botiquines y usarlos cuando quieras | 30, 167, 207-209, 620 | Medio |
| 38 | Recarga manual | 30, 167, 201, 620 | Medio |
| 39 | Perder vida en cada turno | Después de 640 | Fácil |
| 40 | Mensajes de lo que pasó | Dentro de cada bloque | Fácil |
| 41 | Contadores (disparos, choques, golpes) | 30 y donde pase | Fácil |
| 42 | Movimiento en diagonal | 167, 620 | Medio |
| 43 | Jefe que necesita varios disparos | Como el 1; 522 y copias; 237 y copias | Difícil |
| 44 | Dos portales conectados | 19; 212-221 y copias | Difícil |
| 45 | Los rehenes también se mueven | Después de 640 | Difícil |
| 46 | Construir un muro | 30, 167, 620 | Medio |
| 47 | Rastro por donde pasó el soldado (segunda matriz) | 25, 119-121, 654-656; después de 640 | Medio |
| 48 | Pared fija con un hueco | Después de 41 | Medio |
| 49 | Disparo en diagonal | 167, 620 | Difícil |
| 50 | Jugar de nuevo | 30, 34, 692 | Difícil |

---

## PARTE 4 — Los 50 cambios con su código

### 1. Objeto NUEVO en el tablero

Ejemplo: un **chaleco** `[♦]` con el número **11**, que te protege del próximo golpe de un mercenario. Sirve igual para cualquier objeto: cambia el número, el símbolo y el efecto.

**Paso 1 — variables** (cerca de la línea 30):

```java
int chalecos=2;
boolean tieneChaleco=false;
```

**Paso 2 — generarlo** (después de la línea 111):

```java
for (generador = 1; generador <= chalecos; generador++) {
	fila=(int)(Math.random()*tamano);
	columna=(int)(Math.random()*tamano);
	if(tablero[fila][columna]!=0) {
		generador--;
	}else {
		tablero[fila][columna]=11;
	}
}
```

**Paso 3 — dibujarlo** (después de la línea 151 **y** después de la 686):

```java
if(tablero[i][j]==11) {
	System.out.print("[♦]");
}
```

**Paso 4 — qué pasa al pisarlo.** Truco para no enredarte con las llaves: pégalo **justo debajo del `if` que revisa el borde** y termínalo en `}else` (sin llave después). Así se engancha solo con el `if` que ya estaba.

En `D`, entre las líneas 174 y 175:

```java
if(tablero[posXSoldado][posYSoldado + 1] == 11) {
	tablero[posXSoldado][posYSoldado + 1] = 1;
	tablero[posXSoldado][posYSoldado] = 0;
	posYSoldado++;
	tieneChaleco = true;
}else
```

En `A`, entre las líneas 257 y 258:

```java
if(tablero[posXSoldado][posYSoldado - 1] == 11) {
	tablero[posXSoldado][posYSoldado - 1] = 1;
	tablero[posXSoldado][posYSoldado] = 0;
	posYSoldado--;
	tieneChaleco = true;
}else
```

En `S`, entre las líneas 340 y 341:

```java
if(tablero[posXSoldado + 1][posYSoldado] == 11) {
	tablero[posXSoldado + 1][posYSoldado] = 1;
	tablero[posXSoldado][posYSoldado] = 0;
	posXSoldado++;
	tieneChaleco = true;
}else
```

En `W`, entre las líneas 423 y 424:

```java
if(tablero[posXSoldado - 1][posYSoldado] == 11) {
	tablero[posXSoldado - 1][posYSoldado] = 1;
	tablero[posXSoldado][posYSoldado] = 0;
	posXSoldado--;
	tieneChaleco = true;
}else
```

**Paso 5 — usar el efecto.** En el golpe del mercenario (líneas **187, 270, 353 y 436**), cambia `vida = vida - 20;` por:

```java
if(tieneChaleco == true) {
	tieneChaleco = false;
}else {
	vida = vida - 20;
}
```

**Otros efectos** para la línea donde dice `tieneChaleco = true;`:

```java
balas = balas + 10;            // caja de munición
vida = 100;                    // cura total
movimientos = movimientos - 5; // regala turnos
vida = vida - 30;              // trampa
```

**Nota:** las balas atraviesan los objetos nuevos (igual que los botiquines). Si debe detenerlas, mira el cambio 27.

### 2. Opción nueva: granada (destruye mercenarios y muros alrededor)

**Variable** (cerca de la línea 30):

```java
int granadas=2;
```

**Menú** (después de la línea 167):

```java
System.out.println("[G] GRANADA");
```

**Case** (después de la línea 620, antes de la `}` de la 622):

```java
case "G":
	if(granadas > 0) {
		granadas--;
		for(i=posXSoldado-1; i<=posXSoldado+1; i++) {
			for(j=posYSoldado-1; j<=posYSoldado+1; j++) {
				if(i>=0 && i<tamano && j>=0 && j<tamano) {
					if(tablero[i][j]==4) {
						contadorMercenarios++;
						tablero[i][j]=0;
					}
					if(tablero[i][j]==5) {
						tablero[i][j]=0;
					}
				}
			}
		}
	}else {
		System.out.println("\n!!! NO TIENES GRANADAS !!!\n");
	}
	break;
```

### 3. Mercenarios que se mueven UNA casilla (en vez de saltar a cualquier lado)

**Dónde:** reemplaza las líneas **624-640** por esto. El 40 es un número temporal para no mover dos veces al mismo mercenario.

```java
for (i = 0; i < tamano; i++) {
	for (j = 0; j < tamano; j++) {
		if(tablero[i][j] == 4) {
			fila = i;
			columna = j;
			generador = (int)(Math.random()*4);   // 0 arriba, 1 abajo, 2 izquierda, 3 derecha
			if(generador == 0) {
				fila--;
			}
			if(generador == 1) {
				fila++;
			}
			if(generador == 2) {
				columna--;
			}
			if(generador == 3) {
				columna++;
			}
			if(fila>=0 && fila<tamano && columna>=0 && columna<tamano && tablero[fila][columna]==0) {
				tablero[fila][columna] = 40;      // se movió
				tablero[i][j] = 0;
			}else {
				tablero[i][j] = 40;               // no pudo, se queda
			}
		}
	}
}

for (i = 0; i < tamano; i++) {
	for (j = 0; j < tamano; j++) {
		if(tablero[i][j] == 40) {
			tablero[i][j] = 4;
		}
	}
}
```

**Variante: que persigan al soldado.** Cambia la línea del `Math.random` y sus 4 `if` por:

```java
if(fila < posXSoldado) {
	fila++;
}else {
	if(fila > posXSoldado) {
		fila--;
	}else {
		if(columna < posYSoldado) {
			columna++;
		}else {
			columna--;
		}
	}
}
```

### 4. Mercenarios que atacan si quedan al lado del soldado

**Dónde:** después de la línea **640**, antes de `movimientos++`:

```java
for(i=posXSoldado-1; i<=posXSoldado+1; i++) {
	for(j=posYSoldado-1; j<=posYSoldado+1; j++) {
		if(i>=0 && i<tamano && j>=0 && j<tamano) {
			if(tablero[i][j]==4) {
				vida = vida - 10;
			}
		}
	}
}
if(vida <= 0 && ganador == false) {
	ganador = true;
	System.out.println("\n!!! GAME OVER !!!\n");
	tablero[posXSoldado][posYSoldado] = 10;
}
```

### 5. Cambiar el límite de movimientos y mostrar los que quedan

**Dónde:** declara cerca de la línea 30:

```java
int limite=30;
```

Línea 643, cambia el 30:

```java
if(movimientos>=limite) {
```

Para mostrar los que quedan, en las líneas **114 y 649** agrega al final del texto:

```java
+ " | RESTANTES: " + (limite - movimientos)
```

### 6. Cambiar cantidades, vida o balas

**Dónde:** líneas 12-20. Solo cambias el número.

```java
int rehenes=5;
int mercenarios=5;
int muros=10;
int vida=100;
int balas=5;
```

**Cuidado:** si cambias `rehenes` o `mercenarios`, la condición de victoria sigue comparando con 5. Cámbiala en las líneas **237, 320, 403 y 486**:

```java
if(contadorMercenarios == mercenarios && contadorRehenes == rehenes) {
```

### 7. Contar cosas recorriendo la matriz

Ejemplo: mostrar cuántos rehenes faltan por rescatar. Declara arriba `int rehenesRestantes=0;` y pon esto después de la línea **640**:

```java
rehenesRestantes = 0;
for (i = 0; i < tamano; i++) {
	for (j = 0; j < tamano; j++) {
		if(tablero[i][j]==3) {
			rehenesRestantes++;
		}
	}
}
System.out.println("REHENES POR RESCATAR: " + rehenesRestantes);
```

Para contar otra cosa cambia el número: `4` mercenarios, `5` muros, `9` minas, `0` casillas vacías.

**Variante: contar solo en la fila o en la columna del soldado**

```java
for (j = 0; j < tamano; j++) {
	if(tablero[posXSoldado][j]==4) {     // misma fila
		// contador++
	}
}
for (i = 0; i < tamano; i++) {
	if(tablero[i][posYSoldado]==4) {     // misma columna
		// contador++
	}
}
```

### 8. Que la bala rompa los muros

**Dónde:** dentro del `if` del muro, **antes** de la línea que corta el `for`.

```java
// DD, líneas 520-522
if(tablero[posXSoldado][j]==5) {
	tablero[posXSoldado][j]=0;
	j=tamano+1;
}
```

En `DA` (546-548) es igual pero con `j=-1`. En `DS` (572-574) y `DW` (598-600) la casilla es `tablero[i][posYSoldado]=0;`.

> **Importante:** primero cambias la casilla y **después** cortas el `for`. Si lo haces al revés, `j` ya vale 11 y el programa se cae.

### 9. Disparo con alcance limitado (ej. 3 casillas)

**Dónde:** solo cambia la línea del `for` de cada disparo.

```java
// DD, línea 508
for(j=posYSoldado+1; j<tamano && j<=posYSoldado+3; j++) {

// DA, línea 534
for(j=posYSoldado-1; j>=0 && j>=posYSoldado-3; j--) {

// DS, línea 560
for(i=posXSoldado+1; i<tamano && i<=posXSoldado+3; i++) {

// DW, línea 586
for(i=posXSoldado-1; i>=0 && i>=posXSoldado-3; i--) {
```

### 10. Minas ocultas, radar y minas visibles de cerca

**Ocultas del todo.** Líneas **147** y **682**: cambia el símbolo por una casilla vacía.

```java
System.out.print("[ ]");
```

**Visibles solo si están al lado del soldado.** Reemplaza las líneas **146-148** (y **681-683**) por:

```java
if(tablero[i][j]==9) {
	if(i>=posXSoldado-1 && i<=posXSoldado+1 && j>=posYSoldado-1 && j<=posYSoldado+1) {
		System.out.print("[☼]");
	}else {
		System.out.print("[ ]");
	}
}
```

**Radar** (avisar cuántas minas hay cerca). Declara `int cerca=0;` arriba y pon esto después de la línea 640:

```java
cerca = 0;
for(i=posXSoldado-1; i<=posXSoldado+1; i++) {
	for(j=posYSoldado-1; j<=posYSoldado+1; j++) {
		if(i>=0 && i<tamano && j>=0 && j<tamano) {
			if(tablero[i][j]==9) {
				cerca++;
			}
		}
	}
}
System.out.println("MINAS CERCA: " + cerca);
```

### 11. Llave para poder salir

Es el cambio 1 con otro número. Usa el **12**, el símbolo `[k]` y estas variables:

```java
int llaves=1;
boolean tieneLlave=false;
```

Haz los pasos 2, 3 y 4 del cambio 1 con `llaves`, `12`, `[k]` y `tieneLlave = true;`.

Después exige la llave en la salida, líneas **237, 320, 403 y 486**:

```java
if(contadorMercenarios == 5 && contadorRehenes == 5 && tieneLlave == true) {
```

### 12. Que la salida NO te mate si te falta algo (solo avisa)

**Dónde:** reemplaza el bloque de la salida, líneas **234-244** en D:

```java
if(tablero[posXSoldado][posYSoldado + 1] == 2) {
	if(contadorMercenarios == 5 && contadorRehenes == 5) {
		tablero[posXSoldado][posYSoldado] = 0;
		posYSoldado++;
		ganador = true;
		System.out.println("\n!!! YOU WIN !!!\n");
	}else {
		System.out.println("\nTE FALTAN REHENES O MERCENARIOS\n");
	}
}
```

En A (317-327), S (400-410) y W (483-493) es igual cambiando la casilla destino y el avance (tabla de la Parte 1).

### 13. Varias vidas

Declara arriba `int vidas=3;`. Después de la línea **640** (antes de `movimientos++`):

```java
if(vida <= 0 && vidas > 1) {
	vidas--;
	vida = 100;
	ganador = false;
	tablero[posXSoldado][posYSoldado] = 1;
	System.out.println("\nPERDISTE UNA VIDA. TE QUEDAN: " + vidas + "\n");
}
```

Muéstralo en las líneas 114 y 649: `+ " | VIDAS: " + vidas`

### 14. Puntaje al final

Declara arriba `int puntaje=0;`. Después de la línea **692** (fin del `do-while`), antes de `leer.close();`:

```java
puntaje = contadorRehenes*100 + contadorMercenarios*50 + vida - movimientos*5;
System.out.println("PUNTAJE FINAL: " + puntaje);
```

### 15. Opción nueva: cuchillo (mata a los mercenarios de al lado sin gastar balas)

**Menú** (después de la línea 167):

```java
System.out.println("[C] CUCHILLO");
```

**Case** (después de la línea 620):

```java
case "C":
	for(i=posXSoldado-1; i<=posXSoldado+1; i++) {
		for(j=posYSoldado-1; j<=posYSoldado+1; j++) {
			if(i>=0 && i<tamano && j>=0 && j<tamano) {
				if(tablero[i][j]==4) {
					contadorMercenarios++;
					tablero[i][j]=0;
				}
			}
		}
	}
	break;
```

### 16. Contar las minas desactivadas

Declara `int minasDesactivadas=0;` arriba. En la línea **614**, dentro del `if`:

```java
if(tablero[i][j]==9) {
	tablero[i][j]=0;
	minasDesactivadas++;
}
```

Para mostrarlo, agrégalo en las líneas 114 y 649: `+ " | MINAS: " + minasDesactivadas`

### 17. Soldado o salida en posición al azar

**Soldado al azar.** Reemplaza la línea **40** por:

```java
posXSoldado=(int)(Math.random()*tamano);
posYSoldado=(int)(Math.random()*tamano);
tablero[posXSoldado][posYSoldado] = 1;
```

**Salida al azar.** Reemplaza la línea **41** por:

```java
for (generador = 1; generador <= 1; generador++) {
	fila=(int)(Math.random()*tamano);
	columna=(int)(Math.random()*tamano);
	if(tablero[fila][columna]!=0) {
		generador--;
	}else {
		tablero[fila][columna]=2;
	}
}
```

### 18. Cambiar el tamaño del tablero

**Dónde:** línea 22 (`int tamano=10;`).

El borde `╔═══╗` está escrito a mano para 10 casillas. Para que se ajuste solo, reemplaza la línea **115** (y la **650**) por:

```java
System.out.print("╔");
for (j = 0; j < tamano*3; j++) {
	System.out.print("═");
}
System.out.println("╗");
```

Y la línea **155** (y la **690**) por lo mismo pero con `╚` y `╝`.

**Cuidado:** si el tablero es muy pequeño y no caben todos los objetos (son 31 casillas ocupadas), el generador se queda en un ciclo infinito.

### 19. Opción inválida (que avise y no gaste turno)

**Dónde:** después de la línea 620 (el `break` de `DM`), antes de la `}` de la 622:

```java
default:
	System.out.println("\n!!! OPCIÓN INVÁLIDA !!!\n");
	movimientos--;
	break;
```

### 20. Que algo NO cuente como turno

La línea 642 (`movimientos++`) se ejecuta siempre. El truco es **restar uno** en el `case` que no quieras contar, justo antes de su `break`. Así el `++` de la 642 lo deja igual.

Ejemplo, que disparar a la derecha no cuente (antes del `break` de la línea 529):

```java
movimientos--;
break;
```

Los `break` de los disparos están en las líneas 529, 555, 581 y 607. El de `DM` está en la 620.

### 21. La bala atraviesa y mata a todos los mercenarios de la línea

**Dónde:** borra la línea que corta el `for` cuando le da a un mercenario: **518** (DD), **544** (DA), **570** (DS), **596** (DW).

```java
// DD, líneas 515-518: queda así
if(tablero[posXSoldado][j]==4) {
	contadorMercenarios++;
	tablero[posXSoldado][j]=0;
}
```

### 22. Que el portal desaparezca después de usarlo

**Dónde:** justo después de la línea **212** (D), **295** (A), **378** (S), **461** (W). Tiene que ir **antes** del `for`, porque el `for` cambia la posición del soldado.

```java
tablero[posXSoldado][posYSoldado + 1] = 0;   // D
tablero[posXSoldado][posYSoldado - 1] = 0;   // A
tablero[posXSoldado + 1][posYSoldado] = 0;   // S
tablero[posXSoldado - 1][posYSoldado] = 0;   // W
```

Para tener más portales: cambia `portales=1` en la línea 19.

### 23. Cambiar el botiquín

**Dónde:** líneas 207-209 (D), 290-292 (A), 373-375 (S), 456-458 (W).

```java
// Cura siempre, sin pasarse de 100
vida = vida + 20;
if(vida > 100) {
	vida = 100;
}
```

```java
// Cura total
vida = 100;
```

### 24. Cambiar los daños y la recarga

| Qué | Líneas | Cómo está |
|---|---|---|
| Golpe de mercenario | 187, 270, 353, 436 | `vida = vida - 20;` |
| Mina | 227, 310, 393, 476 | `vida = vida - 50;` |
| Recarga | 201, 284, 367, 450 | `balas = balas + 3;` |

### 25. Máximo de balas

**Dónde:** después de la línea **201** (D), **284** (A), **367** (S), **450** (W):

```java
if(balas > 10) {
	balas = 10;
}
```

### 26. Premio al rescatar un rehén

**Dónde:** después de `contadorRehenes++;`, líneas **184** (D), **267** (A), **350** (S), **433** (W). Pon el premio que pidan:

```java
balas = balas + 1;               // una bala
movimientos = movimientos - 2;   // dos turnos extra
vida = vida + 10;                // vida
```

### 27. Que la bala le haga algo a otro objeto (explotar una mina, parar en un botiquín…)

**Dónde:** pegado a la llave que cierra el `if` del muro (línea **522** en DD, **548** en DA, **574** en DS, **600** en DW).

```java
// DD: la línea 522 queda así
}else {
	if(tablero[posXSoldado][j]==9) {
		tablero[posXSoldado][j]=0;     // la mina explota y desaparece
		j=tamano+1;
	}
}
```

Para `DA` usa `j=-1`; para `DS` y `DW` usa `tablero[i][posYSoldado]` con `i=tamano+1` o `i=-1`.

### 28. Que dispararle a un rehén no termine el juego

**Dónde:** líneas 510-511 (DD), 536-537 (DA), 562-563 (DS), 588-589 (DW). Cambia esas dos líneas por el castigo que pidan:

```java
vida = vida - 30;
System.out.println("\n!!! MATASTE A UN REHÉN !!!\n");
```

**Cuidado:** con ese rehén muerto ya no se puede llegar a 5 rescatados; revisa la condición de victoria.

### 29. Ganar apenas completes la misión (sin ir a la salida)

**Dónde:** después de la línea **640**:

```java
if(contadorRehenes == rehenes && contadorMercenarios == mercenarios && ganador == false) {
	ganador = true;
	System.out.println("\n!!! YOU WIN !!!\n");
}
```

Y cambia la línea 643 para que no salga también "GAME OVER" en el turno 30:

```java
if(movimientos>=30 && ganador==false) {
```

### 30. Mercenarios quietos, o que se muevan cada cierto número de turnos

**Quietos:** borra (o comenta con `/* ... */`) las líneas **624-640**.

**Cada 3 turnos:** encierra las líneas 624-640 en un `if`:

```java
if(movimientos % 3 == 0) {
	// aquí quedan las líneas 624-640 tal cual
}
```

### 31. Refuerzos: cada 10 turnos llega un mercenario más

**Dónde:** antes de la línea **624**:

```java
if(movimientos > 0 && movimientos % 10 == 0) {
	mercenarios++;
	System.out.println("\n!!! LLEGÓ UN REFUERZO !!!\n");
}
```

No hay que generarlo aparte: las líneas 632-640 ya ponen `mercenarios - contadorMercenarios`, así que el nuevo aparece solo.

**Cuidado:** la condición de victoria debe usar `mercenarios` y no el 5 fijo (cambio 6). Si además hiciste el cambio 3, esas líneas ya no existen y tienes que generarlo con el `for` del generador.

### 32. Mercenarios que disparan en línea recta

Si un mercenario queda en la misma fila o columna del soldado, sin nada en medio, le quita vida.

**Dónde:** después de la línea **640**:

```java
for(j=posYSoldado+1; j<tamano; j++) {            // mira a la derecha
	if(tablero[posXSoldado][j]==4) {
		vida = vida - 10;
		j=tamano+1;
	}else {
		if(tablero[posXSoldado][j]!=0) {
			j=tamano+1;                          // algo tapa el disparo
		}
	}
}
for(j=posYSoldado-1; j>=0; j--) {                // mira a la izquierda
	if(tablero[posXSoldado][j]==4) {
		vida = vida - 10;
		j=-1;
	}else {
		if(tablero[posXSoldado][j]!=0) {
			j=-1;
		}
	}
}
for(i=posXSoldado+1; i<tamano; i++) {            // mira abajo
	if(tablero[i][posYSoldado]==4) {
		vida = vida - 10;
		i=tamano+1;
	}else {
		if(tablero[i][posYSoldado]!=0) {
			i=tamano+1;
		}
	}
}
for(i=posXSoldado-1; i>=0; i--) {                // mira arriba
	if(tablero[i][posYSoldado]==4) {
		vida = vida - 10;
		i=-1;
	}else {
		if(tablero[i][posYSoldado]!=0) {
			i=-1;
		}
	}
}
if(vida <= 0 && ganador == false) {
	ganador = true;
	System.out.println("\n!!! GAME OVER !!!\n");
	tablero[posXSoldado][posYSoldado] = 10;
}
```

### 33. Pedir dificultad (o un dato) al empezar

**Dónde:** después de la línea **32** (el `Scanner`). Tiene que ir **antes** de los generadores para que las cantidades sirvan.

```java
System.out.print("Dificultad (1 fácil, 2 difícil): ");
int dificultad = leer.nextInt();
if(dificultad == 2) {
	mercenarios = 8;
	minas = 6;
	vida = 60;
}
```

Si cambias `mercenarios`, acuérdate de la condición de victoria (cambio 6).

### 34. Mostrar la posición del soldado

**Dónde:** líneas **114 y 649**, al final del texto:

```java
+ " | POSICIÓN: (" + posXSoldado + "," + posYSoldado + ")"
```

### 35. Tablero con números de fila y columna

**Números de columna.** Antes de la línea **115** (y de la **650**):

```java
System.out.print("  ");
for (j = 0; j < tamano; j++) {
	System.out.print(" " + j + " ");
}
System.out.println();
```

**Número de fila.** Línea **117** (y **652**):

```java
System.out.print(i + "║");
```

**Bordes.** Agrega un espacio al inicio del texto de las líneas **115, 155, 650 y 690** para que quede alineado: `" ╔═══…"` y `" ╚═══…"`.

### 36. Niebla: solo se ve lo que está cerca del soldado

Lo que esté a más de 2 casillas se dibuja como `[?]`.

**Dónde:** después de la línea **118** (antes del primer `if` del dibujo):

```java
if(i < posXSoldado-2 || i > posXSoldado+2 || j < posYSoldado-2 || j > posYSoldado+2) {
	System.out.print("[?]");
}else {
```

Y después de la línea **151** cierra ese `else`:

```java
}
```

Repite lo mismo en la segunda impresión: después de la **653** y después de la **686**.

**Cuidado:** esa `}` va después del **último** `if` del dibujo. Si agregaste símbolos nuevos (cambio 1), ciérrala después de ellos; si no, el objeto nuevo se dibuja dos veces.

### 37. Guardar botiquines y usarlos cuando quieras

**Variable** (cerca de la línea 30):

```java
int botiquinesGuardados=0;
```

**Al recogerlo**, reemplaza las líneas 207-209 (D), 290-292 (A), 373-375 (S), 456-458 (W) por:

```java
botiquinesGuardados++;
```

**Menú** (después de la línea 167):

```java
System.out.println("[B] USAR BOTIQUÍN");
```

**Case** (después de la línea 620):

```java
case "B":
	if(botiquinesGuardados > 0) {
		botiquinesGuardados--;
		vida = vida + 20;
		if(vida > 100) {
			vida = 100;
		}
	}else {
		System.out.println("\n!!! NO TIENES BOTIQUINES !!!\n");
	}
	break;
```

### 38. Recarga manual

Las recargas que recoges se guardan y solo cargas el arma cuando eliges la opción.

**Variable** (cerca de la línea 30):

```java
int reserva=0;
```

**Al recogerla**, cambia las líneas **201, 284, 367 y 450** por:

```java
reserva = reserva + 3;
```

**Menú** (después de la línea 167):

```java
System.out.println("[R] RECARGAR");
```

**Case** (después de la línea 620):

```java
case "R":
	if(reserva > 0) {
		balas = balas + reserva;
		reserva = 0;
	}else {
		System.out.println("\n!!! NO TIENES RESERVA !!!\n");
	}
	break;
```

### 39. Perder vida en cada turno

**Dónde:** después de la línea **640**:

```java
vida = vida - 2;
if(vida <= 0 && ganador == false) {
	ganador = true;
	System.out.println("\n!!! GAME OVER !!!\n");
	tablero[posXSoldado][posYSoldado] = 10;
}
```

### 40. Mensajes de lo que pasó

Agrega un `println` dentro del bloque que toque (tabla de la Parte 1). Ejemplo, al rescatar un rehén (después de la línea 184, 267, 350, 433):

```java
System.out.println("\nREHÉN RESCATADO\n");
```

### 41. Contar cosas que hace el jugador (disparos, choques, golpes)

Declara el contador arriba y súmale donde pase:

| Contador | Dónde poner `contador++;` |
|---|---|
| Disparos | Después de `balas--;` (líneas 507, 533, 559, 585) |
| Choques con muro | Dentro del `if` del muro (líneas 195, 278, 361, 444) |
| Golpes recibidos | Junto a `vida = vida - 20;` (líneas 187, 270, 353, 436) |

### 42. Movimiento en diagonal

**Menú** (después de la línea 167):

```java
System.out.println("[WD] DIAGONAL ARRIBA-DERECHA");
```

**Case** (después de la línea 620). Versión corta: solo se mueve si la casilla está vacía.

```java
case "WD":
	if(posXSoldado - 1 >= 0 && posYSoldado + 1 < tamano) {
		if(tablero[posXSoldado - 1][posYSoldado + 1] == 0) {
			tablero[posXSoldado - 1][posYSoldado + 1] = 1;
			tablero[posXSoldado][posYSoldado] = 0;
			posXSoldado--;
			posYSoldado++;
		}
	}
	break;
```

| Diagonal | Condición del borde | Casilla destino | Avance |
|---|---|---|---|
| Arriba-derecha | `posXSoldado - 1 >= 0 && posYSoldado + 1 < tamano` | `[posXSoldado - 1][posYSoldado + 1]` | `posXSoldado--; posYSoldado++;` |
| Arriba-izquierda | `posXSoldado - 1 >= 0 && posYSoldado - 1 >= 0` | `[posXSoldado - 1][posYSoldado - 1]` | `posXSoldado--; posYSoldado--;` |
| Abajo-derecha | `posXSoldado + 1 < tamano && posYSoldado + 1 < tamano` | `[posXSoldado + 1][posYSoldado + 1]` | `posXSoldado++; posYSoldado++;` |
| Abajo-izquierda | `posXSoldado + 1 < tamano && posYSoldado - 1 >= 0` | `[posXSoldado + 1][posYSoldado - 1]` | `posXSoldado++; posYSoldado--;` |

**Versión completa** (que también recoja rehenes, pise minas, etc.): copia todo el `case "D"` (líneas 173-254), cámbiale el nombre, y reemplaza la condición del borde, la casilla destino y el avance según la tabla.

### 43. Jefe que necesita varios disparos

Un enemigo `[Ω]` con el número **13** que aguanta 3 disparos y no se mueve.

**Variable** (cerca de la línea 30):

```java
int vidaJefe=3;
```

**Generarlo** (después de la línea 111):

```java
for (generador = 1; generador <= 1; generador++) {
	fila=(int)(Math.random()*tamano);
	columna=(int)(Math.random()*tamano);
	if(tablero[fila][columna]!=0) {
		generador--;
	}else {
		tablero[fila][columna]=13;
	}
}
```

**Dibujarlo** (después de la línea 151 **y** de la 686):

```java
if(tablero[i][j]==13) {
	System.out.print("[Ω]");
}
```

**Al dispararle**, pegado a la llave que cierra el `if` del muro (línea **522** en DD):

```java
}else {
	if(tablero[posXSoldado][j]==13) {
		vidaJefe--;
		if(vidaJefe <= 0) {
			tablero[posXSoldado][j]=0;
		}
		j=tamano+1;
	}
}
```

En DA (548) usa `j=-1`; en DS (574) y DW (600) usa `tablero[i][posYSoldado]` con `i=tamano+1` o `i=-1`.

**Para ganar**, líneas 237, 320, 403 y 486:

```java
if(contadorMercenarios == 5 && contadorRehenes == 5 && vidaJefe <= 0) {
```

**Nota:** si el soldado camina hacia el jefe no pasa nada (se comporta como un muro), porque ningún `if` del movimiento revisa el 13.

### 44. Dos portales conectados

Entras por uno y sales por el otro. Los dos se gastan.

**Cantidad:** línea 19, `int portales=2;`

**Al entrar**, reemplaza las líneas **212-221** (D) por:

```java
tablero[posXSoldado][posYSoldado] = 0;
tablero[posXSoldado][posYSoldado + 1] = 0;      // se gasta el portal de entrada
for (i = 0; i < tamano; i++) {
	for (j = 0; j < tamano; j++) {
		if(tablero[i][j] == 8) {                // busca el otro portal
			posXSoldado = i;
			posYSoldado = j;
		}
	}
}
tablero[posXSoldado][posYSoldado] = 1;
```

En A (295-304), S (378-387) y W (461-470) solo cambia la segunda línea por la casilla destino de la tabla de la Parte 1.

### 45. Los rehenes también se mueven

Es el cambio 3 con el número **3** y el temporal **30**. Va después de la línea **640**:

```java
for (i = 0; i < tamano; i++) {
	for (j = 0; j < tamano; j++) {
		if(tablero[i][j] == 3) {
			fila = i;
			columna = j;
			generador = (int)(Math.random()*4);
			if(generador == 0) {
				fila--;
			}
			if(generador == 1) {
				fila++;
			}
			if(generador == 2) {
				columna--;
			}
			if(generador == 3) {
				columna++;
			}
			if(fila>=0 && fila<tamano && columna>=0 && columna<tamano && tablero[fila][columna]==0) {
				tablero[fila][columna] = 30;
				tablero[i][j] = 0;
			}else {
				tablero[i][j] = 30;
			}
		}
	}
}

for (i = 0; i < tamano; i++) {
	for (j = 0; j < tamano; j++) {
		if(tablero[i][j] == 30) {
			tablero[i][j] = 3;
		}
	}
}
```

### 46. Construir un muro

**Variable** (cerca de la línea 30):

```java
int ladrillos=3;
```

**Menú** (después de la línea 167):

```java
System.out.println("[MD] MURO A LA DERECHA");
```

**Case** (después de la línea 620):

```java
case "MD":
	if(ladrillos > 0 && posYSoldado + 1 < tamano && tablero[posXSoldado][posYSoldado + 1] == 0) {
		tablero[posXSoldado][posYSoldado + 1] = 5;
		ladrillos--;
	}
	break;
```

Para las otras direcciones cambia la condición del borde y la casilla destino (tabla de la Parte 1). Sirve igual para **poner una mina** (cambia el 5 por 9).

### 47. Rastro por donde pasó el soldado (segunda matriz)

**Matriz nueva** (después de la línea 25):

```java
int rastro[][] = new int[tamano][tamano];
```

**Marcar la casilla** (después de la línea 640):

```java
rastro[posXSoldado][posYSoldado] = 1;
```

**Dibujarlo**, reemplaza las líneas **119-121** (y **654-656**) por:

```java
if(tablero[i][j]==0) {
	if(rastro[i][j]==1) {
		System.out.print("[·]");
	}else {
		System.out.print("[ ]");
	}
}
```

### 48. Pared fija con un hueco

**Dónde:** después de la línea **41**, antes de los generadores. Ejemplo: muro en toda la fila 5, con un hueco en la columna 4.

```java
for (j = 0; j < tamano; j++) {
	if(j != 4) {
		tablero[5][j] = 5;
	}
}
```

Otras formas:

```java
tablero[i][5] = 5;              // columna 5 (con for de i)
tablero[i][i] = 5;              // diagonal principal (con for de i, sin tocar 0 ni tamano-1)
tablero[i][tamano-1-i] = 5;     // diagonal secundaria (con for de i)
```

**Cuidado:** no tapes la casilla del soldado (0,0) ni la salida (9,9), y baja la cantidad de `muros` al azar para que quepa todo.

### 49. Disparo en diagonal

**Menú** (después de la línea 167):

```java
System.out.println("[DWD] DISPARAR ARRIBA-DERECHA");
```

**Case** (después de la línea 620):

```java
case "DWD":
	if(balas > 0) {
		balas--;
		i = posXSoldado - 1;
		j = posYSoldado + 1;
		while(i >= 0 && j < tamano) {
			if(tablero[i][j]==3) {
				ganador = true;
				System.out.println("\n!!! GAME OVER !!!\n");
				tablero[i][j]=10;
				i = -1;
			}else {
				if(tablero[i][j]==4) {
					contadorMercenarios++;
					tablero[i][j]=0;
					i = -1;
				}else {
					if(tablero[i][j]==5) {
						i = -1;
					}
				}
			}
			i--;
			j++;
		}
	}else {
		System.out.println("\n!!! RELOAD YOUR GUN !!!\n");
	}
	break;
```

Para las otras diagonales cambia el inicio, la condición del `while` y el avance (`i--`/`i++`, `j--`/`j++`). Para cortar hacia abajo usa `i = tamano+1`.

### 50. Jugar de nuevo

Todo el juego queda dentro de otro `do-while`.

**Variable** (cerca de la línea 30):

```java
String otra;
```

**Antes de la línea 34** (abre el ciclo y reinicia los datos):

```java
do {
	vida = 100;
	balas = 5;
	contadorRehenes = 0;
	contadorMercenarios = 0;
	posXSoldado = 0;
	posYSoldado = 0;
	ganador = false;
	movimientos = 0;
```

**Después de la línea 692** (cierra el ciclo):

```java
	System.out.print("¿Jugar de nuevo? (S/N): ");
	otra = leer.next().toUpperCase();
}while(otra.equals("S"));
```

Las líneas 34-38 ya dejan el tablero en ceros, así que cada partida empieza limpia.

---

## PARTE 5 — Errores típicos

- **Olvidar una copia:** cambiaste `D` pero no `A`, `S`, `W`; o el primer tablero pero no el segundo.
- **Llaves `{ }` descuadradas:** los movimientos tienen muchos `else` anidados. Usa el truco del `}else` del cambio 1 para no tocar las llaves que ya están.
- **Cortar el `for` antes de cambiar la casilla** en los disparos (cambio 8).
- **Usar la posición después de moverla:** si ya hiciste `posYSoldado++`, la casilla de al lado ya es otra.
- **Salirse de la matriz:** todo lo que mire alrededor del soldado necesita `i>=0 && i<tamano && j>=0 && j<tamano`.
- **Dejar el 5 fijo** en la condición de victoria al cambiar las cantidades.
- **Demasiados objetos:** si no caben en el tablero, el generador nunca termina.
