## Enunciado

1. Crea un fichero de texto con el nombre y contenido que tu quieras. Ahora crea una aplicación que lea este fichero de texto carácter a carácter y muestre su contenido por pantalla separado por arroa. Por ejemplo, si un fichero tiene el siguiente texto “Esto es una prueba”, deberá mostrar “Esto@es@una@prueba”.

2. Crea una aplicación donde pidamos la ruta de un fichero por teclado y un texto que queramos a escribir en el fichero. Deberás mostrar por pantalla el mismo texto pero variando entre mayúsculas y minúsculas, es decir, si escribo “Bienvenido” deberá devolver “bIENVENIDO”. Si se escribe cualquier otro carácter, se quedara tal y como se escribió.

Deberás crear un método para escribir en el fichero el texto introducido y otro para mostrar el contenido en mayúsculas.

3. Crea una aplicación que pida la ruta de dos ficheros de texto y de una ruta de destino (solo la ruta, sin fichero al final). Debes copiar el contenido de los dos ficheros en uno, este tendrá el nombre de los dos ficheros separados por un guion bajo, este se guardara en la ruta donde le hayamos indicado por teclado.

Para unir los ficheros en uno, crea un método donde le pases como parámetro todas las rutas. En este método, aparte de copiar debe comprobar que si existe el fichero de destino, nos muestre un mensaje informándonos de si queremos sobrescribir el fichero. Te recomiendo usar la clase File y JOptionPane.

Por ejemplo, si tengo un fichero A.txt con “ABC” como contenido, un fichero B.txt con “DEF” y una ruta de destino D:\, el resultado sera un fichero llamado A_B.txt en la ruta D:\ con el contenido “ABCDEF”.

Puedes crear submétodos para realizar la copia de ficheros, piensa también como podrias optimizar esta copia, si los ficheros tuvieran mucho contenido.

Recuerda que debes controlar las excepciones que puedan aparecer. En caso de error, mostrar una ventana de dialogo con información del error
