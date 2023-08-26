package edu.miu.cs.cs425.demos.studentrecordsmgmtapp;

public class Main {
    public static void main(String[] args) {
//        int[] numbers = {10,14,35,5,49,10};
//        printHelloWorld(numbers);

        int[] num1 = {1,2,3,4,5};
        System.out.println("Second biggest: " +findSecondBiggest(num1));

        int[] num2 = {19,9,11,0,12};
        System.out.println("Second biggest: "+ findSecondBiggest(num2));
    }

    public  static void printHelloWorld(int[] numbers){
        for(int num:numbers){
            if(num%5 == 0 && num %7==0){
                System.out.println("Hello World");
            }else if(num%5 == 0){
                System.out.println("Hello");
            }else if(num%7 ==0){
                System.out.println("World");
            }else{
                System.out.println(num);
            }
        }
    }

    public  static int findSecondBiggest(int[] numbers){
        if(numbers.length < 2){
            throw new IllegalArgumentException("Array must have at least two items");
        }

        int biggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for(int num: numbers){
            if(num>biggest){
                secondBiggest = biggest;
                biggest = num;
            }else if(num> secondBiggest && num < biggest){
                secondBiggest = num;
            }
        }

        return secondBiggest;
    }
}