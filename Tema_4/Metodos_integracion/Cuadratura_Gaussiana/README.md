# Tema 4: Método de integración Cuadratura Gaussiana

## Descripción del método

La cuadratura gaussiana es un método de integración numérica que proporciona una aproximación muy precisa para integrales definidas. A diferencia de otros métodos, selecciona inteligentemente los puntos de evaluación (`xi`) y los pesos (`wi`) para maximizar la precisión con el menor número de evaluaciones posibles. En este caso, se implementa la fórmula de cuadratura de Gauss con 2 puntos, que es ideal para funciones suaves y de tipo polinomial.



## Formula del método
    ∫[a, b] f(x) dx ≈ ((b - a)/2) * [w1 * f(x1) + w2 * f(x2)]

Donde:
- `x1` = ((b - a)/2) * (-1/√3) + (b + a)/2
- `x2` = ((b - a)/2) * (1/√3) + (b + a)/2
- `w1` = w2 = 1

- `a`: Límite inferior de integración.
- `b`: Límite superior de integración.
- `f(x)`: Función a integrar.
- `x1`, `x2`: Puntos donde se evalúa la función.
- `w1`, `w2`: Pesos para cada punto (valen 1 en este caso).

## Pseudocódigo

    Proceso MetodoCuadratura_Gaussiana
        Definir a, b, c, limInf, limSup Como Real
        Definir x1, x2, f1, f2, integral Como Real
        
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
        
        Si limInf >= limSup Entonces
            Escribir "Límites inválidos. El límite inferior debe ser menor que el superior."
        FinSi

        // Transformación de puntos de [-1,1] al intervalo [limInf, limSup]
        x1 <- ((limSup - limInf) / 2) * (-1 / RAIZ(3)) + (limInf + limSup) / 2
        x2 <- ((limSup - limInf) / 2) * (1 / RAIZ(3)) + (limInf + limSup) / 2

        // Evaluación de la función polinómica ax^2 + bx + c en los puntos transformados
        f1 <- a * x1 * x1 + b * x1 + c
        f2 <- a * x2 * x2 + b * x2 + c

        // Cálculo de la integral aproximada usando cuadratura gaussiana de 2 puntos
        integral <- ((limSup - limInf) / 2) * (f1 + f2)

        Escribir "La aproximación de la integral es: ", integral
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/Cuadratura_Gaussiana.java)

## Ejemplo de aplicación
- Integrar la función: 3x^2 + 5x + 2
- Limite inferior: 0
- Limite superior: 4

- [Ejecución del código en Java](./src/Ejecucion.png)

- **Resultado:** 112u