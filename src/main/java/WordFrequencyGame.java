import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

        List<Input> inputList = caluWordsFrequency(inputStr);

        return formatWordsFrequency(inputList);
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

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : words) {
            if(wordsMap.containsKey(word)){
                wordsMap.put(word, wordsMap.get(word)+1);
            }else{
                wordsMap.put(word, 1);
            }
        }

        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue());
            list.add(input);
        }

        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
        return list;
    }

}
