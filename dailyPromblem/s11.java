package dailyPromblem;

public class s11 {
    // 双层for循环（超时）
    public int maxArea1(int[] height) {
        int len = height.length;
        int res = 0;
        int tmp = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < i; j++){
                tmp = Math.min(height[i],height[j]) * (i - j);
                res = Math.max(res,tmp);
            }
        }

        return res;
    }

    // 双指针
    public int maxArea(int[] height) {
        int len = height.length;
        int res = 0;
        int tmp = 0;
        int pre = 0,tail = len -1;
        while(tail > pre){
            tmp = Math.min(height[pre],height[tail]) * (tail - pre);
            res = Math.max(res,tmp);
            if(height[tail] >= height[pre]){
                pre++;
            }else{
                tail--;
            }
        }

        return res;
    }
}
