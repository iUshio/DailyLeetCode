package dailyPromblem;

import java.util.*;

public class s140 {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDList = new LinkedList<>();

        wordDList.add("cat");
        wordDList.add("cats");
        wordDList.add("and");
        wordDList.add("sand");
        wordDList.add("dog");

        String s2 = "pineapplepenapple";
        List<String> wordDList2 = new LinkedList<>();
        wordDList2.add("apple");
        wordDList2.add("pen");
        wordDList2.add("applepen");
        wordDList2.add("pine");
        wordDList2.add("pineapple");

        List<String> test = wordBreak(s2, wordDList2);
        for (String a : test) {
            System.out.println(a);
        }
    }

    static StringBuilder sb = new StringBuilder();
    static List<String> res = new LinkedList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        // 使用哈希表存储词典方便后续查找
        Set<String> set = new HashSet<>();

        for (String a : wordDict) {
            set.add(a);
        }

        backtrace(s.toCharArray(), 0, set);

        return res;
    }

    private static void backtrace(char[] str, int left, Set set) {
        // 单次循环完毕，将结果添加进去
        if (left >= str.length) {
            res.add(sb.toString());
            return;
        }

        StringBuilder word = new StringBuilder();

        // 逐个添加字母，查询词典中是否有该单词，如果有则添加到结果sb中
        // 并从下一个开始重新查找单词，遍历完后从结果sb中删除本次找到的单词
        // 如果没有，则不进行其他操作，继续往后面遍历
        for (int i = left; i < str.length; i++) {
            word.append("" + str[i]);
            // 查询是否有这个单词
            if (set.contains(word.toString())) {
                // 将单词拼接上
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(word);

                backtrace(str, i + 1, set);

                // 从sb中删除word
                sb.delete(sb.length() - word.length(), sb.length());
                // 删除空格
                if (sb.length() > 0)
                    sb.delete(sb.length() - 1, sb.length());
            }
        }
    }
}
