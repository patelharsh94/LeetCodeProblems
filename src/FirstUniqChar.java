import java.util.HashMap;

public class FirstUniqChar {

    public int firstUniqChar(String s) {
        HashMap<Character, uniqueCharData> characteruniqueCharDataHashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (characteruniqueCharDataHashMap.containsKey(c))
                characteruniqueCharDataHashMap.get(c).incrementCount();
            else
                characteruniqueCharDataHashMap.put(c, new uniqueCharData(c));
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characteruniqueCharDataHashMap.get(c).totalCount == 1)
                return i;
        }

        return -1;
    }
}

class uniqueCharData {
    char c;
    int totalCount;

    public uniqueCharData(char c) {
        totalCount = 1;
        this.c = c;
    }

    public void incrementCount() {
        this.totalCount++;
    }
}
