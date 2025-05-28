# Tema 6: Método de Heun Simple

## Descripción del método

Es un método predictor-corrector de orden 2. Primero predice el valor de la función usando la pendiente inicial (como Euler), y luego corrige ese valor usando el promedio entre la pendiente inicial y la pendiente en el punto predicho.

## Formula del método
    ypred = yn + h * f(xn, yn)
    yn+1 = yn + (h/2)*(f(xn,yn) + f(xn+1, ypred))

Donde:
- `yn`: valor actual de la función
- `h`: paso de integración
- `f(xn, yn)`: pendiente en el punto actual
- `ypred`: valor predicho con la pendiente inicial
- `xn+1 = xn + h`: nuevo valor de x
- `yn+1`: valor corregido de la función

## Pseudocódigo

    Proceso MetodoHeunSimple 
        Definir x, yy, h, k1, k2, yPredic, pendientePromedio, yNuevo Como Real 
        // Condiciones iniciales 
        x <- 0 
        yy <- 1 
        h <- 0.1 
        Escribir "x      y"   
        Escribir x, "     ",yy
        
        // Paso 1: calcular pendiente inicial 
        k1 <- x + yy 
        // Paso 2: calcular valor predicho de y 
        yPredic <- yy + h * k1 
        // Paso 3: calcular pendiente en el punto predicho 
        k2 <- (x + h) + yPredic 
        // Paso 4: calcular la pendiente promedio 
        pendientePromedio <- (k1 + k2) / 2 
        // Paso 5: nuevo valor de y corregido 
        yNuevo <- yy + h * pendientePromedio 
        // Paso 6: actualizar x e y 
        x <- x + h 
        yy <- yNuevo 
        // Mostrar resultado 
        Escribir x, "     ", yy 
        Escribir "Aproximación final de y en x = ", x, ": ", yy 
    FinProceso

## Programa ejecutable
- [Código en lenguaje Java](./src/HeunSimple.java)

## Ejemplo de aplicación
- Una pequeña población de bacterias crece en un medio nutriente donde la tasa de crecimiento depende tanto del tiempo como del tamaño actual de la población. Este fenómeno puede modelarse mediante la siguiente ecuación diferencial ordinaria: x + y.
- x = 0
- y(0) = 1
- h = 0.1

- [Ejecución del código en Java](./src/Ejecucion.png)

- **Resultado:** Después de 0.1 horas (o 6 minutos), la población pasó de 1000 bacterias a 
aproximadamente 1110 bacterias. 
