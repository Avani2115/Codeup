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
        if(s.length()==0)return 0;
        boolean word = false;
        int count=0;
        for(int i=0;i<s.length();i++){
            word=(s.charAt(i)!=' ');
            if(word && (i==0 || s.charAt(i-1)==' '))count++;
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
        int end = Math.min(start + length, s.length());
        s = s.substring(0, start) + s.substring(end);
        return s;
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
        if (s.isEmpty()) return '\0';
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
