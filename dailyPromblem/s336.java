package dailyPromblem;

import java.util.*;

public class s336 {
    // 暴力破解（超时）
    public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(words[i] + words[j])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
                if (check(words[j] + words[i])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    private boolean check(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // 构建字典树
    List<String> wordsRev = new ArrayList<String>();
    Map<String, Integer> indices = new HashMap<String, Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        // 将单词的翻转存入词典中
        for (String word : words) {
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; ++i) {
            indices.put(new StringBuffer(words[i]).reverse().toString(), i);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            // 单词长度
            int m = words[i].length();
            if (m == 0) {
                continue;
            }

            // j为m是为了保证单词前后拼接即[0,1]，[1,0]的情况存在
            for (int j = 0; j <= m; j++) {
                // 如果j到单词末尾是回文字符串，则查看单词表中是否有0,j - 1的翻转的字符串
                if (isPalindrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    // 判断单词是否是回文字符串
    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }

}
