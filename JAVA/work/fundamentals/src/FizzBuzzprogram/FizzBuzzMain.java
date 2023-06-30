package FizzBuzzprogram;
public class FizzBuzzMain {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        
        // Prueba con diferentes números
        System.out.println(fizzBuzz.fizzBuzz(3));   // Fizz
        System.out.println(fizzBuzz.fizzBuzz(5));   // Buzz
        System.out.println(fizzBuzz.fizzBuzz(15));  // FizzBuzz
        System.out.println(fizzBuzz.fizzBuzz(2));   // 2
    }
}
