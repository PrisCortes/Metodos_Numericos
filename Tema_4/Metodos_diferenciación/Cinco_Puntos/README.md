# Tema 4: Método de diferenciación Cinco Puntos

## Descripción del método

Método para aproximar la derivada de una función en un punto usando los valores de la función en cinco puntos alrededor de ese punto.

## Formula del método
f′(x) ≈ (−f(x+2h)+8f(x+h)−8f(x−h)+f(x−2h))/12h <br>
Donde:
- `f(x)`: Es la función que se desea derivar.
- `x`: Punto en el que quieres aproximar la derivada.
- `h`: Representa la distancia entre puntos en el eje x para calcular la derivada. Se conoce como "paso" o "delta x".

## Pseudocódigo

    Proceso MetodoDerivadaCincoPuntos

        Definir a, b, c, x, h Como Real
        Definir fx_m2h, fx_m1h, fx_p1h, fx_p2h, derivada Como Real

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

        fx_m2h <- EvaluarFuncion(a, b, c, x - 2 * h)
        fx_m1h <- EvaluarFuncion(a, b, c, x - h)
        fx_p1h <- EvaluarFuncion(a, b, c, x + h)
        fx_p2h <- EvaluarFuncion(a, b, c, x + 2 * h)

        derivada <- (-fx_p2h + 8 * fx_p1h - 8 * fx_m1h + fx_m2h) / (12 * h)

        Escribir "La aproximación de la derivada es: ", derivada

    FinProceso

    Funcion EvaluarFuncion(a, b, c, x) : Real
        EvaluarFuncion <- a * x * x + b * x + c
    FinFuncion

## Programa ejecutable
- [Código en lenguaje Java](./src/Cinco_Puntos.java)

## Ejemplo de aplicación
- Derivar la función: x^2 + 6x + 2
- Cuando: x = 7
- Con un paso de 0.001
- [Ejecución del código en Java](./src/Ejecucion.png)
