# Tema 5: Método de regresión de Mínimos Cuadrados

## Descripción del método

El método de mínimos cuadrados es el más usado para ajustar una curva a datos experimentales. A diferencia de la interpolación, no se obliga a que la curva pase por todos los puntos. En lugar de eso, se busca que en promedio se equivoque lo menos posible.

## Formula del método
    m = (nΣxy - ΣxΣy) / (nΣx² - (Σx)²)
    b = (Σy - mΣx) / n

Donde:
`n`: El número de puntos de datos

## Pseudocódigo

    Proceso Minimos_Cuadrados    
        Definir n, i Como Entero
        Definir xi, wi Como Real
        Definir sum_x, sum_w, sum_x2, sum_xw Como Real
        Definir a, b Como Real
        
        sum_x <- 0
        sum_w <- 0
        sum_x2 <- 0
        sum_xw <- 0
        
        Escribir "Método de mínimos cuadrados - Ajuste lineal"
        
        Escribir "Cantidad de datos a ingresar:"
        Leer n
        
        Dimension  x[n]
        Dimension w[n]
        
        // Ingreso de datos
        Para i <- 1 Hasta n Hacer
            Escribir "Ingrese x[", i, "]:"
            Leer xi
            Escribir "Ingrese w[", i, "]:"
            Leer wi
            
            x[i] <- xi
            w[i] <- wi
        FinPara
        
        // Cálculo de sumatorias
        Para i <- 1 Hasta n Hacer
            sum_x <- sum_x + x[i]
            sum_w <- sum_w + w[i]
            sum_x2 <- sum_x2 + x[i]^2
            sum_xw <- sum_xw + x[i] * w[i]
        FinPara
        
        // Cálculo de la pendiente b y la ordenada al origen a
        b <- (n * sum_xw - sum_x * sum_w) / (n * sum_x2 - sum_x^2)
        a <- (sum_w - b * sum_x) / n
        
        // Mostrar resultado (redondear visualmente a 4 cifras)
        Escribir ""
        Escribir "Resultado:"
        Escribir "La recta de regresión es: y = ", a, " + ", b, "x"
	FinProceso


## Programa ejecutable
- [Código en lenguaje Java](./src/Minimos_Cuadrados.java)

## Ejemplo de aplicación
Relación entre años de experiencia y salario mensual.
| Temperatura  | Ventas |
|--------------|--------|
|      1       |  1500  |
|      3       |  2100  |
|      5       |  2600  |
|      7       |  3000  |
|      9       |  3400  |


- [Ejecución del código en Java](./src/Ejecucion.png)