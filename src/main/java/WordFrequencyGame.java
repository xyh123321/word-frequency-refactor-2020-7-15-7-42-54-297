import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

        List<Input> wordsFrequency = caluWordsFrequency(inputStr);

        return formatWordsFrequency(wordsFrequency);
    }

    private String formatWordsFrequency(List<Input> inputList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : inputList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private List<Input> caluWordsFrequency(String inputStr) {
        String[] words = inputStr.split("\\s+");

        List<String> wordList = Arrays.asList(words);
        List<Input> list = new ArrayList<>();
        for (String word: new HashSet<>(wordList)) {
            int count = Collections.frequency(wordList, word);
            list.add(new Input(word, count));
        }


        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
        return list;
    }

}
