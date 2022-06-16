package com.example.cnds.jdk8;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : wangjun
 * @date : 2021/10/25  13:49
 */
@Slf4j
public class StreamTest {
    public static void main(String[] args) {
        List<User> list = Lists.newArrayList();
        list.add(new User(1, 18, "joy"));
        list.add(new User(2, 22, "tom"));
        list.add(new User(5, 9, "jack"));
        list.add(new User(3, 1, "sam"));
        list.add(new User(4, 22, "tony"));

        //获取age集合 list
        List<Integer> ageList = list.stream().map(User::getAge).collect(Collectors.toList());
        log.info("获取age集合 list"+JSONObject.toJSONString(ageList));

        //获取age集合 set
        Set<Integer> ageSet = list.stream().map(User::getAge).collect(Collectors.toSet());
        log.info("获取age集合 set"+JSONObject.toJSONString(ageSet));

        //按照age进行排序 正序列
        list.sort(Comparator.comparing(User::getAge));
        log.info("按照age进行排序 正序列"+JSONObject.toJSONString(list));

        //按照age进行排序 反序列
        list.sort(Comparator.comparing(User::getAge).reversed());
        log.info("按照age进行排序 反序列"+JSONObject.toJSONString(list));

        //过滤年纪大于20的
        List<User> bigAgeList = list.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList());
        log.info("过滤年纪大于20的"+JSONObject.toJSONString(bigAgeList));

        //过滤年纪大于20 且叫tom的人
        list.stream().filter(p -> p.getAge() > 20&&p.getName().equals("tom")).forEach(p-> System.out.println(p.toString()));

        //对于指定的年龄 进行筛选
        List<Integer> ageDemo = Arrays.asList(1, 22);
        list.stream().filter(p->ageDemo.contains(p.getAge())).forEach(p-> System.out.println(p.toString()));
        list.stream().map(User::getAge).filter(ageDemo::contains).forEach(p-> System.out.println(p.toString()));

        //对Id-User  组成map
        Map<Integer, String> map1 = list.stream().collect(Collectors.toMap(User::getId, User::getName));
        Map<Integer, User> map2 = list.stream().collect(Collectors.toMap(User::getId, java.util.function.Function.identity()));
        //对age-User  组成map 如果出现重复key 不报错 而是后面覆盖前面
        Map<Integer, User> map3 = list.stream().collect(Collectors.toMap(User::getAge, java.util.function.Function.identity(),(key1,key2)->key2));

        Map<String, User> map4 = list.stream().collect(Collectors.toMap(o -> o.getAge() + "ww" + o.getId(), java.util.function.Function.identity()));
        Map<String, User> map5 = list.stream().collect(Collectors.toMap(o -> o.getAge() + "ww" + o.getId(), Function.identity()));
        Map<String, User> map6 = list.stream().collect(Collectors.toMap(o -> o.getAge() + "ww" + o.getId(), o->o));

        //按照年龄分组
        Map<Integer, List<User>> map7 = list.stream().collect(Collectors.groupingBy(User::getAge));


        //guava map反转
        BiMap<String,String> map8= HashBiMap.create();
        map8.inverse();


       System.out.println("结束");

    }
}
