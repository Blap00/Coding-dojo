// Clase de prueba PitagorasTest
public class PitagorasTest {
    //"Crear el metodo que llamaremos en Pitagoras.java"
    public double calcularHipotenusa(int catetoA, int catetoB) {
        //Crear variable que calcule la Hipotenusa segun los catetos, segun la formula de pitagoras
        double hipotenusa = Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));
        //retorna el valor
        return hipotenusa;
    }
}
