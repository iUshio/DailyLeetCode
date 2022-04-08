package dailyPromblem;

import java.util.*;

public class s692 {

    public List<String> topKFrequent(String[] words, int k) {
        // cnt存储单词出现的个数
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        // 将非重复的单词存储进res中
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }

        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                // 检索word1和word2出现次数是否相同，若相同则字典排序，不同则降序
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }

}
