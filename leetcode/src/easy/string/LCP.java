package easy.string;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/19.
 */
public class LCP {
    public static void main(String[] args) {
        String[] strArr1 = {"abcdgggg","abbbbbcdefg","abccccdfff","abcd"};
        String[] strArr2 = {"ca","a"};
        String[] strArr = {"aba","c","b","a","ab"};
        String prefix = longestCommonPrefix(strArr);
        System.out.println(prefix);
    }
    /**
     *@Author: jiangwang
     *@Description: Write a function to find the longest common prefix string amongst an array of strings.
     *@Date: 14:47 2017/12/19
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";

        String prefix = strs[0];
        int len = strs[0].length();
        for(int i=1;i<strs.length;i++){
            if(len>strs[i].length()){
                len = strs[i].length();
                prefix = strs[i];
            }
        }

        for(int i=0;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }
    /**
     *@Author: jiangwang
     *@Description: Write a function to find the longest common prefix string amongst an array of strings.
     *@Date: 14:47 2017/12/19
     */
    public static String longestCommonPrefix1(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        String prefix = strs[0];

        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }
}
