package service;

import java.lang.reflect.Field;

/**
 * Description:
 * Created by jiangwang3 on 2018/3/30.
 */
public class InjectService {

    public static void main(String[] args) throws Exception{
        String beanName = "domain.User";
        Class<?> clazz = Class.forName(beanName);
        Object object = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true); // 修改访问控制权限

            String typeName = field.getType().getTypeName();
            if (typeName.equals("java.lang.String"))
                field.set(object,"foo");
            if (typeName.equals("java.lang.Integer"))
                field.set(object,18);

        }
        System.out.println(object);
    }
}
