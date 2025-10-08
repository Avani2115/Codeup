/**
 * @Filename - Main.java
 * @Description - Entry point of the application
 * @Author - Avani Shrimali
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in); // user input
        System.out.print("Enter a string: ");
        String s = user_input.nextLine();
        MyString a = new MyString(s);

        int choice;
        do {
            String operationsMenu = """
            
            Choose an operation:
            1. Append another string
            2. Count number of words
            3. Replace a character
            4. Check if palindrome
            5. Splice (remove part of string)
            6. Split into words
            7. Find most repeated character
            8. Sort characters
            9. Shift characters (left rotation)
            10. Reverse string
            0. Exit
            """;

            System.out.println(operationsMenu);
            System.out.print("Enter your choice: ");
            choice = user_input.nextInt();
            user_input.nextLine(); // consume newline

            System.out.println();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter string to append: ");
                    String t = user_input.nextLine();
                    System.out.println("Output: " + a.append(t));
                }
                case 2 -> System.out.println("Total words: " + a.countWords());
                case 3 -> {
                    System.out.print("Character to replace: ");
                    char oldC = user_input.nextLine().charAt(0);
                    System.out.print("Character to insert: ");
                    char newC = user_input.nextLine().charAt(0);
                    System.out.println("Updated string: " + a.replace(oldC, newC));
                }
                case 4 -> System.out.println("Palindrome: " + a.isPalindrome());
                case 5 -> {
                    System.out.print("Enter starting index: ");
                    int start = user_input.nextInt();
                    System.out.print("Enter number of characters to remove: ");
                    int len = user_input.nextInt();
                    user_input.nextLine();
                    System.out.println("Result: " + a.splice(start, len));
                }
                case 6 -> System.out.println("Words: " + Arrays.toString(a.split()));
                case 7 -> System.out.println("Most repeated character: " + a.getmaxRepeat());
                case 8 -> System.out.println("Sorted string: " + a.sort());
                case 9 -> {
                    System.out.print("Enter number of characters to shift: ");
                    int n = user_input.nextInt();
                    user_input.nextLine();
                    System.out.println("Shifted string: " + a.shift(n));
                }
                case 10 -> System.out.println("Reversed string: " + a.reverse());
                case 0 -> System.out.println("Program terminated.");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);

        user_input.close();
    }
}
