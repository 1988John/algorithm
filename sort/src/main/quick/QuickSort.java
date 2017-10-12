package main.quick;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description: 快速排序
 * Created by jiangwang3 on 2017/10/12.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,6,1,8,0,9,3,7,4,5};
        quickSort(arr,0,9);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归调用 将每一组排序
     * @param arr
     * @param p
     * @param r
     */
    public static void quickSort(int[] arr,int p,int r){
        if(p<r){
            int q = partition(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }
    }
    /**
     * 根据key值将数组分成两组
     * @return
     */
    public static int partition(int[] arr,int p,int r){
        int key = arr[r];
        int i = p-1;
        for(int j=p;j<r;j++){
            if(arr[j]<=key){
                i++;
                exchange(arr,i,j);
            }
        }

        exchange(arr,i+1,r);

        return i+1;
    }

    /**
     * 将数组下表i与j的值互换
     * @param arr
     * @param i
     * @param j
     */
    public static void exchange(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
