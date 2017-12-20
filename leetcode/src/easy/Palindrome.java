package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/19.
 */
public class Palindrome {
    public static void main(String[] args) {
        boolean b = isPalindrome(-2147447412);
        System.out.println(b);
    }
    /**
     *@Author: jiangwang
     *@Description: 回文数判定
     *@Date: 14:02 2017/12/19
     */
    public static boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<Integer>();
        x = Math.abs(x);
        for (int i=1;;i++){
            Double resultD = x % Math.pow(10, i);
            int result = resultD.intValue();
            list.add(result);
            if(result == x){//表明已经到最高位
                break;
            }

        }
        List<Integer> resultList = new ArrayList<Integer>();
        for(int i=0;i<list.size();i++){
            Double resultD = list.get(i) / Math.pow(10, i);
            resultList.add(resultD.intValue());
        }
        int count = 0;
        for(int i=0;i<resultList.size()/2;i++){
            if(resultList.get(i) == resultList.get(resultList.size()-1-i)){
                count ++;
            }else{
                break;
            }
        }

        if(count == resultList.size()/2){
            return true;
        }
        return false;
    }
}
