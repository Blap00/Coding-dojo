package testingClass;

import java.util.Arrays;

public class BasicJavaMain {
    public static void main(String[] args) {
        BasicJava bj = new BasicJava();
        int[] numb = {1, 2, 14, 7, -10};
        bj.setNumber(numb);
        System.out.println(bj.getPrint255());
        System.out.println(bj.getOddNumbers());
        System.out.println(bj.getCountGreater());
        System.out.println(bj.getSquareValues());
        System.out.println(bj.getReplaceNegatives());	
        System.out.println(Arrays.toString(bj.getNumberCopyII()));
//        System.out.println(bj.getMinMaxAverage());
    }
}