/**
 * @Filename - MyString.java
 * @Description - Performs basic string operations
 * @Author - Avani Shrimali
 */
public class MyString {
    private String s = "Avani"; // always initialize with something

    public MyString(String value) {
        this.s = value;
    }

    public String append(String t) {
        s += t;
        return s;
    }

    public int countWords() {
        if (s.length() == 0) return 0;
        boolean word = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            word = (s.charAt(i) != ' ');
            if (word && (i == 0 || s.charAt(i - 1) == ' ')) count++;
        }
        return count;
    }

    public String replace(char oldChar, char newChar) {
        char[] chars = MyUtils.toCharArray(s);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == oldChar) chars[i] = newChar;
        }
        return new String(chars);
    }

    public boolean isPalindrome() {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public String splice(int start, int length) {
        if (start < 0 || start >= s.length() || length <= 0) return s;
        int end = MyUtils.min(start + length, s.length());
        s = s.substring(0, start) + s.substring(end);
        return s;
    }

    public String[] split() {
        int words = countWords();
        String[] arr = new String[words];
        int left = 0, idx = 0;

        while (left < s.length()) {
            while (left < s.length() && s.charAt(left) == ' ') left++;
            if (left >= s.length()) break;

            int right = left;
            while (right < s.length() && s.charAt(right) != ' ') right++;

            char[] temp = new char[right - left];
            for (int k = left, t = 0; k < right; k++, t++) temp[t] = s.charAt(k);

            arr[idx++] = new String(temp);
            left = right;
        }
        return arr;
    }

    public char getmaxRepeat() {
        if (s.length() == 0) return '\0';
        int[] freq = new int[256];
        int max = 0;
        char result = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c]++;
            if (freq[c] > max) {
                max = freq[c];
                result = c;
            }
        }
        return result;
    }

    public String sort() {
        char[] arr = MyUtils.toCharArray(s);
        for (int left = 0; left < arr.length - 1; left++) {
            for (int right = left + 1; right < arr.length; right++) {
                if (arr[left] > arr[right]) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }
        }
        s = new String(arr);
        return s;
    }

    public String shift(int n) {
        if (s.length() == 0) return s;
        n = ((n % s.length()) + s.length()) % s.length(); // handle negative shift
        s = s.substring(n) + s.substring(0, n);
        return s;
    }

    public String reverse() {
        char[] arr = MyUtils.toCharArray(s);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        s = new String(arr);
        return s;
    }

    @Override
    public String toString() {
        return s;
    }
}
