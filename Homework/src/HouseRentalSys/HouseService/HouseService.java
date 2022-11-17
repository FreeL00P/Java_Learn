package HouseRentalSys.HouseService;

import HouseRentalSys.HouseDomain.House;
import HouseUtility.HouseUtility;

/*
* 业务层
* 1 响应HouseView的各种调用
* 2 完成房屋信息的各种操作
* */
public class HouseService {
    private  House[] houses;
    private int houseNum=1;//记录当前有多少房屋信息
    private int idCount=1;//记录当前id增长到哪个值了
    public HouseService(int size) {
        houses =new House[size];//当创建HouseService对象 指定数组大小
        houses[0]=new House(1,"jack","111","海南",2000,"未出租");
    }
    //list方法 返回house
    public House[] list(){
        return houses;
    }
    public boolean add(House newHouse){
        //判断是否可以继续添加
        if (houseNum==houses.length){//已满
            System.out.println("数组已满 不能继续添加");
            return false;
        }
        //将对象添加到数组末尾
        houses[houseNum++]=newHouse;
        //id自增
        newHouse.setId(++idCount);//更新newHouse的id
        return true;
    }
    //删除
    public boolean del(int delId){
        int index=-1;
        for (int i = 0; i <houseNum ; i++) {
            if(delId==houses[i].getId()){//要删除的房屋id 是数组下标为i的元素
                index=i;
            }
        }
        if(index==-1){//说明delId在数组的不存在
            return false;
        }
        //如果找到
        for (int j = index; j < houseNum-1; j++) {
            houses[j]=houses[j+1];
        }
        houses[houseNum-1]=null;//将数组所有元素前移动一位 最后一位没有被修改 且复制一份到到前一位了 所以这里要null
        houseNum--; //删除后 数组少一个元素
        return true;
    }
    public House sel(int selId){
        for (int i = 0; i <houseNum ; i++) {
            if (selId==houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }    
}
