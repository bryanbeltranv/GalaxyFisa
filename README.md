# GalaxyFisa
## Autor: Bryan Beltrán

### 1. Pasos para ejecutar aplicación:
1. Ingresar desde la terminal al directorio: GalaxyFisa1.0/GalaxyMain
2. Ejecutar comando mvn clean install
3. Ejecutar clase Main ubicada en el directorio:
GalaxyFisa1.0/GalaxyMain/src/main/java/com/fisa/Main.java

### 2. Carga de Datos 

El sistema carga el archivo input.txt ubicado en el directorio:
GalaxyFisa1.0/GalaxyMain/src/main/resources/input.txt

### 3. Descripción del Problema

#### 3.1 Guía del comerciante para la galaxia

Decidiste migrar de la tierra después de que el último colapso financiero dejara al 99,99% de la población de la tierra con el 0,01% de la riqueza. Afortunadamente, con la escasa suma de dinero que queda en su cuenta, puede permitirse el lujo de alquilar una nave espacial, abandonar la Tierra y volar por toda la galaxia para vender metales y tierra comunes (lo que aparentemente vale mucho).

Comprar y vender en la galaxia requiere que conviertas números y unidades, y decidiste escribir un programa para ayudarte.

Los números utilizados para las transacciones intergalácticas siguen una convención similar a los números romanos y usted ha recopilado minuciosamente la traducción apropiada entre ellos.

Los números romanos se basan en siete símbolos:

| Símbolo | Valor |
| ----- | ---- |
| I | 1 |
| V | 5 |
| X | 10 |
| D | 50 |
| C | 100 |
| L | 500|
| M | 1000 |

#### 3.2 Restricciones de números romanos

Los números se forman combinando símbolos y sumando los valores. Por ejemplo, MMVI es 1000 + 1000 + 5 + 1 = 2006. Generalmente, los símbolos se colocan en orden de valor, comenzando con los valores más grandes. Cuando los valores más pequeños preceden a los valores más grandes, los valores más pequeños se restan de los valores más grandes y el resultado se suma al total. Por ejemplo MCMXLIV = 1000 + (1000 - 100) + (50 - 10) + (5 - 1) = 1944.

Los símbolos "I", "X", "C" y "M" se pueden repetir tres veces seguidas, pero no más. (Pueden aparecer cuatro veces si el tercero y el cuarto están separados por un valor menor, como XXXIX.) "D", "L" y "V" nunca pueden repetirse.

"I" se puede restar de "V" y "X" solamente. "X" se puede restar de "L" y "C" solamente. "C" se puede restar de "D" y "M" solamente. "V", "L" y "D" nunca se pueden restar.

Solo se puede restar un símbolo de valor pequeño de cualquier símbolo de valor grande.

Un número escrito en números arábigos se puede dividir en dígitos. Por ejemplo, 1903 se compone de 1, 9, 0 y 3. Para escribir el número romano, cada uno de los dígitos distintos de cero debe tratarse por separado. En el ejemplo anterior, 1,000 = M, 900 = CM y 3 = III. Por lo tanto, 1903 = MCMIII.

#### 3.3 Ingreso de datos

La entrada a su programa consiste en líneas de texto que detallan sus notas sobre la conversión entre unidades intergalácticas y números romanos.

Se espera que maneje las consultas no válidas de manera adecuada.

##### Ingreso:

```
glob is I

prok is V

pish is X

tegj is L

glob glob Silver is 34 Credits

glob prok Gold is 57800 Credits

pish pish Iron is 3910 Credits

how much is pish tegj glob glob ?

how many Credits is glob prok Silver ?

how many Credits is glob prok Gold ?

how many Credits is glob prok Iron ?

how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
```
##### Respuesta:

```
pish tegj glob glob es 42

glob prok Silver es de 68 créditos

glob prok Gold es 57800 créditos

glob prok Iron tiene 782 créditos

No tengo ni idea de lo que estás hablando
```
