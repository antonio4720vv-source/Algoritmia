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

---

## PARTE 3 — Cambios listos para copiar

### 1. Cambiar cantidades, vida o balas

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

### 2. Cambiar el tamaño del tablero

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

### 3. Cambiar el límite de movimientos y mostrar los que quedan

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

### 4. Que algo NO cuente como turno

La línea 642 (`movimientos++`) se ejecuta siempre. El truco es **restar uno** en el `case` que no quieras contar, justo antes de su `break`. Así el `++` de la 642 lo deja igual.

Ejemplo, que disparar a la derecha no cuente (antes del `break` de la línea 529):

```java
movimientos--;
break;
```

Los `break` de los disparos están en las líneas 529, 555, 581 y 607. El de `DM` está en la 620.

### 5. Opción inválida (que avise y no gaste turno)

**Dónde:** después de la línea 620 (el `break` de `DM`), antes de la `}` de la 622:

```java
default:
	System.out.println("\n!!! OPCIÓN INVÁLIDA !!!\n");
	movimientos--;
	break;
```

### 6. Mercenarios quietos, o que se muevan cada cierto número de turnos

**Quietos:** borra (o comenta con `/* ... */`) las líneas **624-640**.

**Cada 3 turnos:** encierra las líneas 624-640 en un `if`:

```java
if(movimientos % 3 == 0) {
	// aquí quedan las líneas 624-640 tal cual
}
```

### 7. Mercenarios que se mueven UNA casilla (en vez de saltar a cualquier lado)

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

### 8. Mercenarios que atacan si quedan al lado del soldado

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

### 9. Objeto NUEVO en el tablero (el más probable)

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

**Nota:** las balas atraviesan los objetos nuevos (igual que los botiquines). Si debe detenerlas, mira el cambio 12.

### 10. Disparo con alcance limitado (ej. 3 casillas)

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

### 11. Que la bala rompa los muros

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

### 12. Que la bala le haga algo a otro objeto (explotar una mina, parar en un botiquín…)

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

### 13. Que dispararle a un rehén no termine el juego

**Dónde:** líneas 510-511 (DD), 536-537 (DA), 562-563 (DS), 588-589 (DW). Cambia esas dos líneas por el castigo que pidan:

```java
vida = vida - 30;
System.out.println("\n!!! MATASTE A UN REHÉN !!!\n");
```

**Cuidado:** con ese rehén muerto ya no se puede llegar a 5 rescatados; revisa la condición de victoria.

### 14. Opción nueva: granada (destruye mercenarios y muros alrededor)

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

**Variante cuchillo** (matar al mercenario de al lado sin gastar balas): el mismo `case` sin la parte de `granadas` y sin el `if` del muro.

### 15. Minas ocultas

**Dónde:** líneas **147** y **682**. Cambia el símbolo por una casilla vacía:

```java
System.out.print("[ ]");
```

**Variante radar** (avisar cuántas minas hay cerca). Declara `int cerca=0;` arriba y pon esto después de la línea 640:

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

### 16. Contar las minas desactivadas

Declara `int minasDesactivadas=0;` arriba. En la línea **614**, dentro del `if`:

```java
if(tablero[i][j]==9) {
	tablero[i][j]=0;
	minasDesactivadas++;
}
```

Para mostrarlo, agrégalo en las líneas 114 y 649: `+ " | MINAS: " + minasDesactivadas`

### 17. Que el portal desaparezca después de usarlo

**Dónde:** justo después de la línea **212** (D), **295** (A), **378** (S), **461** (W). Tiene que ir **antes** del `for`, porque el `for` cambia la posición del soldado.

```java
tablero[posXSoldado][posYSoldado + 1] = 0;   // D
tablero[posXSoldado][posYSoldado - 1] = 0;   // A
tablero[posXSoldado + 1][posYSoldado] = 0;   // S
tablero[posXSoldado - 1][posYSoldado] = 0;   // W
```

Para tener más portales: cambia `portales=1` en la línea 19.

### 18. Cambiar el botiquín

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

### 19. Cambiar los daños y la recarga

| Qué | Líneas | Cómo está |
|---|---|---|
| Golpe de mercenario | 187, 270, 353, 436 | `vida = vida - 20;` |
| Mina | 227, 310, 393, 476 | `vida = vida - 50;` |
| Recarga | 201, 284, 367, 450 | `balas = balas + 3;` |

### 20. Varias vidas

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

### 21. Que la salida NO te mate si te falta algo (solo avisa)

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

### 22. Ganar apenas completes la misión (sin ir a la salida)

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

### 23. Puntaje al final

Declara arriba `int puntaje=0;`. Después de la línea **692** (fin del `do-while`), antes de `leer.close();`:

```java
puntaje = contadorRehenes*100 + contadorMercenarios*50 + vida - movimientos*5;
System.out.println("PUNTAJE FINAL: " + puntaje);
```

### 24. Pedir dificultad (o un dato) al empezar

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

Si cambias `mercenarios`, acuérdate de la condición de victoria (cambio 1).

### 25. Movimiento en diagonal

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

### 26. Mensajes de lo que pasó

Agrega un `println` dentro del bloque que toque (tabla de la Parte 1). Ejemplo, al rescatar un rehén (después de la línea 184, 267, 350, 433):

```java
System.out.println("\nREHÉN RESCATADO\n");
```

### 27. Contar cosas (disparos hechos, choques con muros, pasos…)

Declara el contador arriba y súmale donde pase:

| Contador | Dónde poner `contador++;` |
|---|---|
| Disparos | Después de `balas--;` (líneas 507, 533, 559, 585) |
| Choques con muro | Dentro del `if` del muro (líneas 195, 278, 361, 444) |
| Golpes recibidos | Junto a `vida = vida - 20;` (líneas 187, 270, 353, 436) |

---

## PARTE 4 — Errores típicos

- **Olvidar una copia:** cambiaste `D` pero no `A`, `S`, `W`; o el primer tablero pero no el segundo.
- **Llaves `{ }` descuadradas:** los movimientos tienen muchos `else` anidados. Usa el truco del `}else` del cambio 9 para no tocar las llaves que ya están.
- **Cortar el `for` antes de cambiar la casilla** en los disparos (cambio 11).
- **Usar la posición después de moverla:** si ya hiciste `posYSoldado++`, la casilla de al lado ya es otra.
- **Salirse de la matriz:** todo lo que mire alrededor del soldado necesita `i>=0 && i<tamano && j>=0 && j<tamano`.
- **Dejar el 5 fijo** en la condición de victoria al cambiar las cantidades.
- **Demasiados objetos:** si no caben en el tablero, el generador nunca termina.
