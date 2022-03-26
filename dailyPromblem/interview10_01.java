package dailyPromblem;

public class interview10_01 {

    public static void main(String[] args) {
        int[] A = { 0 };
        int[] B = { 1 };
        merge(A, 0, B, 1);
        System.out.println(A[0]);
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        if (m == 0 || n == 0) {
            for (int i = 0; i < B.length; i++) {
                A[i] = B[i];
            }
            return;
        }
        int ain = m - 1;
        int bin = n - 1;
        int cur;
        int tail = m + n - 1;
        while (ain >= 0 || bin >= 0) {
            if (ain < 0) {
                cur = B[bin--];
            } else if (bin < 0) {
                cur = A[ain--];
            }else if (A[ain] < B[bin]) {
                cur = B[bin--];
            } else {
                cur = A[ain--];
            }
            A[tail--] = cur;
        }

    }
}
