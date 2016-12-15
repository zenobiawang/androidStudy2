package com.example;

import com.example.entity.Consts;
import com.example.entity.CostEntity;
import com.example.entity.TestEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyClass {
    public static void main(String[] args){

    }

    /**
     * 测试正则匹配
     */
    private static void test2(){
        String values = "12月11日买了一袋牛奶花了18元,午饭35";
        Pattern pattern = Pattern.compile(Consts.MATCH_DATA);
        Matcher matcher = pattern.matcher(values);
        if (matcher.matches()){
            for (int i=0; i < matcher.groupCount(); i ++){
                CostEntity entity = new CostEntity();
                entity.setDate(matcher.group(i));
            }
        }else {
            // TODO: 2016/12/14 没写入日期默认今天
        }
    }


    /**
     * 测试iterator是不是可能为空
     */
    private static void test1(){
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
