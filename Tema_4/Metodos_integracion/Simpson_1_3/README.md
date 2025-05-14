# Tema 4: Método de integración Simpson 1/3

## Descripción del método

El método de Simpson 1/3 es una técnica de integración numérica que utiliza parabolas para aproximar el área bajo la curva de una función. Esta técnica requiere que el número de subintervalos sea par, ya que se agrupan de dos en dos para aplicar la regla de aproximación. 


## Formula del método
    ∫[a, b] f(x) dx ≈ (h/3) * [f(x0) + 4f(x1) + 2f(x2) + 4f(x3) + ... + 4f(x_{n−1}) + f(xn)]

Donde:
- `a`: Límite inferior de integración.
- `b`: Límite superior de integración.
- `n`: Número de subintervalos (debe ser par)
- `h`: Ancho del subintervalo, calculado como (b - a) / n
- `xi`: Puntos dentro del intervalo [a, b]
- `f(x)`: Función a integrar.

## Pseudocódigo

    Proceso MetodoSimpson_1_3

        Definir a, b, c, limInf, limSup Como Real
        Definir n Como Entero
        Definir h, suma, x, integral Como Real

        Escribir "Ingrese el coeficiente a (para ax^2):"
        Leer a

        Escribir "Ingrese el coeficiente b (para bx):"
        Leer b

        Escribir "Ingrese el coeficiente c:"
        Leer c

        Escribir "Ingrese el límite inferior de integración:"
        Leer limInf

        Escribir "Ingrese el límite superior de integración:"
        Leer limSup

        Escribir "Ingrese el número de subintervalos (n par):"
        Leer n

        Si n <= 0 o n MOD 2 ≠ 0 o limInf >= limSup Entonces
            Escribir "Datos inválidos. Asegúrese de que n > 0, que n sea par y que los límites sean correctos."
            FinProceso
        FinSi

        h <- (limSup - limInf) / n
        suma <- EvaluarFuncion(a, b, c, limInf) + EvaluarFuncion(a, b, c, limSup)

        Para i <- 1 Hasta n - 1 Hacer
            x <- limInf + i * h
            Si i MOD 2 = 0 Entonces
                suma <- suma + 2 * EvaluarFuncion(a, b, c, x)
            Sino
                suma <- suma + 4 * EvaluarFuncion(a, b, c, x)
            FinSi
        FinPara

        integral <- (h / 3) * suma

        Escribir "La aproximación de la integral es: ", integral

    FinProceso

    Funcion EvaluarFuncion(a, b, c, x) : Real
        EvaluarFuncion <- a * x^2 + b * x + c
    FinFuncion

## Programa ejecutable
- [Código en lenguaje Java](./src/Simpson_1_3.java)

## Ejemplo de aplicación
- Integrar la función: 2x^2 + 4x + 1
- Limite inferior: 0
- Limite superior: 6
- Número de subintervalos: 6

- [Ejecución del código en Java](./src/Ejecucion.png)
