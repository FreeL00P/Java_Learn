package com.freeloop.enum_;

public class Enumeration04 {
    public static void main(String[] args) {
        //使用Season3 枚举类 来演示各种方法
        Season3 autumn=Season3.AUTUMN;
        //输出枚举对象的名字
        System.out.println(autumn.name()); //AUTUMN
        //输出枚举对象的次序
        System.out.println(autumn.ordinal());//2
        //从反编译可以看出 values方法 返回一个Season3[]
        Season3[] values=Season3.values();
        //遍历 取出
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        //valueOf 将字符串转换为枚举对象 要求字符串必须为已有常量名
        // 1. 根据输入的AUTUMN到Season3中的枚举对象中去查找 d
        // 2. 找到返回 没找到 报错
        Season3 autumn1=Season3.valueOf("AUTUMN");
        System.out.println("autumn1="+autumn1);//autumn1=Season{name='秋天', desc='凉爽'}
        System.out.println(autumn==autumn1);//true
        //compareTo 比较两个枚举常量，比较的是编号 前者减后者
        System.out.println(Season3.AUTUMN.compareTo(Season3.SPRING));//2

    }
}
enum Season3 {

    SPRING("春天","温暖"),SUMMER("夏天","炎热"),AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");
    private String name;
    private String desc;
    private Season3(String name, String desc  ) {
        this.name=name;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}