import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static String frequencySort(String str) {
        // Step 1: Count the frequency of each character using HashMap
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create a max-heap (priority queue) based on frequency of characters
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (entry1, entry2) ->  entry2.getValue() - entry1.getValue());

        // Add all entries to the heap
        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: Build the result string by extracting characters from the heap
        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            // Append the character 'entry.getValue()' times to the result
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
    }
}
