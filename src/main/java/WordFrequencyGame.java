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

        List<Input> inputList = new ArrayList<>();
        for (String s : words) {
            Input input = new Input(s, 1);
            inputList.add(input);
        }

        Map<String, List<Input>> map = getListMap(inputList);

        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        inputList = list;

        inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
        return inputList;
    }


    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
