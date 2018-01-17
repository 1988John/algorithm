package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class Main {
	/**
	 * 为了看清楚Java反射部分代码，所有异常我都最后抛出来给虚拟机处理！
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		//Demo1.  通过Java反射机制得到类的包名和类名
		Demo1();
		System.out.println("===============================================");
		
		//Demo3.  通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]，无参构造
		Demo3();
		System.out.println("===============================================");
		
		//Demo4:  通过Java反射机制得到一个类的构造函数，并实现构造带参实例对象
		Demo4();
		System.out.println("===============================================");
		
		//Demo5:  通过Java反射机制操作成员变量, set 和 get
		Demo5();
		System.out.println("===============================================");
		
		//Demo6: 通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等
		Demo6();
		System.out.println("===============================================");
		
		//Demo7: 通过Java反射机制调用类中方法
		Demo7();
		System.out.println("===============================================");
		
	}
	
	/**
	 * Demo1: 通过Java反射机制得到类的包名和类名
	 */
	public static void Demo1()throws ClassNotFoundException
	{
		Person person = new Person();
        System.out.println("Demo1: 包名: " + person.getClass().getPackage().getName() + "，"
				+ "完整类名: " + person.getClass().getName());

        //写法1, 可能抛出 ClassNotFoundException [多用这个写法]
        Class<?> class1 = Class.forName("reflect.Person");
        System.out.println("Demo2:(写法1) 包名: " + class1.getPackage().getName() + "，"
                + "完整类名: " + class1.getName());

        //写法2
        Class<?> class2 = Person.class;
        System.out.println("Demo2:(写法2) 包名: " + class2.getPackage().getName() + "，"
                + "完整类名: " + class2.getName());
	}
	
	/**
	 * Demo3: 通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void Demo3() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
        Class<?> class1 = Class.forName("cn.lee.demo.Person");
		//由于这里不能带参数，所以你要实例化的这个类Person，一定要有无参构造函数哈～
		Person person = (Person) class1.newInstance();
		person.setAge(20);
		person.setName("LeeFeng");
		System.out.println("Demo3: " + person.getName() + " : " + person.getAge());
	}
	
	/**
	 * Demo4: 通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalArgumentException 
	 */
	public static void Demo4() throws ClassNotFoundException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		Class<?> class1 = null;
		Person person1 = null;
		Person person2 = null;
		
		class1 = Class.forName("cn.lee.demo.Person");
		//得到一系列构造函数集合
		Constructor<?>[] constructors = class1.getConstructors();
		
		person1 = (Person) constructors[0].newInstance();
		person1.setAge(30);
		person1.setName("leeFeng");
		
		person2 = (Person) constructors[1].newInstance(20,"leeFeng");
		
		System.out.println("Demo4: " + person1.getName() + " : " + person1.getAge()
				+ "  ,   " + person2.getName() + " : " + person2.getAge()
				);
		
	}
	
	/**
	 * Demo5: 通过Java反射机制操作成员变量, set 和 get
	 * 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void Demo5() throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, InstantiationException, ClassNotFoundException
	{
		Class<?> class1 = null;
		class1 = Person.class;
		Object obj = class1.newInstance();
		
		Field personNameField = class1.getDeclaredField("name");
		personNameField.setAccessible(true);
		personNameField.set(obj, "胖虎先森");
		
		
		System.out.println("Demo5: 修改属性之后得到属性变量的值：" + personNameField.get(obj));
		
	}
	

	/**
	 * Demo6: 通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等
	 * @throws ClassNotFoundException 
	 */
	public static void Demo6() throws ClassNotFoundException
	{
		Class<?> class1 = null;
		class1 = Person.class;
		
		//取得父类名称
		Class<?>  superClass = class1.getSuperclass();
		System.out.println("Demo6:  SuperMan类的父类名: " + superClass.getName());
		
		System.out.println("===============================================");
		
		
		Field[] fields = class1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println("类中的成员: " + fields[i]);
		}
		System.out.println("===============================================");
		
		
		//取得类方法
		Method[] methods = class1.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println("Demo6,取得SuperMan类的方法：");
			System.out.println("函数名：" + methods[i].getName());
			System.out.println("函数返回类型：" + methods[i].getReturnType());
			System.out.println("函数访问修饰符：" + Modifier.toString(methods[i].getModifiers()));
			System.out.println("函数代码写法： " + methods[i]);
		}
		
		System.out.println("===============================================");
		
		//取得类实现的接口,因为接口类也属于Class,所以得到接口中的方法也是一样的方法得到哈
		Class<?> interfaces[] = class1.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println("实现的接口类名: " + interfaces[i].getName() );
		}
		
	}
	
	/**
	 * Demo7: 通过Java反射机制调用类方法
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws InstantiationException 
	 */
	public static void Demo7() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException
	{
		Class<?> class1 = null;
		class1 = Class.forName("cn.lee.demo.SuperMan");
		
		System.out.println("Demo7: \n调用无参方法fly()：");
		Method method = class1.getMethod("fly");
		method.invoke(class1.newInstance());
		
		System.out.println("调用有参方法walk(int m)：");
		method = class1.getMethod("walk",int.class);
		method.invoke(class1.newInstance(),100);
	}
	
}



