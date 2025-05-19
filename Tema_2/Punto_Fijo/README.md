# Tema 2: Método del Punto Fijo

## Descripción del método

Requiere convertir la ecuación f(x) = 0 en la forma x = g(x), y luego usar la iteración sucesiva. Converge si
|g'(x) < 1| cerca de la raíz.

## Formula del método
    Xn+1 = g(Xn)

Donde:
- `Xn`: aproximación actual de la raíz
- `Xn+1`: nueva aproximación, obtenida aplicando la función g(x)
- `g(x)`: tranformación de f(x) = 0 a x = g(x)

    *Criterio de parada*: |Xn+1 - Xn| < tolerancia.

## Pseudocódigo

    Proceso MetodoPuntoFijo
        Definir x0, x1, errorA, errorR, tolerancia Como Real
        Definir i, maxIteraciones Como Entero
        
        // Parámetros iniciales (pueden pedirse al usuario si se desea)
        x0 <- 0
        tolerancia <- 0.0001
        maxIteraciones <- 100
        
        // Iteraciones del método de Punto Fijo
        Para i <- 1 Hasta maxIteraciones Hacer
            
            // Evaluar g(x) = (x^3 + 1) / 4
            x1 <- (x0^3 + 1) / 4
            
            // Calcular errores
            errorA <- abs(x1 - x0)
            errorR <- errorA / abs(x1)
            
            // Mostrar resultados de la iteración
            Escribir "Iteración ", i, ": x0 = ", x0, ", x1 = ", x1
            Escribir "   Error Absoluto = ", errorA, "   Error Relativo = ", errorR
            
            // Verificar si se alcanza la tolerancia
            Si errorA < tolerancia Entonces
                Escribir ""
                Escribir "Raíz aproximada: ", x1, " en ", i, " iteraciones"
        FinSi

        // Actualizar valor de x0 para la siguiente iteración
        x0 <- x1
        FinPara

        // Si no converge dentro del número máximo de iteraciones
        Escribir ""
        Escribir "No se alcanzó la tolerancia deseada después de ", maxIteraciones, " iteraciones."
        Escribir "Último valor estimado: ", x0
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/PuntoFijo.java)

## Ejemplo de aplicación
- Hallar la raíz de la función: f(x) = x^3 - 4x + 1
- Función transformada: x = (x^3 + 1) / 4
- i = 0
- Xn = 0
- [Ejecución del código en Java](./src/Ejecucion.png)
- **Número de iteraciones**: 4
- **Resultado:** 0.254
