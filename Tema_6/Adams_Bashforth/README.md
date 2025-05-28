# Tema 6: Método de varios paasos - Adams Bashforth

## Descripción del método

Es un método explícito multietapa que usa una combinación lineal de derivadas pasadas. Requiere varios valores iniciales, por eso se usa RK4 para generar los primeros 3. Tiene orden 4, por lo que es muy preciso.

## Formula del método
    yn+1 = yn + (h/24)*((55fn)-(59fn-1)+(37fn-2)-(9fn-3))

Donde:
- `fn = f(tn, yn)`: derivada en el punto actual
- `fn-1, fn-2, fn-3`: derivadas en pasos anteriores
- `f(xn, yn)`: pendiente en el punto actual
- `h`: tamaño de paso
- `yn+1`: nuevo valor de la función

## Pseudocódigo

    Proceso AdamsBashforth4Pasos
        Definir t, w, h, yNext, tNext Como Real
        Definir k1, k2, k3, k4 Como Real
        Definir i, n Como Entero
        Dimension tVals[100], yVals[100]
        
        Escribir "Ingrese valor inicial t0:"
        Leer t
        Escribir "Ingrese valor inicial y0:"
        Leer w
        Escribir "Ingrese el tamaño de paso h:"
        Leer h
        Escribir "Ingrese el número total de pasos (mínimo 4):"
        Leer n
        
        tVals[0] <- t
        yVals[0] <- w
        
        // Generar los primeros 3 valores con Runge-Kutta de 4º orden
        Para i <- 1 Hasta 3
            k1 <- w
            k2 <- w + (h * k1) / 2
            k3 <- w + (h * k2) / 2
            k4 <- w + h * k3
            w <- w + (h / 6) * (k1 + 2*k2 + 2*k3 + k4)
            t <- t + h
            tVals[i] <- t
            yVals[i] <- w
        FinPara
        
        // Aplicar fórmula de Adams-Bashforth de 4 pasos
        Para i <- 3 Hasta n - 1
            tNext <- tVals[i] + h
            yNext <- yVals[i] + (h / 24) * (55*yVals[i] - 59*yVals[i-1] + 37*yVals[i-2] - 9*yVals[i-3])
            tVals[i+1] <- tNext
            yVals[i+1] <- yNext
        FinPara
        
        // Mostrar resultados
        Escribir "Resultados:"
        Para i <- 0 Hasta n
            Escribir "t = ", tVals[i], "   y = ", yVals[i]
        FinPara
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/AdamsBashforthConRK4.java)

## Ejemplo de aplicación
En una investigación sobre el crecimiento de un cultivo de bacterias en condiciones 
controladas, se ha observado que la tasa de crecimiento es directamente proporcional a la 
cantidad actual de bacterias. El modelo que describe este fenómeno está dado por la 
ecuación diferencial: dy/dt = y
El objetivo es predecir cuántas bacterias habrá después de varios días, usando un tamaño 
de paso de h=0.2

- [Ejecución del código en Java](./src/Ejecucion.png)

- **Resultado:** 54.60 bacterias
