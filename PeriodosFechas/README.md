## Autor: _Juan Leopoldo Emiliani_
## Correo: _jemiliani@gmail.com_
## Vía: Me contacto el serñor _Leonardo Miranda Pavez_



###INSTRUCCIONES PARA COMPILAR Y EJECUTAR DESDE EL IDE 

*1. Una vez descargado los fuentes desde el IDE eclipse o STS, nos dirigimos a la opcion _File_ y en ella la opcion _import.._.
*2. Seleccionamos la carpeta _Maven_ y luego la opcion _Existing Maven Projects_ luego damos al boton _Next_
*3. Seleccionamos la ruta donde estan los fuentes descargados la caperta _PeriodosFechas_ donde se encuentra el *pom*
*4. Una vez que tenemos el proyecto en nuestro IDE, damos boton derecho sobre el proyecto (_PeriodosFechas_), en la opcion _Maven_ ejecutamos la 
    opcion _Update Project_ para que actualice las dependencias indicadas en el pom.
*5. Una vez hecho esto, en el menú _Run_ seleccionamos _Run Configurations_
*6. En el menu izquierdo seleccionamos Maven Build -> New_configuration
*7. Dejando lo siguiente Base directory ${workspace_loc:/PeriodosFechas} Goals clean package
*8. En el mismo menu izquierdo, ahora Java Application -> Principal 
*9. En la pestaña *Arguments* colocamos los siguientes argumentos C:\ruta\..\< nombre_archivo_entrada.json> C:\ruta\..\< nombre_archivo_salida.json>
*10. Seleccionamos el boton *Run*

###INSTRUCCIONES PARA EJECUTAR DESDE LA CONSOLA (CMD)

*1. Nos pocicionamos en la ruta donde se encuentra el jar Ej: unidad:\..\PeriodosFechas\target
*2. Dentro de target se dejo la carpeta libs con las librerias utilizadas.
*3. En el jar se encuentra el archivo MANIFESt que posee las dependencias a estas librerias.
*4. Ejecutamos el siguiente comando *java -jar PeriodosFechas0.0.1-SNAPSHOT.jar <ruta/nombre_archivo_entrada.json> <ruta/nombre_archivo_salida.json>*
*5. El resultado se encontrará en ####*<ruta/nombre_archivo_salida.json>*