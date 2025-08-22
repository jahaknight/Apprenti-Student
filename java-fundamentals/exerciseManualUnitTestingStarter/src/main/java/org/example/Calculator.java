package org.example;

public class Calculator {

    int[] numbers;

    public Calculator(){

    }

    public int add(int[] numbers){
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        this.numbers = numbers;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        return sum;
    }

    public int subtract(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return 0;
        }
        this.numbers = numbers;
        int sum = numbers[0];
        if (numbers.length > 1) {
            for (int i = 1; i < numbers.length; i++) {
                sum -= numbers[i];
            }
        }
        return sum;

    }
}
