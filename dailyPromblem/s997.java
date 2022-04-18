package dailyPromblem;

public class s997 {
    public int findJudge(int n, int[][] trust) {
        int len = trust.length;
        if(len == 0){
            return -1;
        }else if(len == 1){
            return trust[0][1];
        }
        int[] trusts = new int[n + 1];
        for(int[] per:trust){
            trusts[per[1]]++;
            trusts[per[0]] = Integer.MIN_VALUE;
        }
        for(int i = 1;i <= n;i++){
            if(trusts[i] == n - 1){
                return i;
            }
        }
        return -1;
    }
}
