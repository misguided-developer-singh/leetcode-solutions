import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Record {
    String value;
    int timestamp;

    public Record(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

public class TimeBasedKeyValueStore {
    Map<String, List<Record>> map;

    public TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Record> listOfRecords = map.getOrDefault(key, new ArrayList<>());
        listOfRecords.add(new Record(value, timestamp));
        map.put(key, listOfRecords);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }

    private String binarySearch(List<Record> list, int timestamp) {
        int left = 0, right = list.size() - 1;

        if(timestamp < list.get(left).timestamp) return "";
        if(timestamp > list.get(right).timestamp) return list.get(right).value;

        String answer = "";
        while(left <= right) {
            int mid = left + (right-left) / 2;
            if(list.get(mid).timestamp == timestamp) return list.get(mid).value;
            else if (list.get(mid).timestamp < timestamp) {
                answer = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
       return answer;
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1)); // bar
        System.out.println(obj.get("foo", 3)); // bar

        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4)); // bar2
        System.out.println(obj.get("foo", 5)); // bar2
        System.out.println(obj.get("foo", 2)); // bar

        System.out.println(obj.get("foo", -2)); // ""
    }
}
