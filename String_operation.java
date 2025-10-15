import java.util.*;

public class String_operation {
    static class StringOp {
        String s;

        StringOp(String str) {
            this.s = str;
        }

        String append(String t) {
            char[] res = new char[s.length() + t.length()];
            int k = 0;
            for (int i = 0; i < s.length(); i++) res[k++] = s.charAt(i);
            for (int i = 0; i < t.length(); i++) res[k++] = t.charAt(i);
            return new String(res);
        }

        int countWords() {
            int count = 0;
            boolean inWord = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ' && !inWord) {
                    count++;
                    inWord = true;
                } else if (s.charAt(i) == ' ') {
                    inWord = false;
                }
            }
            return count;
        }

        String replace(char a, char b) {
            char[] x = s.toCharArray();
            for (int i = 0; i < x.length; i++) {
                if (x[i] == a) x[i] = b;
            }
            return new String(x);
        }

        boolean isPalindrome() {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }

        String splice(int start, int length) {
            if (start < 0 || start >= s.length() || length <= 0) return s;
            int end = start + length;
            if (end > s.length()) end = s.length();
            char[] res = new char[s.length() - (end - start)];
            int k = 0;
            for (int i = 0; i < start; i++) res[k++] = s.charAt(i);
            for (int i = end; i < s.length(); i++) res[k++] = s.charAt(i);
            return new String(res);
        }

        String[] split() {
            int words = countWords();
            String[] arr = new String[words];
            int i = 0, idx = 0;
            while (i < s.length()) {
                while (i < s.length() && s.charAt(i) == ' ') i++;
                if (i >= s.length()) break;
                int j = i;
                while (j < s.length() && s.charAt(j) != ' ') j++;
                char[] temp = new char[j - i];
                for (int k = i, t = 0; k < j; k++, t++) temp[t] = s.charAt(k);
                arr[idx++] = new String(temp);
                i = j;
            }
            return arr;
        }

        char maxRepeat() {
            if (s.length() == 0) return '\0';
            int[] freq = new int[256];
            int max = 0;
            char res = s.charAt(0);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                freq[c]++;
                if (freq[c] > max) {
                    max = freq[c];
                    res = c;
                }
            }
            return res;
        }

        String sort() {
            char[] a = s.toCharArray();
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        char t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                    }
                }
            }
            return new String(a);
        }

        String shift(int n) {
            if (s.length() == 0) return s;
            n = n % s.length();
            char[] res = new char[s.length()];
            int k = 0;
            for (int i = n; i < s.length(); i++) res[k++] = s.charAt(i);
            for (int i = 0; i < n; i++) res[k++] = s.charAt(i);
            return new String(res);
        }

        String reverse() {
            char[] x = s.toCharArray();
            int i = 0, j = x.length - 1;
            while (i < j) {
                char temp = x[i];
                x[i] = x[j];
                x[j] = temp;
                i++;
                j--;
            }
            return new String(x);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        StringOp a = new StringOp(s);

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
