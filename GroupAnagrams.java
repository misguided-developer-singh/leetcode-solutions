import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<>();
        if(strs == null) return rst;

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = getKey(str);
//            System.out.println("key = " +key);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for(List<String> list : map.values()) rst.add(list);

        return rst;
    }

    private static String getKey(String str) {
        int[] count = new int[26];

        for(char ch: str.toCharArray()) {
            count[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(count[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] { "eat","tea","tan","ate","nat","bat" }));
    }

}
