package dailyPromblem;

public class s1504 {
    public int numSubmat(int[][] mat) {
        int sum = 0;
        int[][] tmp = new int[mat.length][mat[0].length];

        //填充tmp数组，其中每个元素为同行紧挨着的元素数量
        for(int i = 0;i < mat.length;i++){
            for(int j = 0;j < mat[0].length;j++){
                if(j == 0 || mat[i][j] == 0) tmp[i][j] = mat[i][j];
                else{
                    tmp[i][j] = tmp[i][j - 1] + 1;
                }
            }
        }

        //对数据进行读取
        for(int i = 0;i < tmp.length;i++){
            for(int j = 0;j < tmp[0].length;j++){
                if(tmp[i][j] == 0) continue; 
                sum += tmp[i][j];
                int row = i - 1;
                while(row >= 0){
                    if(tmp[row][j] == 0) break;
                    tmp[row][j] = Math.min(tmp[row][j], tmp[i][j]);
                    sum += tmp[row][j];
                    row--;
                }
            }
        }

        return sum;
    }
}
