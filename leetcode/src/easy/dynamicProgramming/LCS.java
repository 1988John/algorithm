package easy.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/2.
 */
public class LCS {
    public static void main(String[] args) {
        char[] arrA = {'a','b','c','b','d','a','b'};
        char[] arrB = {'b','d','c','a','b','a'};
        getLcsLenth(arrA,arrB);
    }
   public static void getLcsLenth(char[] arrA,char[] arrB){
       int[][] c = new int[arrA.length][arrB.length];
       int[][] b = new int[arrA.length][arrB.length];
       for (int i=0;i<arrA.length;i++){
           for(int j=0;j<arrB.length;j++){
               if(i==0 || j==0){
                   if (arrA[i] == arrB[j]){
                       c[i][j] = 1;
                       b[i][j] = 2; //斜对角
                   }
               }else {
                   if (arrA[i] == arrB[j]){
                       c[i][j] = c[i-1][j-1]+1;
                       b[i][j] = 2; //斜对角
                   }else if (c[i-1][j] >= c[i][j-1]){
                       c[i][j] = c[i-1][j];
                       b[i][j] = 1; //up
                   }else {
                       c[i][j] = c[i][j-1];
                       b[i][j] = -1; //left
                   }
               }

           }
       }
       int i=arrA.length-1;
       int j = arrB.length-1;
       StringBuffer sb = new StringBuffer();
       while(i>=0 && j>=0){
            if(b[i][j]==1)
                i--;
            else if (b[i][j] == -1)
                j--;
            else{
                sb.append(arrA[i]);
                i--;
                j--;
            }
       }

       System.out.println(sb.reverse().toString());

       printTwoDArray(c);
       printTwoDArray(b);

   }
   public static void printTwoDArray(int[][] dArr){
       for(int i=0;i<dArr.length;i++){
            for(int j=0;j<dArr[i].length;j++){
                System.out.print(dArr[i][j]+" ");
            }
           System.out.println();
       }
       System.out.println();
   }
}

