import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MostCommonWords {
// 819. Most Common Word
public String mostCommonWord(String paragraph, String[] banned) {

        List<String> bannedList = Arrays.asList(banned);

        String [] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().trim().split("\\s+");


        HashMap<String, Integer> wordCounts = new HashMap<>();

        String maxWord = "";
        int maxCount = Integer.MIN_VALUE;

        for (String word : words) {

            if (!bannedList.contains(word)) {

                if (wordCounts.containsKey(word)) {

                    int count = wordCounts.get(word);

                    if (count > maxCount) {
                        maxCount = count;
                        maxWord = word;
                    }

                    wordCounts.replace(word, ++count);
                } else {
                    wordCounts.put(word, 0);
                }
            }
        }


        if (maxWord.equals("")) {
            for (String word : words) {
                if (!bannedList.contains(word))
                    maxWord = word;
            }

        }


        return maxWord;
    }
}
