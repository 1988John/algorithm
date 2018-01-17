package medium.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/11.
 */
public class Tt {
    public static void main(String[] args) {
        Class cla = reflectT.class;
        Field[] field = cla.getDeclaredFields();
        Method[] methods = cla.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName() == "reflect1") {
                System.out.println(method.getName());
                for (Field field2 : field) {
                    System.out.print(field2.getType() + " " + field2.getName()
                            + " " + "\n");
                }

            }
        }
    }

    private boolean checkNullParams(Object... params){
        for (Object param:params){
            if (param == null)
                return true;
        }
        return false;
    }

    class reflectT{
        private String resName;
        private String operatekey;

        public String getResName() {
            return resName;
        }

        public void setResName(String resName) {
            this.resName = resName;
        }

        public String getOperatekey() {
            return operatekey;
        }

        public void setOperatekey(String operatekey) {
            this.operatekey = operatekey;
        }

        public  String reflect1(String resName, String operatekey) {
            return operatekey;

        }
    }
}
