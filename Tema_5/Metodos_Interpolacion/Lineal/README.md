# Tema 5: Método de interpolación lineal

## Descripción del método

La interpolación lineal es el enfoque más básico y directo para estimar valores entre dos puntos conocidos. Se basa en la suposición de que el cambio entre dos datos es uniforme, es decir, sigue una línea recta.

## Formula del método
    y = y0 + [(y1-y0)/(x1-x0)] * (x-x0)

Donde:
- `(x0,y0)` y `(x1,y1)`: Son los puntos conocidos.
- `x`: Es el valor donde interpolamos.
- `y`: Es el valor estimado en x.

## Pseudocódigo

    Proceso InterpolacionLineal
        Definir x0, x1, y0, y1, x, m, resultado Como Real
        
        Escribir "Valor de x0:"
        Leer x0
        
        Escribir "Valor de x1:"
        Leer x1
        
        Escribir "Valor de y0:"
        Leer y0
        
        Escribir "Valor de y1:"
        Leer y1
        
        Escribir "Valor de x:"
        Leer x
        
        Si x1 = x0 Entonces
            Escribir "Error: División entre cero. x0 y x1 no deben ser iguales."
        FinSi

        m <- (y1 - y0) / (x1 - x0)
        resultado <- y0 + m * (x - x0)

        Escribir "Valor interpolado: ", resultado
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/Main.java)

## Ejemplo de aplicación
Sabiendo que después de **2 horas** de haber llegado, la temperatura de un paciente es de **37.2222°** y a las **4 horas** llego a **38.1111°**. Calcular la temperatura que tuvo después de **3 horas** de haber llegado.

- [Ejecución del código en Java](./src/Ejecucion.png)

- **Resultado:** 37.66° tenia el paciente después de 3 horas de haber llegado.