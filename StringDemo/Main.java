/**
 * @Filename - Main.java
 * @Description - Entry point of the application
 * @Author - Avani Shrimali
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        MyString a = new MyString(s);

        while (true) {
            System.out.println("\nChoose an operation:");
            String[] menu = {
                "Append another string",
                "Count number of words",
                "Replace a character",
                "Check if palindrome",
                "Splice (remove part of string)",
                "Split into words",
                "Find most repeated character",
                "Sort characters",
                "Shift characters (left rotation)",
                "Reverse string"
            };

            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("Program terminated.");
                break;
            }

            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String t = sc.nextLine();
                    System.out.println("Output: " + a.append(t));
                    break;
                case 2:
                    System.out.println("Total words: " + a.countWords());
                    break;
                case 3:
                    System.out.print("Character to replace: ");
                    char oldC = sc.nextLine().charAt(0);
                    System.out.print("Character to insert: ");
                    char newC = sc.nextLine().charAt(0);
                    System.out.println("Updated string: " + a.replace(oldC, newC));
                    break;
                case 4:
                    System.out.println("Palindrome: " + a.isPalindrome());
                    break;
                case 5:
                    System.out.print("Enter starting index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter number of characters to remove: ");
                    int len = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Result: " + a.splice(start, len));
                    break;
                case 6:
                    System.out.println("Words: " + Arrays.toString(a.split()));
                    break;
                case 7:
                    System.out.println("Most repeated character: " + a.maxRepeat());
                    break;
                case 8:
                    System.out.println("Sorted string: " + a.sort());
                    break;
                case 9:
                    System.out.print("Enter number of characters to shift: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Shifted string: " + a.shift(n));
                    break;
                case 10:
                    System.out.println("Reversed string: " + a.reverse());
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        sc.close();
    }
}
