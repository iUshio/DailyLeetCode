package dailyPromblem;

import java.util.Arrays;

public class s455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int point = 0;
        for(int i = 0;i < g.length;i++){
            if(s[point] >= g[i]){
                res++;
                point++;
                
            }else{
                i--;
                point++;
            }
            if(point >= s.length){
                return res;
            }
        }
        return res;
    }
}
