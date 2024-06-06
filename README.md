# Juegalos

Aplicación que simula el alquiler de videojuegos entre varios usuarios. Ellos mismos al mismo tiempo son los que nutren de videojuegos la aplicación. Reciben una transferencia por cada alquiler efectivo de sus videojuegos tras la realización de las facturas.

## Descripción

La aplicación está basada en el patron de diseño de arquectura de software Modelo, Vista, controlador (MVC) donde entran en juego la construcción DAO, DAOImpl y Controller dentro del paradigma de la programación orientada a objetos (POO).

**Modelo**: Son los datos en sí, sobre los que se ejecutarán los métodos que hacen las operaciones CRUD. Estos son las clases o entidades. Manejan la lógica de la aplicación y la persistencia de datos.
- Entra en juego el DAO, proporciona una interface con esos métodos que culminarán con las operaciones CRUD contra objetos de una clase. Se agregan métodos que deben ser implementados y que afectan a operaciones sobre los objetos de una clase determinada para interactuar con una base de datos.
- Entra en juego el DAOImpl, que es una clase que ya implementa aquellos métodos y los desarrolla conteniendo el código específico para interactuar con la base de datos y cuyo objetivo es la persistencia de datos. Este proyecto usa la API JDBC (Java Database Connectivity). Se llama desde el Controller en este caso (no existen servicios) para ejecutar operaciones CRUD.

**Vista**: La vista es responsable de la presentación de los datos y la interacción con el usuario. En esta aplicación Java SE, es la interfaz gráfica construida con Swing.

**Controlador**: Actúa como un intermediario entre el modelo y la vista. Recibe las entradas del usuario, en nuestro caso desde una interfaz de usuario, no desde una API REST, llama al modelo (DAO, DAOIMPL) para obtener los datos necesarios, y luego actualiza la vista para reflejar esos datos.

```plaintext
Usuario -> Controller -> DAO -> DAOImpl -> Base de Datos
      <-             <-      <-        <- 
```


## Estructura

```plaintext
/
Juegalos/
├── doc/
├── sql/
├── src/
└── pom

```

## Directorio doc

Se encuentra el documento explicativo de los requerimientos necesarios y diagramas que explican el proyecto y su porqué.

## Directorio sql

Script con las tablas necesarias para el funcionamiento del proyecto y ciertas inserciones de datos en la tablas para empezar a manejar situaciones.

## Directorio src

Clases, interfaces

## Archivo pom

Archivo que gestiona la instalación de dependencias por ser un proyecto con esquema Maven (XML)


## Requisitos

- Java 17
- Maven 3.8.1+
- MariaDB (usando XAMPP)

## Tecnologías Utilizadas

- Java SE
- Swing para la interfaz gráfica de usuario
- JDBC para la conexión con la base de datos
- Sin uso de frameworks como Spring Boot


## Configuración del Proyecto

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/serporion/juegalos.git
   cd juegalos
   ```

2. **Instalar las dependencias**
   ```bash
   mvn clean install
   ```

3. **Configuración de la Base de Datos**
   - Asegúrate de que XAMPP esté ejecutándose y que MariaDB esté activo.
   - Importa el script SQL para crear las tablas necesarias. El script lo puedes localizar en **`sql/SQL_Schema_y_Datos_Juegalos_v2b.sql`**.
   - Ejecuta esta sentencia para cargar el script.

     ```bash
     mysql -u root -p juegalos_db < sql/SQL_Schema_y_Datos_Juegalos_v2b.sql 
     ```
    - Te pedirá la contraseña. La contraseña será vacio, déjala en blanco.

4. **Ejecución del Proyecto**
   - Usa tu IDE preferido (Eclipse / IntelliJ IDEA / NetBeans)

       Abre el proyecto y configura y ejecuta la clase principal que inicia esta aplicación. Este proyecto se inicia con la clase **entradalogin.java** localizada en **`src/formularios/`**.

   - Esta aplicación no utiliza Spring Boot ni ningún otro framework.

   - Usando Maven:
     - Compila el paquete
     ```bash   
      mvn clean package
     ```
     - Ejecución el Archivo JAR Generado
     ```bash   
      java -jar target/juegalos-0.0.1-SNAPSHOT.jar
     ```
     - Asegúrate de que la base de datos esté configurada y accesible antes de ejecutar el archivo JAR.


## Documentación

La documentación completa del proyecto se encuentra en la carpeta `docs/Proyecto_Juegalos_v1.pdf`.


## Licencia

Este proyecto está licenciado bajo la Licencia Creative Commons No Derivadas (CC-ND). Consulta el archivo [LICENSE](LICENSE) para más detalles.


## Contacto y Soporte

Para más información o preguntas sobre este repositorio, puedes contactar de las siguientes maneras:

- **Nombre**: Oscar
- **Correo Electrónico**: [serporionGit@hotmail.com](mailto:serporionGit@hotmail.com)
- **GitHub**: [serporion](https://github.com/serporion)


## Contribuir

Si tienes alguna pregunta, encuentras un problema o tienes una sugerencia, por favor, abre un issue en este repositorio. Seguiremos el progreso y las discusiones a través de los issues para mantener todo organizado. Puedes abrir también un pull request.

Para abrir un nuevo issue [aquí](https://github.com/serporion/Juegalos/issues/new).
