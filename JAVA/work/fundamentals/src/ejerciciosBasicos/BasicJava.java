package ejerciciosBasicos;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    
    public static void print1To255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }
    
    public static void printOddNumbers() {
        for (int i = 1; i <= 255; i += 2) {
            System.out.println(i);
        }
    }
    
    public static void printSum() {
        int sum = 0;
        for (int i = 0; i <= 255; i++) {
            sum += i;
            System.out.println("Nuevo número: " + i + " Suma: " + sum);
        }
    }
    
    public static void iterateArray(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
    }
    
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static double getAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }
    
    public static ArrayList<Integer> createOddArray() {
        ArrayList<Integer> oddArray = new ArrayList<>();
        for (int i = 1; i <= 255; i += 2) {
            oddArray.add(i);
        }
        return oddArray;
    }
    
    public static int countGreater(int[] arr, int y) {
        int count = 0;
        for (int num : arr) {
            if (num > y) {
                count++;
            }
        }
        return count;
    }
    
    public static void squareValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
    }
    
    public static void replaceNegatives(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
    }
    
    public static int[] minMaxAverage(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int sum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }
        
        int average = sum / arr.length;
        
        return new int[] { max, min, average };
    }
    
    public static void shiftValues(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }
    
    public static void main(String[] args) {
        print1To255();
        
        System.out.println("------------------------");
        
        printOddNumbers();
        
        System.out.println("------------------------");
        
        printSum();
        
        System.out.println("------------------------");
        
        int[] arr = { 1, 3, 5, 7, 9, 13 };
        iterateArray(arr);
        
        System.out.println("------------------------");
        
        int[] arr2 = { -3, -5, -7 };
        System.out.println("Max: " + findMax(arr2));
        
        System.out.println("------------------------");
        
        int[] arr3 = { 2, 10, 3 };
        System.out.println("Average: " + getAverage(arr3));
        
        System.out.println("------------------------");
        
        ArrayList<Integer> oddArray = createOddArray();
        System.out.println(oddArray);
        
        System.out.println("------------------------");
        
        int[] arr4 = { 1, 3, 5, 7 };
        int y = 3;
        System.out.println("Count: " + countGreater(arr4, y));
        
        System.out.println("------------------------");
        
        int[] arr5 = { 1, 5, 10, -2 };
        squareValues(arr5);
        System.out.println(Arrays.toString(arr5));
        
        System.out.println("------------------------");
        
        int[] arr6 = { 1, 5, 10, -2 };
        replaceNegatives(arr6);
        System.out.println(Arrays.toString(arr6));
        
        System.out.println("------------------------");
        
        int[] arr7 = { 1, 5, 10, -2 };
        int[] result = minMaxAverage(arr7);
        System.out.println("Max: " + result[0] + " Min: " + result[1] + " Average: " + result[2]);
        
        System.out.println("------------------------");
        
        int[] arr8 = { 1, 5, 10, 7, -2 };
        shiftValues(arr8);
        System.out.println(Arrays.toString(arr8));
    }
}
