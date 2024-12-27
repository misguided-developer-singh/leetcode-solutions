import java.util.*;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count the frequency of each word
        Map<String, Integer> frquencyMap = new HashMap<>();
        Arrays.stream(words).forEach(word ->
                frquencyMap.put(word, frquencyMap.getOrDefault(word, 0) + 1));

        // Step 2: Use a priority queue to store the words by frequency and lexicographical order
        PriorityQueue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((entry1, entry2) ->
                        entry1.getValue() == entry2.getValue() ?
                                entry1.getKey().compareTo(entry2.getKey()) : entry2.getValue() - entry1.getValue());

        // Add all words to the max-heap
        for(Map.Entry<String, Integer> entry : frquencyMap.entrySet()) {
            maxHeap.offer(entry);
        }

        // Step 3: Extract the top k frequent words
        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(maxHeap.poll().getKey()); // Poll the word with the highest frequency
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = { "coding", "i","love","leetcode","i","love","coding" };
        System.out.println(topKFrequent(words, 2));

    }
}
