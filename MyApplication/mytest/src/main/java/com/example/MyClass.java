package com.example;

import com.example.entity.TestEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MyClass {
    public static void main(String[] args){
        List<TestEntity> entities = new ArrayList<>();
        String a = "测试测试";
        for (int i = 0; i < 10; i ++){
            entities.add(new TestEntity("测试---" + i));
        }

        for (Iterator<TestEntity> iterator = entities.iterator(); iterator.hasNext();){
            TestEntity entity = iterator.next();
            iterator.remove();
            System.out.println(entity.getName());
        }
    }
}
