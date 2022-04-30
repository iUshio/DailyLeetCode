package dailyPromblem;

public class s209 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(44, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if(len == 1 && nums[0] < target){
            return 0;
        }

        int pre = 0;
        int next = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while(true){
            if(sum >= target){
                res = Math.min(res, next -  pre + 1);
                sum -= nums[pre];
                pre++;
            }else{
                next++;
                if(next > len -1) break;
                sum += nums[next];
            }

        }
        if(res == Integer.MAX_VALUE) return 0;
        else return res;
    }
}
