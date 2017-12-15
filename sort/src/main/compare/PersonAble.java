package main.compare;

import java.util.Arrays;

public class PersonAble implements Comparable<PersonAble>
{
    String name;
    int age;
    public PersonAble(String name, int age)
    {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }

    @Override
    public int compareTo(PersonAble p)
    {
        return this.age-p.getAge();
    }

    public static void main(String[] args)
    {
        PersonAble[] people=new PersonAble[]{new PersonAble("xujian", 20),new PersonAble("xiewei", 10)};
        System.out.println("排序前");
        for (PersonAble person : people)
        {
            System.out.println(person.getName()+":"+person.getAge());
        }
        Arrays.sort(people);
        System.out.println("\n排序后");
        for (PersonAble person : people)
        {
            System.out.println(person.getName()+":"+person.getAge());
        }
    }
}