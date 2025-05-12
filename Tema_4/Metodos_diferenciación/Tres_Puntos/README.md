# Tema 4: Método de diferenciación Tres Puntos

## Descripción del método

La diferenciación numérica de tres puntos es un método para aproximar la derivada de una función utilizando tres puntos en su dominio. Este enfoque se basa en interpolar un polinomio a través de estos tres puntos y luego derivar dicho polinomio. 

## Formula del método
f′(x) ≈ (f(x+h)−f(x−h))/2h
Donde:
- `f(x + h)`: valor de la función un poco a la derecha del punto x.
- `f(x - h)`: valor de la función un poco a la izquierda del punto x.
- `2h`: es el doble del paso y representa la distancia total entre los dos puntos considerados alrededor de x.

## Pseudocódigo

    Proceso MetodoDerivadaTresPuntos

        Definir a, b, c, x, h Como Real
        Definir fx_menos, fx_mas, derivada Como Real

        Escribir "Ingrese el coeficiente a (para ax^2):"
        Leer a

        Escribir "Ingrese el coeficiente b (para bx):"
        Leer b

        Escribir "Ingrese el coeficiente c:"
        Leer c

        Escribir "Ingrese el punto x en donde desea calcular la derivada:"
        Leer x

        Escribir "Ingrese el valor de h (por ejemplo, 0.001):"
        Leer h

        Si h <= 0 Entonces
            Escribir "El valor de h debe ser mayor que 0."
            FinProceso
        FinSi

        fx_menos <- EvaluarFuncion(a, b, c, x - h)
        fx_mas <- EvaluarFuncion(a, b, c, x + h)

        derivada <- (fx_mas - fx_menos) / (2 * h)

        Escribir "La aproximación de la derivada es: ", derivada

    FinProceso

    Funcion EvaluarFuncion(a, b, c, x) : Real
        EvaluarFuncion <- a * x * x + b * x + c
    FinFuncion

## Programa ejecutable
- [Código en lenguaje Java](./src/Tres_Puntos.java)

## Ejemplo de aplicación
Derivar la función: 6x^2 + 3x + 8
Cuando: x = 4
Con un paso de 0.001

- [Ejecución del código en Java](./src/Ejecución.png)