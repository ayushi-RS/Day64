class Solution {
    public int findJudge(int n, int[][] trust) {
    int[] degree=new int[n+1];
        Arrays.fill(degree,0);
    for(int i=0;i<trust.length;i++){
        degree[trust[i][1]]++;
        degree[trust[i][0]]--;
        }
        
    for(int j=1;j<degree.length;j++){
        if((n-1)==degree[j]) return j;
    }
        return -1;
    }
    
}