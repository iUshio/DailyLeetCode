package dailyPromblem;

public class s134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
    
        // 寻找最低点，最低点的下一个就是答案
        // 最低点往后遍历，之后的点的累计和一定是大于等于0的
        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
    
        // 总和小于0则表示不能到达
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}
