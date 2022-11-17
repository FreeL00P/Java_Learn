package TestHashSet;

import java.util.HashSet;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        HashSet hashSet=new HashSet();
        hashSet.add(new employee("ll","20",new MyDate(2002,2,2)));
        hashSet.add(new employee("ll","20",new MyDate(2002,2,2)));
        System.out.println(hashSet);
    }
}
class employee {

    private  String name;
    private String sal;
    private MyDate birthday;

    public employee(String name, String sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee employee = (employee) o;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "employee{" +
                "name='" + name + '\'' +
                ", sal='" + sal + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
class MyDate{
    private int year;
    private int month;
    private int day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
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
}