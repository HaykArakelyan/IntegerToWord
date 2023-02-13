//package com.example.integertoword;
//
//import java.util.Scanner;
//
//public class IntToEng {
//    private static final String[] ONES = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
//            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
//    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
//    private static final String[] THOUSANDS = {"", "thousand", "million", "billion"};
//
//    public static String numberToWords(int number) {
//        String words = "";
//        int i = 0;
//
//        if (number == 0) {
//            return "zero";
//        }
//        while (number > 0) {
//            if (number % 1000 != 0) {
//                words = recursiveDivision(number % 1000) + THOUSANDS[i] + " " + words;
//            }
//            number /= 1000;
//            i++;
//        }
//        return words;
//    }
//
//    private static String recursiveDivision(int number) {
//        if (number == 0) {
//            return "";
//        } else if (number < 20) {
//            return ONES[number] + " ";
//        } else if (number < 100) {
//            return TENS[number / 10] + " " + recursiveDivision(number % 10);
//        } else {
//            return ONES[number / 100] + " hundred " + recursiveDivision(number % 100);
//        }
//    }
//
//    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        System.out.print("Enter a number: ");
////        int num = sc.nextInt();
////        System.out.println(EngToInt.numberToWords(num));
//    }
//
//}