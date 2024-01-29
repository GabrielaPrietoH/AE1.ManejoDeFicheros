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
En esta ocasión, siendo conocedores de las particularidades del desarrollo de la actividad, se ha efectuado un desarrollo lógico basado en la eficiencia y claridad del código, así como en su modularidad. En este último caso, se ha efectuado una ejecución de las clases en forma compartimentada, tanto siguiendo un desarrollo mediante el patrón MVC, como un desarrollo original de la distribución de las clases. Ha sido elegido el patrón MVC, debido a su buen funcionamiento y claridad.
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






#### Requerimiento 1:
Requerimiento 1:
Se ha creado una clase llamada Artículo con atributos: id, nombre, descripción, stock y precio. Se han implementado los métodos getters y setters, así también el método toString para facilitar la visualización de la información.


![C1](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/6cf8e655-fb97-4ee0-8c4e-e2fe2bde91c9)


Se han creado las clases DaoArticulo para implementar la lógica del CRUD del menú y el almacenamiento de la información parcialmente  a través de un ArrayList. El Controlador, para facilitar la comunicación de la clase DAO con el menú. La clase CSVExport para alojar la lógica de exportación del archivo en formato CSV. Y la clase Main, que implementa la interfaz del menú y la inicialización de la aplicación.

![C2](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/10fa8981-3096-456f-8779-a61bd06f3833)

![C2 3](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/83d23fa3-7640-4c58-92d8-00de51450043)

![C2 4](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/95452c64-2c14-4273-a57c-d854c80b8719)

![C2 5](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/b3158249-92e5-4a87-8591-f56c4095c012)


Implementación del Menú.


1.  Añadir nuevo artículo.


![C3](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/0627806e-bc8a-463f-9bf0-e3eac15b4626)

2. Borrar artículo por id.

![C4](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/5cb379bd-f157-43ab-ae01-5517a08190b7)

3. Consultar artículo por id.

![C5](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/d3599406-52cc-4143-8452-a7e77b62f290)

4. Listado de todos los artículos.

![C6](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/eed77201-ec4c-4261-bcc5-4a9517b3fcd8)


5. Terminar el programa. Al seleccionar la opción 5 para terminar el programa, guarda la colección de artículos en el archivo articulos.dat

![C7](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/2c40fdaa-c5ae-4318-85f7-d9902b9ff450)

Al iniciar de nuevo el programa, se visualizan los datos que han persistido en ambos ficheros.

![C8](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/744e46a4-6b64-4b76-ac94-ec00af0b953c)


Si se decide borrar uno de los artículos, después terminar el programa y volver a arrancarlo, se mantienen los datos con el mismo estado que durante el guardado.

![C9](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/8eca249d-22a6-4bfb-996f-9da23539ecec)




#### Requerimiento 2:
Agregar una nueva opción en el menú para exportar los artículos a un archivo CSV.

![C10](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/c8f1bd49-4884-460e-acfe-e32d79a8397f)

Implementar la lógica para crear el archivo articulos.csv y escribir la información de los artículos en formato CSV.

![C11](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/2e05f117-423f-4e59-8104-8e0a61e50e2f)


Verificar que el archivo CSV creado se pueda abrir con un programa como Excel y verificar la Exportación.

![C12](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/ed670394-fa1f-49bb-9146-71bd9077fa92)

#### Requerimiento 3:
Implementar Validación de ID Único:

![C13](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/fc7b0482-c32c-4125-ba5b-6686116721f2)

* Al solicitar un nuevo ID, verificar si ese ID ya existe en la colección de artículos.
Los Artículos y su ID persisten. La asignación de ID la hace el sistema automáticamente para que no hay errores y posteriormente ese datos se guarda en el fichero y se verifica durante su futura lectura y escritura.

![C14](https://github.com/GabrielaPrietoH/AE1.ManejoDeFicheros/assets/124418682/88a92659-2286-4d66-baf0-8931de69e37e)


## Conclusión:


Con esta actividad, se han adquirido habilidades fundamentales para el desarrollo de aplicaciones Java centradas en la gestión de datos y la interacción con el usuario. Se comprendió la importancia de la persistencia de datos mediante la lectura y escritura en archivos, utilizando técnicas de serialización. La interacción con el usuario se mejoró mediante la implementación de una interfaz de consola que permite operaciones variadas sobre la colección de artículos, brindando una experiencia más completa.
La incorporación de funcionalidades como la exportación a CSV y la validación para evitar duplicados en IDs demostró cómo enriquecer la aplicación para adaptarse a necesidades específicas y mejorar la calidad de la gestión de datos. En resumen, esta actividad no solo ha fortalecido la comprensión de conceptos esenciales de programación Java, sino que también nos ha brindado una visión práctica sobre la importancia de la persistencia, la interacción con el usuario y la adaptabilidad en el desarrollo de aplicaciones.
