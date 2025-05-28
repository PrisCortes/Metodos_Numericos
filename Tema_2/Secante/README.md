# Tema 2: Método de la Secante

## Descripción del método

Es una versión del método de Newton que no requiere la derivada. Usa dos puntos iniciales y una recta secante para aproximar la raíz.

## Formula del método
    Xn+1 = Xn - f(Xn) * ((Xn-Xn-1)/(f(Xn)-f(Xn-1)))

Donde:
- `Xn-1`: penúltima aproximación
- `Xn`: última aproximación
- `Xn+1`: nueva aproximación de la raíz
- `(f(Xn), f(Xn-1)`: valores de la función en Xn-1 y Xn

    *Criterio de parada*: |Xn+1 - Xn| < tolerancia.

## Pseudocódigo

    Proceso MetodoSecante
        Definir x0, x1, x2, f0, f1, errorA, errorR, tolerancia Como Real
        Definir i, maxIteraciones Como Entero
        
        // Parámetros iniciales
        x0 <- 0.0
        x1 <- 1.0
        tolerancia <- 0.0001
        maxIteraciones <- 100
        
        // Iteraciones del método de la secante
        Para i <- 1 Hasta maxIteraciones Hacer
            
            // Evaluar f(x0) y f(x1)
            f0 <- exp(-x0) - x0
            f1 <- exp(-x1) - x1
            
            // Evitar división por cero
            Si f1 - f0 <> 0 Entonces
                x2 <- x1 - f1 * (x1 - x0) / (f1 - f0)
            FinSi

            // Calcular errores
            errorA <- abs(x2 - x1)
            errorR <- errorA / abs(x2)

            // Mostrar detalles de la iteración
            Escribir "Iteración ", i, ": x0 = ", x0, ", x1 = ", x1, ", x2 = ", x2
            Escribir "   Error Absoluto = ", errorA, "   Error Relativo = ", errorR

            // Verificar tolerancia
            Si errorA < tolerancia Entonces
                Escribir ""
                Escribir "Raíz aproximada: ", x2, " en ", i, " iteraciones"
            FinSi

            // Actualizar valores para la siguiente iteración
            x0 <- x1
            x1 <- x2
        FinPara

        // Si no se alcanza la tolerancia
        Escribir ""
        Escribir "No se alcanzó la tolerancia deseada después de ", maxIteraciones, " iteraciones."
        Escribir "Último valor estimado: ", x1
    FinProceso


## Programa ejecutable
- [Código en lenguaje Java](./src/Secante.java)

## Ejemplo de aplicación
- Hallar la raíz de la función: f(x) = e^(-x) - x
- x0: 0
- x1= 1
- [Ejecución del código en Java](./src/Ejecucion.png)
- **Número de iteraciones**: 4
- **Resultado:** 0.567
