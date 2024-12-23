import java.util.HashSet;
import java.util.Set;

/*

    Time Complexity: O(n + m)
        where n is the length of the string s and m is the number of spaces in the spaces array.
    Space Complexity: O(n + m)
        where n is the length of the string s and m is the number of spaces in the spaces array.
 */

public class AddingSpacesToAString {

    public static String addSpaces(String str, int[] spaces) {
        // Convert the spaces array to a set for quick lookup
        Set<Integer> spaceSet = new HashSet<>();
        for(int index : spaces) {
            spaceSet.add(index);
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(spaceSet.contains(i)) {
                result.append(' ');
            }
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        String str = "EnjoyYourCoffee";
//        int[] spaces = {5, 9};

        String str = "spacing"; int[]  spaces = { 1,2,3,4,5,6 };

        System.out.println(addSpaces(str, spaces));
    }
}
