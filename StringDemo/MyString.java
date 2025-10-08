/**
 * @Filename - MyString.java
 * @Description - Performs basic string operations
 * @Author - Avani Shrimali
 */
public class MyString {
    private String s;

    MyString(String value) {
        this.s = value;
    }

    String append(String t) {
        s += t;
        return s;
    }

    int countWords() {
        if (s.trim().isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }

    String replace(char a, char b) {
        s = s.replace(a, b);
        return s;
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
        int end = Math.min(start + length, s.length());
        s = s.substring(0, start) + s.substring(end);
        return s;
    }

    String[] split() {
        return s.trim().split("\\s+");
    }

    char maxRepeat() {
        if (s.isEmpty()) return '\0';
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
        s = new String(a);
        return s;
    }

    String shift(int n) {
        if (s.isEmpty()) return s;
        n = ((n % s.length()) + s.length()) % s.length(); // handle negative shift
        s = s.substring(n) + s.substring(0, n);
        return s;
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
        s = new String(x);
        return s;
    }

    @Override
    public String toString() {
        return s;
    }
}
