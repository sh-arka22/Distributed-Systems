import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public List<KeyValuePair> map(String key, String value) {
        List<KeyValuePair> result = new ArrayList<>();
        String[] words = value.split("\\s+");
        for (String word : words) {
            result.add(new KeyValuePair(word, "1"));
        }
        return result;
    }
}

class KeyValuePair {
    private String key;
    private String value;

    public KeyValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
