package main.merge;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/19.
 */
public class MyMergeSort {
    public static void main(String[] args) {

    }

    /**
     *
     * @param arr
     * @param p
     * @param r
     */
    public static void mergeSort(int[] arr,int p,int r){
        if (p < r){
            int q = (p+r)/2;
            mergeSort(arr,p,q);
            mergeSort(arr,q+1,r);
            merge(arr,p,q,r);
        }

    }
    /**
     *@Author: jiangwang
     *@Description:
     *@Date: 11:35 2017/12/19
     */
    public static void merge(int[] arr,int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;
        int[] lArr = new int[arr.length];
        int[] rArr = new int[arr.length];
        int i,j;
        for(i=0;i<n1;i++){
            lArr[i] = arr[p+i-1];
        }
        for(j=0;j<n2;j++){
            rArr[j] = arr[q+j];
        }
        i=j=0;
        for(int k=p;k<r;k++){
            if(lArr[i]<=rArr[j]){
                arr[k] = lArr[i++];
            }else {
                arr[k] = rArr[j++];
            }
        }
    }
}
