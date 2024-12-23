import java.util.*;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {

        // Step 1: Count the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).boxed().forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));


        // Step 2: Use a min-heap to store the k most frequent elements
        // PriorityQueue is a min-heap by default in Java
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            // If the heap exceeds size k, remove the element with the smallest frequency
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            list.add(minHeap.poll().getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[] { 1,1,1,2,2,3 }, 2));
    }
}
