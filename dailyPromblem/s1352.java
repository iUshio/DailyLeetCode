package dailyPromblem;

import java.util.*;

public class s1352 {

    public static void main(String[] args) {
        ProductOfNumbers1 productOfNumbers = new ProductOfNumbers1();

        productOfNumbers.add(3); // [3]
        productOfNumbers.add(0); // [3,0]
        productOfNumbers.add(2); // [3,0,2]
        productOfNumbers.add(5); // [3,0,2,5]
        productOfNumbers.add(4); // [3,0,2,5,4]

    }

    static class ProductOfNumbers1 {
        int[] sums;
        int point;

        public ProductOfNumbers1() {
            point = 1;
            sums = new int[40001];
        }

        public void add(int num) {
            sums[++point] = num;
            for (int i = point - 1; i >= 1; i--) {
                sums[i] *= num;
            }
        }

        public int getProduct(int k) {
            return sums[point - k + 1];
        }
    }

    class ProductOfNumbers {
        // i记录0的部分，如果k往前推包括了这个部分，直接返回0即可
        int i;
        int prePro[];
        int j;
        public ProductOfNumbers() {
            j=1;
            i=-1;
            prePro=new int[100001];
            prePro[0]=1;
        }
        
        public void add(int num) {
            if(num==0){
                i=j;
                prePro[j]=1;
            }
            else{prePro[j]=num*prePro[j-1];}
            j++;
        }
        
        public int getProduct(int k) {
            // 将k部分之前的部分除去，得到的就是k部分的乘积
            return j-k<=i?0:prePro[j-1]/prePro[j-k-1];
        }
    }
}
