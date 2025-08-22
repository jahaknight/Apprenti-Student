package org.example;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        //Method Level Variables
        Scanner scanner = new Scanner(System.in);
        String email = "";
        String errMsg = "";
        int pin = 0;
        int age = 0;
        //Handle Age Input
        while (true) {
            try {
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0){
                    throw new IllegalArgumentException("Age must be greater than 0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //Handle email input
        while( true) {
            try {
                System.out.println("Enter your email: ");
                email = scanner.nextLine();
                //Cant be empty or null
                if (email == null || email.trim().isEmpty()) {
                    //throw new IllegalArgumentException(("Email cannot be empty"));
                    errMsg +="Email cannot be empty";
                }
                // Must have @
                if (!email.contains("@")) {
                    //throw new IllegalArgumentException(("Email Must Contain @"));
                    errMsg += "\nEmail Must contain '@'.";
                }
                //must have decimal or Dot
                if (!email.contains(".")) {
                    //throw new IllegalArgumentException(("Email Must Contain '.'."));
                    errMsg += "\nEmail must contain '.'";
                }
                break;
                // Get Fancy Later


            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
                //Handle pin input
                while (true){
                    try{
                        System.out.print("Enter your 4-digit PIN: ");
                        String pinInput = scanner.nextLine();
                        if (!pinInput.matches("\\d{4}")){
                            throw new IllegalArgumentException("Pin must be 4 numeric digits!");
                        }
                        pin = Integer.parseInt(pinInput);
                        break;
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    } catch (Exception e){
                        System.out.println(e.toString());
                    }
                }
                //Print out variables
                System.out.println("\nRegistration Successful!");
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
                System.out.println("PIN: " + pin);
            }
        }


