Pasos para ejecutar;
en la terminal, powershell o CMD, ejecuta el siguiente comando

    - JAVA .\Pitagoras.java

¿Que utilizamos para crear los .class?
    En la consola ejecutamos

    - JAVAC -\Pitagoras.java
    - JAVAC -\PitagorasTest.java

ERRORES; Necesito retroalimentacion, esto debido a un error al intentar crear el archivo class, aparece lo siguiente; 

PS C:\sts\work\fundamentals\src\TeoremaDePitagoras> javac .\Pitagoras.java
.\Pitagoras.java:8: 
    error: cannot find symbol
        PitagorasTest pitagorastest = new PitagorasTest();
        ^
  symbol:   class PitagorasTest
  location: class Pitagoras
.\Pitagoras.java:8: error: cannot find symbol
        PitagorasTest pitagorastest = new PitagorasTest();
                                          ^
  symbol:   class PitagorasTest
  location: class Pitagoras
2 errors
PS C:\sts\work\fundamentals\src\TeoremaDePitagoras> javac .\PitagorasTest.java
PS C:\sts\work\fundamentals\src\TeoremaDePitagoras> 
