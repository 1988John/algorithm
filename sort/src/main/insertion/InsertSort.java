package main.insertion;

import java.util.Arrays;

/**
 * Description: 插入排序
 * Created by jiangwang3 on 2017/10/11.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {6 ,1 , 2 ,7 , 9 , 3 , 4 , 5 ,10 , 8};
        System.out.println("结果"+ Arrays.toString(insertSort(arr)));
    }

    public static int[] insertSort(int[] arr){
        for(int j=1;j<arr.length;j++){
            int key = arr[j];
            int i=j-1;
            while (i>=0&&arr[i]>key){
                arr[i+1] = arr[i];
                i--;
            }
            arr[++i] = key;

        }
        return arr;
    }
}
