public class ReverseWords {

    public static String reverseWords(String sentence) {

        StringBuilder word = new StringBuilder();
        StringBuilder newSentence = new StringBuilder();
        sentence = sentence.replaceAll(" +", " ");
        char [] sentenceChars = sentence.toCharArray();

        for (int i = 0; i < sentenceChars.length; i++) {
            char c = sentenceChars[i];

            if (c == ' ') {
                newSentence.insert(0, " ");
                newSentence.insert(0, word);
                word = new StringBuilder();
            } else {
                word.append(c);
            }
        }
        newSentence.insert(0, " ");
        newSentence.insert(0, word);

        return newSentence.toString().trim();
    }
}
