<display-name>: Esta etiqueta define el nombre descriptivo del proyecto web. En este caso, el nombre descriptivo es 
	"SimpleServletProject". Es utilizado para mostrar el nombre del proyecto en entornos web y herramientas relacionadas.

<servlet>: Esta etiqueta se utiliza para configurar un servlet en la aplicación web. Contiene información relacionada con 
	el servlet, como su nombre y clase.

<servlet-name>: Esta etiqueta especifica el nombre único del servlet. En el ejemplo, se utilizan los nombres 
	"simpleServlet" y "xmlServlet" para los servlets configurados.

<servlet-class>: Esta etiqueta define la clase Java que implementa el servlet. Indica la ubicación y el nombre de la 
	clase que contiene la lógica del servlet. En el ejemplo, se mencionan las clases 
	"org.codingdojo.tutorial.SimpleServlet" y "or.codingdojo.tutorial.XmlServlet" como las clases que implementan 
	los servlets "simpleServlet" y "xmlServlet", respectivamente.

<servlet-mapping>: Esta etiqueta se utiliza para mapear un servlet a un patrón de URL específico. Permite al servidor 
	web saber a qué servlet dirigir las solicitudes entrantes según el patrón de URL. Contiene información sobre el 
	nombre del servlet y el patrón de URL correspondiente.

<url-pattern>: Esta etiqueta especifica el patrón de URL al que se debe mapear el servlet. En el ejemplo, "simpleServlet" 
	se mapea al patrón de URL "/simpleServlet" y "xmlServlet" se mapea al patrón de URL "/xmlServletpath". Cuando se 
	recibe una solicitud con una URL que coincide con el patrón, el servlet correspondiente se invoca para manejar la 
	solicitud.

<welcome-file>: Esta etiqueta se utiliza para especificar el archivo de bienvenida para la aplicación web. Indica el 
	nombre del archivo que se debe cargar cuando se accede a la raíz de la aplicación. En el ejemplo, el archivo de 
	bienvenida es "index.html". Si se accede a la raíz de la aplicación, se cargará el archivo "index.html".