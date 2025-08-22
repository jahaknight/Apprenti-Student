package org.example;

public class CalculatorTest {

    public static void main(String[] args){
        // Set up
        Calculator testCalculator = new Calculator();
        int[] numbers;
        int result;

        //Test
        System.out.println("******TESTING ADDITION******");
        //1. Add Two Numbers
        numbers = new int[] {4,4};
        result = testCalculator.add(numbers);
        if (result == 8){
            System.out.println("TEST PASS: 4+4 equals 8" + result);
        } else {
            System.out.println("TEST FAIL: 4+4 resolved to" + result);
        }

        //2. Add 4 Numbers
        numbers = new int[] {5,5,5,5};
        result = testCalculator.add(numbers);
        if (result == 20){
            System.out.println("TEST PASS: 5+5+5+5 equals " + result);
        } else {
            System.out.println("TEST FAIL: 5+5+5+5  resolved to" + result);
        }

        //3. Add one number
        numbers = new int[] {10};
        result = testCalculator.add(numbers);
        if (result == 10){
            System.out.println("TEST PASS: 10 only equals " + result);
        } else {
            System.out.println("TEST FAIL: 10 resolved to" + result);
        }


        //4. Add Null
        numbers = null;
        result = testCalculator.add(numbers);
        if (result == 0){
            System.out.println("TEST PASS: NULL returns " + result);
        } else {
            System.out.println("TEST FAIL: NULL returns" + result);
        }

        //5. Add Zeroes
        numbers = new int[] {0,0};
        result = testCalculator.add(numbers);
        if (result == 0){
            System.out.println("TEST PASS: 0+0 equals " + result);
        } else {
            System.out.println("TEST FAIL: 0+0 resolved to" + result);
        }

        // Add empty array
        int[] emptyArray = new int[]{};
        result = testCalculator.add(emptyArray);
        if (result == 0){
            System.out.println("TEST PASS: Empty Array equals " + result);
        } else {
            System.out.println("TEST FAIL: Empty Array resovled to " + result);
        }

        System.out.println("******TESTING SUBTRACTION******");
        //5. Subtract Two Numbers
        numbers = new int[] {8,4};
        result = testCalculator.subtract(numbers);
        if (result == 4) {
            System.out.println("TEST PASS: 8-4 equals " + result);
        } else {
            System.out.println("TEST FAIL: 8-4 resolved to" + result);
        }


        //6. Subtract 4 Numbers
        numbers = new int[] {25,5,5,5};
        result = testCalculator.subtract(numbers);
        if (result == 10) {
            System.out.println("TEST PASS: 25-5-5-5 equals " + result);
        } else {
            System.out.println("TEST FAIL: 25-5-5-5 resolved to" + result);
        }

        //7. Subtract one number
        numbers = new int[] {10};
        result = testCalculator.subtract(numbers);
        if (result == 10){
            System.out.println("TEST PASS: 10 only equals " + result);
        } else {
            System.out.println("TEST FAIL: 10 only resolved to" + result);
        }

        //8. Subtract Null
        numbers = null;
        result = testCalculator.subtract(numbers);
        if (result == 0){
            System.out.println("TEST PASS: NULL returns " + result);
        } else {
            System.out.println("TEST FAIL: NULL returns" + result);
        }

        //9/ Subtract Zeros
        numbers = new int[] {0,0};
        result = testCalculator.subtract(numbers);
        if (result == 0){
            System.out.println("TEST PASS: 0-0 equals " + result);
        } else {
            System.out.println("TEST FAIL: 0-0 resolved to" + result);
        }

        // Empty Array
        emptyArray = new int[]{};
        result = testCalculator.subtract(emptyArray);
        if (result == 0){
            System.out.println("TEST PASS: Empty Array equals " + result);
        } else {
            System.out.println("TEST FAIL: Empty Array  resolved to " + result);
        }
        //Tear Down
        // All Variables in scope are destroyed by GC

    }
}
