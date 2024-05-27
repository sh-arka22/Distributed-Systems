import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Reducer {
    public List<KeyValuePair> reduce(String key, List<String> values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        List<KeyValuePair> result = new ArrayList<>();
        result.add(new KeyValuePair(key, String.valueOf(sum)));
        return result;
    }
}
