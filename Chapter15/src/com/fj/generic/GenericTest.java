package com.fj.generic;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class GenericTest {
    public static void main(String[] args) {
        ArrayList<Employee> arrayList=new ArrayList<Employee>();
        arrayList.add(new Employee("abcd","2400",new MyDate(2001,9,2)));
        arrayList.add(new Employee("jack","2200",new MyDate(2003,2,1)));
        arrayList.add(new Employee("jack","1400",new MyDate(2003,2,12)));
        //先按name排序 如果name相同在按生日排序
        arrayList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (!(emp1 instanceof Employee&&emp2 instanceof Employee)){
                    System.out.println("类型错误");
                    return 0;
                }
                int i=emp1.getName().compareTo(emp2.getName());
                if (i!=0){
                    return i;
                }
//                int y=emp1.getBirthday().getYear()-emp2.getBirthday().getYear();
//                int m= emp1.getBirthday().getMonth()-emp2.getBirthday().getMonth();
//                int d=emp1.getBirthday().getDay()-emp2.getBirthday().getDay();
//                if (y!=0){return y;
//                }
//                else if (m!=0){
//                    return m;
//                }else if (d!=0){
//                    return d;
//                }
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });
        //遍历arraylist
        for (Employee emp:arrayList) {
            System.out.println(emp);
        }
    }
}
class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        //this可以省略
        int y=year-o.getYear();
        int m=month-o.getMonth();
        int d=day-o.getDay();
        if (y!=0){
            return y;
        }
        if (m!=0){
            return m;
        }
        //如果year and mouth 都相同
        return d;
    }
}
class Employee{
    private String name;
    private String sal;
    private MyDate birthday;

    public Employee(String name, String sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal='" + sal + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
