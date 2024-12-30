
public class ValidPalindromeII {

    public static boolean validPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                // Try skipping either left or right character
                return isPalindrome(str, left+1, right) || isPalindrome(str, left, right-1);
            }
            left++; right--;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++; right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("racecar"));
    }
}
