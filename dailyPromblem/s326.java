package dailyPromblem;

public class s326 {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }

        while(n != 0 && n % 3 == 0){
            n = n / 3;
        }

        return n == 1;
    }
}
