package com.fj.generic;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/13 19:52    since 1.0.0      泛型作业
 */
@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {


    }
    @Test
    public void TestList(){
        DAO<User> dao= new DAO<User>();
        dao.save("01",new User(01,18,"jack"));
        dao.save("02",new User(02,28,"mark"));
        dao.save("03",new User(03,13,"lily"));
        System.out.println(dao.list());
        System.out.println(dao.get("01"));
        dao.delete("02");
        dao.update("01",new User(01,20,"jack"));
        System.out.println("修改后");
        System.out.println(dao.list());
    }
}
class DAO<T>{
    private Map<String,T> map=new HashMap<>();

    public void save(String id,T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        map.put(id,entity);
    }

    public List<T> list(){
        List<T> list=new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String key:keySet){
            list.add(map.get(key));
        }
/*        Set<Map.Entry<String, T>> entrySet = map.entrySet();
        for (Map.Entry entry:entrySet) {
            System.out.println(entry.getKey()+""+entry.getValue());
        }*/
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }

}

class  User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

