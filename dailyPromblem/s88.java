package dailyPromblem;

public class s88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 对特殊情况进行判断
        if(n == 0){
            return ;
        }else if(m == 0){
            // 如果nums1为空，此时nums2必不为空，将nums2的内容转移到nums1中
            for(int i = 0;i < n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }

        int s1p = m -1;
        int s2p = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            // 有数组提前排序完毕
            if(s1p < 0){
                nums1[i] = nums2[s2p];
                s2p--;
                continue;
            }else if(s2p < 0){
                nums1[i] = nums1[s1p];
                s1p--;
                continue;
            }
            // 判断s1p和s2p的大小
            if(nums1[s1p] >= nums2[s2p]){
                nums1[i] = nums1[s1p];
                s1p--;
            }else{
                nums1[i] = nums2[s2p];
                s2p--;
            }
        }
    }
}
