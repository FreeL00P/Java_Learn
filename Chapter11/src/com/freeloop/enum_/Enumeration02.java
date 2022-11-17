package com.freeloop.enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
    }
}
//使用enum关键字实现枚举
enum Season2 {

    //1。将构造器私有化 目的防止直接 new
    //2. 去掉set方法防止被修改
    //3. 在Season 内部创建固定的对象
   /* public static Season SPRING=new Season("春天","温暖");
    public static Season SUMMER=new Season("夏天","炎热");
    public static Season AUTUMN=new Season("秋天","凉爽");
    public static Season WINTER=new Season("冬天","寒冷");*/
    //如果使用enum实现枚举类
    //1.使用关键字enum替代class
    //2.  public static Season SUMMER=new Season("夏天","炎热");
    //    直接使用SPRING=new Season("春天","温暖");
    //    解读 常量名(实参列表);
    //3.如果有多个常量(对象) 使用,号隔开即可
    //4.使用enum 将定义语句写在后面
    SPRING("春天","温暖"),SUMMER("夏天","炎热"),AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");
    private String name;
    private String desc;
    private Season2(String name, String desc  ) {
        this.name=name;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getDesc() {
        return desc;
    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}