# Tema 4: Método de integración Simpson 3/8

## Descripción del método

El método de Simpson 3/8 aproxima el área bajo una curva utilizando polinomios cúbicos. Es especialmente útil cuando el número de subintervalos es múltiplo de 3, ya que agrupa los puntos de tres en tres. Este método ofrece una buena precisión para funciones suaves, similar al Simpson 1/3 pero con una regla de aproximación distinta.

## Formula del método
    ∫[a, b] f(x) dx ≈ (3h/8) * [f(x0) + 3f(x1) + 3f(x2) + 2f(x3) + 3f(x4) + 3f(x5) + ... + 3f(x_{n−1}) + f(xn)]

Donde:
- `a`: Límite inferior de integración.
- `b`: Límite superior de integración.
- `n`: Número de subintervalos (debe ser múltiplo de 3)
- `h`: Ancho del subintervalo, calculado como (b - a) / n
- `xi`: Puntos dentro del intervalo [a, b]
- `f(x)`: Función a integrar.

## Pseudocódigo

    Proceso MetodoSimpson_3_8

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

        Escribir "Ingrese el número de subintervalos (múltiplo de 3):"
        Leer n

        Si n <= 0 o n MOD 3 ≠ 0 o limInf >= limSup Entonces
            Escribir "Datos inválidos. Asegúrese de que n > 0, que n sea múltiplo de 3 y que los límites sean correctos."
            FinProceso
        FinSi

        h <- (limSup - limInf) / n
        suma <- EvaluarFuncion(a, b, c, limInf) + EvaluarFuncion(a, b, c, limSup)

        Para i <- 1 Hasta n - 1 Hacer
            x <- limInf + i * h
            Si i MOD 3 = 0 Entonces
                suma <- suma + 2 * EvaluarFuncion(a, b, c, x)
            Sino
                suma <- suma + 3 * EvaluarFuncion(a, b, c, x)
            FinSi
        FinPara

        integral <- (3 * h / 8) * suma

        Escribir "La aproximación de la integral es: ", integral

    FinProceso

    Funcion EvaluarFuncion(a, b, c, x) : Real
        EvaluarFuncion <- a * x^2 + b * x + c
    FinFuncion

## Programa ejecutable
- [Código en lenguaje Java](./src/Simpson_3_8.java)

## Ejemplo de aplicación
- Integrar la función: 5x^2 + 2x + 3
- Limite inferior: -2
- Limite superior: 4
- Número de subintervalos: 6

- [Ejecución del código en Java](./src/Ejecucion.png)
