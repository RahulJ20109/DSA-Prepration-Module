public class CountNegativeNumber {
    public static void main(String[] args) {
        int[][] arr={
            {4,3,2,-1},
            {3,2,1,-1},
            {1,1,-1,-2},
            {-1,-1,-2,-3}
        };
        Solution solution=new Solution();
        int val=solution.countNegatives(arr);
        System.out.println(val);
    }
}
// [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
class Solution {
    public int countNegatives(int[][] grid) {
        int start = 0;
        int end;
        int count=0;
        for(int row =0;row<grid.length;row++) {
            start = 0;
            end=grid[row].length-1;
            while(start<=end){
                int mid = start+(end-start)/2;
                if(grid[row][mid]<0){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            count+=grid[row].length-start;
        }
        return count;
    }
}
