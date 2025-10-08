/**
 * @Filename - MyUtils.java
 * @Description - Custom utility class for basic operations
 * @Author - Avani Shrimali
 */
public class MyUtils {

    // Custom min and max functions
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Custom toCharArray implementation
    public static char[] toCharArray(String str) {
        int length = str.length();
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }
}
