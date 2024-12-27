
public class ValidPalindrome {
    public static boolean isPalindrome(String str) {
        int left = 0; int right = str.length() - 1;

        while(left < right) {
            // Move left pointer if it's not alphanumeric
            if(!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
                // Move right pointer if it's not alphanumeric
            } else if (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            } else {
                if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                    return false;
                }
                left++; right--;
            }
        }
        return true;    // If the entire string is traversed and no mismatches were found
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); //true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome("1a2b3b2a1")); // true
    }
}
