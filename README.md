 AE1.ManejoDeFicheros
# AE_1 Grupal. Manejo de ficheros


![F1](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/1b9505be-f0cc-4460-b9a8-7af1c274c098)



## Acceso a Datos


## Grupo 8 :
  ● Cristian David Quiceno Laverde
  ● Gabriela Prieto Herrera 
  ● Libertad Gamarra La Rosa


## Repositorio Git:

https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros.git














## Metodología:
  La siguiente actividad realizada en grupo, trata sobre la construcción de la lógica de una aplicación de gestión de almacén, mediante el uso de Java como lenguaje y algunas de las clases de su API más importantes para la persistencia de los datos en memoria mediante ficheros, tanto en formato binario, como en formato CSV.
  Partiendo del consenso mutuo entre los integrantes del grupo, se ha decidido realizar la aplicación de forma individual, para garantizar el aprendizaje profundo de los conceptos a tratar. Una vez se finalizó su desarrollo particular, se unificaron los resultados personales para decidir cuál de las opciones sería atribuida a la rama Main del trabajo colaborativo recogido en GitHub.
  En esta ocasión, siendo conocedores de las particularidades del desarrollo de la actividad, se ha efectuado un desarrollo lógico basado en la eficiencia y claridad del código, así como en su modularidad. En este último caso, se ha efectuado una ejecución de las clases en forma compartimentada, tanto siguiendo un desarrollo mediante el patrón MVC, como un desarrollo original de la distribución de las clases. Ha sido este último patrón el elegido, debido a su buen funcionamiento y claridad.
   Finalmente, todo el desarrollo ha sido recogido mediante esta memoria y protegido en el repositorio de GitHub aquí referenciado, donde se podrá visualizar el desarrollo individual de cada una de las ramas, con su respectiva exposición de la aplicación.
    
    
    
    
    





























## Enunciado:
## Requerimiento 1
Esta práctica consiste en la implementación de un programa Java para la gestión del almacén de artículos. Los artículos tendrán los siguientes atributos, id, nombre, descripción, stock (o cantidad) y precio.
El usuario interactuará con el programa a través del siguiente menú, que servirá como interfaz.
* Añadir nuevo artículo
* Borrar artículo por id
* Consulta artículo por id
* Listado de todos los artículos
* Terminar el programa
  
Nada más comenzar la ejecución del programa se debe verificar si existe el fichero artículos.dat (fichero que contendrá objetos ‘Artículo’). Si existe, debes leerlo para llenar una colección de tipo ArrayList con todos los objetos ‘Articulo’ existentes en el fichero. Si no existe el archivo, no tendrás nada que hacer por el momento, pero sí debes dejar la colección ArrayList disponible, aunque esté vacía.
Las opciones del menú 1 a 5 trabajarán sobre la colección de tipo ArrayList para añadir, borrar, consultar o listar, y no sobre el fichero artículos.dat.
Cuando el usuario decida terminar la ejecución del programa pulsando la opción 5, el programa deberá crear el fichero artículos.dat, sobreescribiendo el anterior si existiera. Se escribirán en el fichero tantos artículos como elementos tenga la colección ArrayList que has creado.
## Requerimiento 2
Se añadirá una opción al menú que será “Exportar artículos a archivo CSV”, que creará un fichero (artículos.csv) donde guardará la información de los artículos con el formato de un archivo CSV. Se debe comprobar que dicho fichero se puede abrir con un programa como Excel o alguna herramienta en online en la memoria de la actividad. Se podrá utilizar alguna biblioteca de java para hacer esta funcionalidad.
## Requerimiento 3
No se permite duplicar el id del artículo.


## Contenido:






## Requerimiento 1:
* Se ha creado una clase llamada Artículo con atributos: id, nombre, descripción, stock y precio. Se han implementado los métodos getters y setters, así también el método toString para facilitar la visualización de la información.

  ![F2](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/be3e5314-0408-4184-8fd8-851f42ff4cbc)

* Se ha creado la Clase AlmacenApp que contendrá el programa principal que incluye un menú interactivo con opciones para:

 ![F3](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/a2ae8604-315a-4ca0-a58f-9e945bc05254) 

  Dado que el fichero articulos.dat no existe utilizamos la colección del arrayList disponible.

![F4](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/7d1d74a7-2874-4076-bfc0-6ef969cee528)



** Añadir nuevo artículo.

![F5](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/66586316-416f-48d6-a723-4f147cb9f932)

** Borrar artículo por id.

![F6](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/fd59b025-e63e-4dc9-9bc5-69c8c35ec8e8)

** Consultar artículo por id.

![F7](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/b34ee376-0d38-49ef-9c15-752438e53996)

** Listado de todos los artículos.

![F8](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/f439c1bf-f9d7-4d63-9912-46e2b5661b61)

** Terminar el programa. 
Al seleccionar la opción 5 para terminar el programa, guarda la colección de artículos en el archivo articulos.dat

![F9](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/f0fa9292-b691-4145-97fa-05b23ff6e591)




## Requerimiento 2:
* Agregar una nueva opción en el menú para exportar los artículos a un archivo CSV.

  ![F10](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/02df32f5-b081-4dc2-a64d-ce5491d800b2)

* Implementar la lógica para crear el archivo articulos.csv y escribir la información de los artículos en formato CSV.

![F11](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/152b877d-7b19-42ba-895d-702bea1a1cac)

* Verificar que el archivo CSV creado se pueda abrir con un programa como Excel y verificar la Exportación.



## Requerimiento 3:
* Implementar Validación de ID Único:
* Al solicitar un nuevo ID, verificar si ese ID ya existe en la colección de artículos.

* No permitir la adición del nuevo artículo si el ID ya existe. Mostrar un mensaje de error en ese caso.

























## Conclusión:


Con esta actividad, se han adquirido habilidades fundamentales para el desarrollo de aplicaciones Java centradas en la gestión de datos y la interacción con el usuario. Se comprendió la importancia de la persistencia de datos mediante la lectura y escritura en archivos, utilizando técnicas de serialización. La interacción con el usuario se mejoró mediante la implementación de una interfaz de consola que permite operaciones variadas sobre la colección de artículos, brindando una experiencia más completa.
La incorporación de funcionalidades como la exportación a CSV y la validación para evitar duplicados en IDs demostró cómo enriquecer la aplicación para adaptarse a necesidades específicas y mejorar la calidad de la gestión de datos. En resumen, esta actividad no solo ha fortalecido la comprensión de conceptos esenciales de programación Java, sino que también nos ha brindado una visión práctica sobre la importancia de la persistencia, la interacción con el usuario y la adaptabilidad en el desarrollo de aplicaciones.
