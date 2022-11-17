package com.fj.generic;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args) {
        HashMap<String,Student> hashMap=new HashMap<String,Student>();
        HashSet<Student> students=new HashSet<Student>();
        students.add(new Student("菜虚坤",29));
        students.add(new Student("陈世美",9));
        students.add(new Student("五大招",15));
        //遍历student
        for (Student stu:students) {
            System.out.println(stu);
        }
        hashMap.put("蔡徐坤",new Student("菜虚坤",29));
        hashMap.put("陈世美",new Student("陈世美",9));
        hashMap.put("五大招",new Student("五大招",15));
        //遍历 hashmap
        System.out.println("使用keySet");
        Set<String> keySet = hashMap.keySet();
        for (String key:keySet) {
            System.out.println(key+"----"+hashMap.get(key));
        }
        System.out.println("使用迭代器");
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key=iterator.next();
            System.out.println(key+"----"+hashMap.get(key));
        }

        System.out.println("使用entrySet");
        Set<Map.Entry<String, Student>> entrySet = hashMap.entrySet();
        for (Map.Entry enrty:entrySet) {
            System.out.println(enrty.getKey()+"----"+enrty.getValue());
        }
        System.out.println("使用迭代器");
        Iterator<Map.Entry<String, Student>> iterator1 = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry entry=(Map.Entry)iterator1.next();
            System.out.println(entry.getKey()+"----"+entry.getValue());
        }

    }
}
class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}