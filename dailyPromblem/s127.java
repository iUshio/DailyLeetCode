package dailyPromblem;

import java.util.*;

public class s127 {
    // 此题参考力扣liweiwei大佬的解题😍
    // 思路：将所有单词放入一个哈希表中，便于后续进行比对
    // 比对单词是否相差一个字母的方法：枚举该单词变一个字母的所有情况，判断该情况是否在哈希表（wordId）中
    // 进行广度搜索：以step为索引，判断走step步最多能到哪个位置，每走一步进行一次字母判定，最后走到endWord则结束

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        // 这一步可以不同，题目有约束条件
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
     *
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
            Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，然后恢复
            char originChar = charArray[i];
            // 遍历改变一个字母的每一种情况
            for (char k = 'a'; k <= 'z'; k++) {
                // 如果改变的字母是原字母直接跳过
                if (k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    // 如果走到了endWord可以直接结束了
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    // 如果走到的不是endWord则需要继续往下走
                    // 该步只是列举再往下走一步的所有可能性，step只会加一
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }
}
