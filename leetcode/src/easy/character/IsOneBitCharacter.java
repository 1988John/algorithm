package easy.character;

import java.util.Arrays;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/27.
 */
public class IsOneBitCharacter {
    public static void main(String[] args) {
        int[] bits = {1,0,0,1,0};
        String str = Arrays.toString(bits);
        String s = str.replaceAll("[\\[\\]]|,\\s*", "");
        System.out.println(str);
        System.out.println(s);
        System.out.println(s.length());
    }
    public boolean isOneBitCharacter(int[] bits) {
        if(bits == null) return false;
        int point = 0;
        int result = bits.length;
        while (result>0){

            if(result == 1) return true;

            if(bits[point] ==1) point += 2;

            else point ++;

            result = bits.length - point;
        }
        return false;
    }
}
