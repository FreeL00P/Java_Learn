package HouseUtility;

import sun.text.normalizer.Utility;

public class TestUtility {
    public static void main(String[] args) {
        //要求输入一个字符串 最大长度为3
        String s= HouseUtility.readString(3);

        System.out.println("s="+s);
        //要求输入一个字符串 长度最大为10 如果用户直接回车 就给一个默认值
        String s1=HouseUtility.readString(10,"sss");
        System.out.println("s1="+s1);
    }
}
