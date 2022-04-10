package dailyPromblem;

public class s867 {
    public int[][] transpose(int[][] matrix) {
        if(matrix.length == 1 && matrix[0].length == 1){
            return matrix;
        }
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }
}
