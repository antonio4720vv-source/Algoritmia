# Ejercicio 45 - Diagrama de flujo (Conjetura de Ullman)

Digitado un entero n > 1, imprimir la serie: si n es par se divide entre 2,
si es impar se multiplica por 3 y se le suma 1, hasta llegar a 1.

Ejemplo con 26: `26 13 40 20 10 5 16 8 4 2 1`

```mermaid
flowchart TD
    A([Inicio]) --> B[/Leer n/]
    B --> C{n <= 1?}
    C -- Si --> B
    C -- No --> D[/Imprimir n/]
    D --> E{n != 1?}
    E -- Si --> F{n % 2 == 0?}
    F -- Si --> G[n = n / 2]
    F -- No --> H[n = n * 3 + 1]
    G --> I[/Imprimir n/]
    H --> I
    I --> E
    E -- No --> J([Fin])
```
