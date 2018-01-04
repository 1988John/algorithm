package medium.dynamicProgramming;

import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/3.
 */
public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("goal","go","goals","special");
        String s = "goalspecial";
        boolean result = wordBreak2(s, wordDict);
        System.out.println(result);
//        System.out.println(s.substring(s.length()));
//        System.out.println(s.substring(2,4));
//        System.out.println(wordDict.contains(s));
    }
    /**
     *@Author: jiangwang
     *@Description:
     *@Date: 11:01 2018/1/4
     */
    public static boolean wordBreak(String s, List<String> wordDict){
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        return wordContain(s,wordDict,map);
    }

    /**
     *  memoried 备忘录方式
     * @param s
     * @param wordDict
     * @param map
     * @return
     */
    public static boolean wordContain(String s, List<String> wordDict,Map<String,Boolean> map) {
        Boolean value = map.get(s);
        if(value == null){
            for(int i=0;i<s.length();i++){
                String startWord = s.substring(i);
                if(wordDict.contains(startWord)){
                    map.put(startWord,true);
                    String leftWord = s.substring(0,i);
                    if(!startWord.equals(s)){
                        boolean b = wordContain(leftWord, wordDict,map);
                        if(b){
                            map.put(leftWord,true);
                            return b;
                        }
                    }else {
                        return true;
                    }
                }
            }
        }else{
            return value;
        }
        map.put(s,false);
        return false;
    }

    /**
     *  数组方式 自底向上
     * @param s
     * @param dict
     * @return
     */
    public static boolean wordBreak2(String s, List<String> dict) {
        if(s==null || s.length()==0)
            return true;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++)
        {
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++)
            {
                if(res[j] && dict.contains(str.toString()))
                {
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }

    /**
     *  time limit exceeded
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak11(String s, List<String> wordDict) {
        for(int i=1;i<=s.length();i++){
            String startWord = s.substring(0,i);
            if(wordDict.contains(startWord)){
                String leftWord = s.substring(i,s.length());
                if(!startWord.equals(s)){
                    boolean b = wordBreak(leftWord, wordDict);
                    if(b) return b;
                }else {
                    return true;
                }

            }
        }
        return false;
    }



    /**
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak1(String s, List<String> wordDict) {
        String copy = s;
        for(int i=s.length();i>=0;i--){
            String str = s.substring(0,i);
            if(wordDict.contains(str)){
                s = s.substring(i);
                if(s == null || s.length() == 0){
                    return true;
                }
                i = s.length()+1 ;
            }
        }
        s = copy;
        for(int i=1;i<=s.length();i++){
            String str = s.substring(0,i);
            if(wordDict.contains(str)){
                s = s.substring(i);
                if(s == null || s.length() == 0){
                    return true;
                }
                i = 0;
            }
        }

        return false;
    }
}

