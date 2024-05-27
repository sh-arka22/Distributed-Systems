import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        // Input data
        Map<String, String> input = new HashMap<>();
        input.put("file1.txt", "hello world");
        input.put("file2.txt", "hello mapreduce");
        input.put("file3.txt", "hello hello world");

        // Mapper phase
        Mapper mapper = new Mapper();
        List<KeyValuePair> mappedData = new ArrayList<>();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            mappedData.addAll(mapper.map(entry.getKey(), entry.getValue()));
        }

        // Shuffle and Sort phase
        Map<String, List<String>> groupedData = new HashMap<>();
        for (KeyValuePair pair : mappedData) {
            groupedData.computeIfAbsent(pair.getKey(), k -> new ArrayList<>()).add(pair.getValue());
        }

        // Reducer phase
        Reducer reducer = new Reducer();
        List<KeyValuePair> reducedData = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : groupedData.entrySet()) {
            reducedData.addAll(reducer.reduce(entry.getKey(), entry.getValue()));
        }

        // Output the results
        for (KeyValuePair pair : reducedData) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }
}
