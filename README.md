# Java-CRUD-PostgreSQL
Ejemplo de proyecto: Aplicación Java, para conectarse a una base de datos PostgreSQL y realizar operaciones de Crear, Leer, Actualizar y Eliminar.

inicio.java

Este es un código de inicio de una aplicación de Java que utiliza una base de datos PostgreSQL para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) en una tabla de Alumnos.

En la primera línea se define el paquete en el que se encuentra la clase "inicio". En este caso, el paquete es "com.mycompany.java_crud_postgresql".

La clase "inicio" contiene un método llamado "main", que es el punto de entrada de la aplicación. En este método, se crea un objeto de la clase "VistaAlumnos", que es la interfaz gráfica de usuario (GUI) que se utilizará para interactuar con la base de datos.

Finalmente, se establece la visibilidad del objeto de la vista como verdadero (true), lo que significa que la ventana de la interfaz gráfica de usuario se mostrará en la pantalla del usuario.

Este código es un ejemplo de cómo iniciar una aplicación de Java que utiliza una base de datos PostgreSQL y una GUI para realizar operaciones CRUD en una tabla de Alumnos.


CAlumnos.java

El código presenta una clase Java llamada CAlumnos, que se encarga de realizar operaciones CRUD (Create, Read, Update, Delete) en una tabla llamada "Alumnos" en una base de datos PostgreSQL.

El código incluye los siguientes métodos públicos:

mostrarAlumnos: Este método se encarga de mostrar todos los registros de la tabla "Alumnos" en una tabla de Java Swing que se recibe como parámetro.

insertarAlumnos: Este método se encarga de insertar un nuevo registro en la tabla "Alumnos". Recibe como parámetros dos objetos JTextField que contienen el nombre y apellido del nuevo alumno.

seleccionarAlumnos: Este método se encarga de seleccionar un registro de la tabla "Alumnos" y mostrar sus datos en tres objetos JTextField que se reciben como parámetros (para el código, nombre y apellido del alumno seleccionado). Se utiliza una tabla de Java Swing que también se recibe como parámetro para obtener el registro seleccionado.

modificarAlumnos: Este método se encarga de modificar un registro existente en la tabla "Alumnos". Recibe como parámetros tres objetos JTextField que contienen el código, nombre y apellido del alumno a modificar.

eliminarAlumnos: Este método se encarga de eliminar un registro existente en la tabla "Alumnos". Recibe como parámetro un objeto JTextField que contiene el código del alumno a eliminar.

Además, la clase tiene tres atributos privados (codigo, nombreAlumno, apellidoAlumno) y sus respectivos métodos getter y setter para acceder y modificar dichos atributos.

El código utiliza la clase CConexion para establecer la conexión con la base de datos PostgreSQL. También utiliza las clases ResultSet y Statement de Java SQL para realizar consultas y operaciones en la tabla "Alumnos". Por último, utiliza la clase CallableStatement para ejecutar las operaciones de inserción, modificación y eliminación de registros en la tabla "Alumnos".


CConexion.java

Este código es una clase llamada CConexion, que establece la conexión a una base de datos PostgreSQL y devuelve un objeto Connection que se utilizará para ejecutar consultas SQL. La clase tiene los siguientes atributos:

conectar: objeto de tipo Connection que se utiliza para establecer la conexión con la base de datos.

usuario: nombre de usuario para acceder a la base de datos.

contrasena: contraseña del usuario para acceder a la base de datos.

bd: nombre de la base de datos a la que se desea conectar.

ip: dirección IP del servidor donde se encuentra la base de datos.

puerto: número de puerto en el que se encuentra el servidor de la base de datos.

cadena: cadena de conexión que se utiliza para establecer la conexión.

La clase tiene un método llamado establecerConexion() que devuelve un objeto Connection. Este método utiliza los atributos de la clase para establecer una conexión con la base de datos. Para ello, utiliza el driver JDBC de PostgreSQL, cuya clase se registra utilizando Class.forName(). Luego, se establece la conexión utilizando DriverManager.getConnection(), pasando la cadena de conexión y las credenciales de usuario y contraseña. Si se establece la conexión con éxito, se muestra un mensaje de confirmación. Si ocurre algún error, se muestra un mensaje de error que indica el problema.

En resumen, esta clase se utiliza para establecer una conexión a una base de datos PostgreSQL utilizando JDBC, y su método establecerConexion() devuelve un objeto Connection que se utilizará para ejecutar consultas SQL en la base de datos.


VistaAlumnos.java

El código proporciona una interfaz gráfica de usuario para un CRUD (Crear, Leer, Actualizar, Eliminar) de Alumnos, almacenados en una base de datos PostgreSQL.

La clase VistaAlumnos extiende de javax.swing.JFrame para crear una ventana, y contiene componentes de interfaz gráfica de usuario para visualizar y modificar los datos de los alumnos. Los componentes se crean y se configuran en el método initComponents() que es generado automáticamente.

El constructor de la clase inicia initComponents() y crea un objeto de la clase CAlumnos, que se encarga de recuperar los datos de los alumnos de la base de datos y los muestra en una tabla (tbListaAlumnos) a través del método mostrarAlumnos().

Los datos de los alumnos se ingresan y se modifican a través de campos de texto (txtId, txtNom, txtApe) y los botones "Agregar", "Modificar" y "Eliminar". Cuando se hace clic en el botón "Agregar", se inserta un nuevo registro en la base de datos con los valores ingresados. Cuando se hace clic en el botón "Modificar", se actualiza el registro seleccionado en la tabla con los nuevos valores ingresados. Cuando se hace clic en el botón "Eliminar", se elimina el registro seleccionado de la base de datos.

La tabla se configura para desactivarse para evitar que el usuario la edite directamente. Cuando se hace clic en una fila de la tabla, los datos correspondientes se cargan en los campos de texto para su edición.
