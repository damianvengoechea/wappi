# wappi
Pruebas Automatizadas a la aplicación Wappi

Estrategia de automatización
Inicialmente se levantaron los flujos de cada transacción, para conocer el comportamiento y tener claro que se debía automatizar, una vez claro el alcance se procede con la automatización de las transacciones definidas.
Se automatizará el flujo de:
•	Actualizar información
•	Validar el modal de artículos
•	Realizar el pedido Sin cupón de descuento
•	Realizar el pedido Con cupón de descuento
•	Validar que el cupón solo se pueda usar 2 veces

En el proyecto se usó el framework serenity BDD junto con screenplay,  cucumber, gherkin y gradle.
Donde los tests usan el siguiente arquetipo:
• tasks Clases que representan tareas que realiza el actor a nivel de proceso de negocio 
• interacción Clases que representan las interacciones directas con la interfaz de usuario
• user_interface Page Objects. Mapean los objetos de la interfaz de usuario
• questions Objectos usados para consultar acerca del estado de la aplicación

Herramientas utilizadas
Lenguaje de programación: Java.
Frameworks: Selenium, Junit, cucumber y Serenity BDD.
Patrón de diseño: Screenplay.
Features: Hechos en lenguaje Gherkin.
IDE: Intellij Idea
Driver: ChromeDriver 2.39.562718 
Navegador: Google Chrome 
Versión 84.0.4147.135 (Build oficial) (64 bits)
Manejo de dependencias con Gradle

Para ejecutar la automatización copiamos la siguiente línea de comando dentro del CMD y damos enter:
gradlew clean test --tests com.wappi.runners* --info aggregate
Nota: Tener en cuenta la ruta donde se clona el proyecto para configurar el chromeDriver y  para cambiar en el escenario de actualizar información la ruta de la imagen por la donde quede el proyecto
Para su ejecución también debemos estar ubicados en la carpeta del proyecto
Para visualizar el reporte de serenity después de la ejecución se pueden dirigir a la carpeta target\site\serenity\index.html 
