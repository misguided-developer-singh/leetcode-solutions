import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String str) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // Step 2: Find the first character with a frequency of 1
        for(int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == 1) return i; // Return the index of the first non-repeating character
        }
        return -1;
    }

    public static int firstUniqCharV2(String str) {

        // Step 1: Create an array to store the frequency of each character
        int[] freq = new int[26];

        // Count the frequency of each character
         for(char ch : str.toCharArray()) {
             freq[ch - 'a']++;
         }

         // Step 2: Find the first character with a frequency of 1
         for(int i = 0; i < str.length(); i++) {
             if(freq[str.charAt(i) - 'a'] == 1) return i; // Return the index of the first non-repeating character
         }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode")); // 0
        System.out.println(firstUniqChar("loveleetcode")); // 2

        System.out.println(firstUniqCharV2("leetcode")); // 0
        System.out.println(firstUniqCharV2("loveleetcode")); // 2
    }
}
