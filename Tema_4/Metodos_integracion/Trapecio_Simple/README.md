# Tema 4: Método de integración Trapecio Simple

## Descripción del método

El método del trapecio simple se utiliza para aproximar el valor de una integral definida. Se basa en reemplazar la curva de la función por una línea recta que conecta dos puntos: el extremo inferior y el extremo superior del intervalo. El área bajo esta línea recta (un trapecio) se utiliza como aproximación del área bajo la curva. Este método es útil cuando se necesita una solución rápida y sencilla, especialmente cuando no se requiere alta precisión.

## Formula del método
    ∫[a, b] f(x) dx ≈ (b - a)/2 * [f(a) + f(b)]

Donde:
- `a`: Límite inferior de integración.
- `b`: Límite superior de integración.
- `f(x)`: Función a integrar.

## Pseudocódigo

    Proceso MetodoTrapecioSimple
        Definir a, b, c, limInf, limSup Como Real
        Definir f_a, f_b, resultado Como Real
        
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
            Escribir "El límite inferior debe ser menor que el límite superior."
        FinSi

        f_a <- a * limInf * limInf + b * limInf + c
        f_b <- a * limSup * limSup + b * limSup + c

        resultado <- (limSup - limInf) / 2 * (f_a + f_b)

        Escribir "La aproximación de la integral es: ", resultado
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/Trapecio_Simple.java)

## Ejemplo de aplicación
- Integrar la función: 3x + 7
- Limite inferior: 2
- Limite superior: 8

- [Ejecución del código en Java](./src/Ejecucion.png)
