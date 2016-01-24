package me.coding.Launcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Varun on 1/23/2016.
 */
public class launcher {
    public static void main(String[] args){
       grayCode(3);
        System.out.println(uniquePaths(1,2));
    }
    public static List<Integer> grayCode(int n) {
            List<Integer> prev=new LinkedList<>();
            prev.add(0);
            prev.add(1);
        for(int i=2;i<=n;i++){
            List<Integer> next=prev;
            int pSize=prev.size();
            int pNum=prev.get(pSize-1);
            int shift=1<<(i-1);
            pNum=pNum|shift;
            next.add(pNum);
            for(int j=0;j<=pSize-2;j++){
                 pNum=prev.get(j);
                // shift=1<<(i);
                pNum=pNum|shift;
                next.add(pNum);
            }
            prev=next;
        }
        return prev;
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        dp[0][0]=1;
        return uniquePathsHelper(m,n,m-1,n-1,dp);

    }

    public static int uniquePathsHelper(int m,int n,int i, int j,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        dp[i][j]=uniquePathsHelper(m,n,i-1,j,dp)+uniquePathsHelper(m,n,i,j-1,dp);
        return dp[i][j];
    }
}
