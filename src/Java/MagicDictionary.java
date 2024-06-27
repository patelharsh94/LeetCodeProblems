import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 676. Implement Magic Dictionary
public class MagicDictionary {

        HashMap<Integer, ArrayList<String>> wordAndLengthDict = new HashMap<>();

        /** Initialize your data structure here. */
        public MagicDictionary() {

        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {

            for (String word : dict) {
                ArrayList<String> wordList = wordAndLengthDict.get(word.length());

                if (wordList != null) {
                    wordList.add(word);
                } else {
                    wordList = new ArrayList<>();
                    wordList.add(word);
                }

                wordAndLengthDict.put(word.length(), wordList);
            }

            System.out.println("List: " + wordAndLengthDict);

        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {

            System.out.println("word: " + word);
            List<String> words = wordAndLengthDict.get(word.length());
            int diff = 0;

            if (words != null) {
                for (String wordsFromMap: words) {
                    int i = 0;
                    diff = 0;
                    for (char c : wordsFromMap.toCharArray()) {
                        if (c != word.charAt(i))
                            diff++;

                        if (diff > 1)
                            break;
                        i++;
                    }

                    if (diff == 1)
                        return true;
                }
            }

            System.out.println("result: " + (diff == 1));

            return diff == 1;
        }
}

/*
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

