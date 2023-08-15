# REDLO_test

## Instalación
***

Clonar el repositorio.
```
$ git clone https://github.com/jrebatta/REDLO_test.git
```
O descargue un ZIP de main y descomprima el contenido.

## Requisitos previos
***

Para ejecutar pruebas de navegador, Selenium deberá poder controlar un navegador instalado en su sistema.

En este caso se está utilizando un ```chromedriver``` versión 111.0.5563.64.

Si su sistema cuenta con otra version de Google Chrome, actualizar el driver desde https://chromedriver.chromium.org/downloads y ubicarlo en ```./src/test/resources/drivers```


## Parámetros
***

Abrir ```/data/Datos.xlsx```:

* Alli estan todos los datos de las pruebas


## Ejecución
***
## Maven
***

Abra una ventana de comando y ejecutar:

```
$ mvn verify test -Dcucumber.options="--tags @..."
```

Seleccionar el @tag de acuerdo con los casos de prueba que desea ejecutar, puede ejecutar por feature o por caso de prueba.

Tags por feature:

* @regesion: ejecuta todos los casos
* @happypath: ejecuta los casos happy path
* @unhappypath: ejecuta los casos unhappy path
