package Homework13;

import java.util.jar.JarEntry;

public class HomeWork13 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("蔡徐坤", '男', 20, 4);
        teacher.printInfo();
        System.out.println("---------------------------");
        Student student = new Student("蔡徐坤",'男',20,"20194732");
        student.printInfo();
        //定义多态数组
        Person[] person=new Person[4];
        person[0]= new Student("徐坤",'男',20,"201947332");
        person[1]= new Student("鸡哥",'男',21,"201944332");
        person[2]= new Teacher("坤",'男',24,3);
        person[3]= new Teacher("哥",'男',13,4);
        //创建对象
        HomeWork13 homeWork13=new HomeWork13();
        homeWork13.bubbleSort(person);
        //输出排序后的数组
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
        //遍历数组调用test()
        for (int i = 0; i < person.length; i++) {
           homeWork13.test(person[i]);
        }
    }
    //定义方法，形参为Person类型 功能：调用学生的study()或教师的teach()方法
    //向下转型和类型判断
    public void  test(Person p){
        if (p instanceof Student){//p的运行累心如果为student
            ((Student) p).study();
        }else if (p instanceof Teacher){
            ((Teacher) p).teach();
        }else {
            System.out.println("NOTHING");
        }

    }


    //方法完成年龄从高到低排序
    public void bubbleSort(Person[] person){
        for (int i=0;i<=person.length-1;i++){
            for (int j = 0; j < person.length-i-1; j++) {
                if (person[j+1].getAge()>person[j].getAge()){
                    Person temp=person[j+1];
                    person[j+1]=person[j];
                    person[j]=temp;
                }
            }
        }
    }

}
