
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String str) {
        int left = 0, right = 0; int result = 0;
        Set<Character> set = new HashSet<>();

        while(right < str.length()) {
            if(!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                right++;
                result = Math.max(set.size(), result);
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
