# Tema 4: Método de integración Trapecio Compuesto

## Descripción del método

El método del trapecio compuesto mejora la precisión del trapecio simple al dividir el intervalo de integración en varios subintervalos. En cada subintervalo se aplica la regla del trapecio y luego se suman todas las áreas. Es ideal para obtener aproximaciones más precisas cuando se conoce la función y se puede dividir el intervalo en partes iguales.


## Formula del método
     ∫[a, b] f(x) dx ≈ (h/2) * [f(x0) + 2f(x1) + 2f(x2) + ... + 2f(x_{n−1}) + f(xn)]

Donde:
- `a`: Límite inferior de integración.
- `b`: Límite superior de integración.
- `n`: Número de subintervalos (n > 0)
- `h`: Ancho del subintervalo, calculado como (b - a) / n
- `xi`: Puntos dentro del intervalo [a, b]
- `f(x)`: Función a integrar.

## Pseudocódigo

    Proceso MetodoTrapecioCompuesto
        Definir a, b, c, limInf, limSup Como Real
        Definir n Como Entero
        Definir h, suma, x, fx, integral Como Real
        
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
        
        Escribir "Ingrese el número de subintervalos (n > 0):"
        Leer n
        
        Si n <= 0 o limInf >= limSup Entonces
            Escribir "Datos inválidos. Asegúrese de que n > 0 y que el límite inferior sea menor al superior."
        FinSi

        h <- (limSup - limInf) / n

        // f(limInf)
        x <- limInf
        suma <- a * x * x + b * x + c

        // f(limSup)
        x <- limSup
        suma <- suma + (a * x * x + b * x + c)

        Para i <- 1 Hasta n - 1 Hacer
            x <- limInf + i * h
            fx <- a * x * x + b * x + c
            suma <- suma + 2 * fx
        FinPara

        integral <- (h / 2) * suma

        Escribir "La aproximación de la integral es: ", integral
    FinProceso


## Programa ejecutable
- [Código en lenguaje Java](./src/Trapecio_Compuesto.java)

## Ejemplo de aplicación
- Integrar la función: x^2 - 7x - 1
- Limite inferior: -1
- Limite superior: 3
- Número de trapecios: 6

- [Ejecución del código en Java](./src/Ejecucion.png)

- **Resultado:** -22.37u