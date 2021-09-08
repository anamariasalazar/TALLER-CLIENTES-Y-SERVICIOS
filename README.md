# TALLER-CLIENTES-Y-SERVICIOS 

Taller donde se realizan peticiones consecutivas(no concurrentes) a un servidor, además de usar encabezados HTTP, accediendo a archivos locales del programa, leyendolos y desplegandolos, todo a través de protocolos HTTP con servicios get.Este servidor permite acceder/retornar todos los archivos solicitados incluyendo javascripts, páginas html e imágenes por medio de un sitio web en javascript el cual permite probar el servidor. Esta solución está desplegada en Heroku. 

### Requisitos previos

* Tener maven instalado
* Tener git instalado
* Versión de Java 7 o Java 8
* Tener Heroku

### Instalación

1. Para hacer uso de este proyecto debe clonarlo de este repositorio a su computadora desde cmd usando el siguiente comando:
   
   ```
   git clone https://github.com/anamariasalazar/TALLER-CLIENTES-Y-SERVICIOS
   ```

2. Antes de ejecutarlo debe compilar el proyecto, para esto haga uso del siguiente comando:

    ```
    mvn package
    ```
3.  * Si se encuentra desde linux en el archivo procfile y reemplace el contenido por el siguiente texto:
    
    ```
    web: java $JAVA_OPTS -cp 'target/classes:target/dependency/* edu.escuelaing.arep.app.App
    
    ```
    * Si se encuentra desde windows en el archivo procfile y reemplace el contenido por el siguiente texto:
    
    ```
    web: java -cp target/classes;target/dependency/* edu.escuelaing.arep.app.App
    ```


## Ejecutando las pruebas

Corra la aplicación localmente emulando Heroku:

   * Ejecute el siguiente comando:
     ```
     mvn clean install
     ```
   
   * Luego ejecute el siguiente comando para correr la aplicación en una version local del dispositivo en el que se encuentre:
     ```
     heroku local web
     ```
   * Se ve el despliege en el siguiente link:
   
      *http://localhost:35000/index.js
   
## Directo con el link de heroku
> [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://tallerclientesyservicios.herokuapp.com/index.js)

 
 Cuando se abra la App en la parte que dice "Ingrese nombre del archivo" se tiene para prueba los siguientes archivos:  
 
 
JPG:
   * thebeatles.jpg
   * queen.jpg
   * MichaelJackson.jpg
   
js:
   * Holaatodos.js
   * trabajo.js
   
html:
   * Holaquehace.html
   * trabajo.html
 
  
## Construido con

* [Java] : Tecnología que se usa para el desarrollo de aplicaciones que convierten a la Web en un elemento más interesante y útil.
* [IntelliJ] : Es un entorno de desarrollo integrado (IDE) para el desarrollo de programas informáticos.
* [Git] : Herramienta que realiza una función del control de versiones de código de forma distribuida
* [Maven] : Maven es una herramienta de software para la gestión y construcción de proyectos Java creada por Jason van Zyl, de Sonatype, en 2002. 
* [Heroku] : Heroku es una plataforma en la nube que permite a las empresas construir, entregar, supervisar aplicaciones y alojarlas en la nube
* [Spark Web] : Spark te permite convertir tus textos y fotografías en gráficos de aspecto profesional que llamarán la atención de todos. 
* [JavaScrip] : Es el lenguaje de programación encargado de dotar de mayor interactividad y dinamismo a las páginas web.
* [JSON] : Es un formato de texto sencillo para el intercambio de datos. Se trata de un subconjunto de la notación literal de objetos de JavaScript, aunque, debido a su amplia adopción como alternativa a XML, se considera un formato independiente del lenguaje

## Autor

* [Ana Maria Salazar Bohorquez](https://github.com/anamariasalazar)

## Licencia

**©️** Ana Maria Salazar Bohorquez etudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito

Licencia bajo la [GNU General Public License](/LICENSE.txt)
