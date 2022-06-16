package com.example.cnds.concurrent.currentTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author : wangjun
 * @date : 2021/10/20  13:53
 */
public class CurrentHashMapTest {
    private static final String url = "D:/learn/cnds/src/main/resources/temp/";

    public static void main(String[] args) {
        //写入文件
//        writeFile();
        demo(
//                () -> new HashMap<String,Integer>(),
//                (map, words) -> {
//                    for (String word : words) {
//                        Integer count = map.get(word);
//                        int newCount = count == null ? 1 : (count + 1);
//                        map.put(word, newCount);
//                    }
//                }

                () -> new ConcurrentHashMap<String, LongAdder>(),
                (map, words) -> {
                    for (String word : words) {
                        LongAdder value = map.computeIfAbsent(word, (Key) -> new LongAdder());
                        value.increment();
                    }
                }



        );


    }




    public static <V> void demo(Supplier<Map<String, V>> supplier, BiConsumer<Map<String, V>, List<String>> consumer) {
        Map<String, V> currentMap = supplier.get();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int ix = i+1;
            Thread thread = new Thread(() -> {
                List<String> tempList = readFrom(ix);
                consumer.accept(currentMap, tempList);
            });
            threads.add(thread);
        }
        threads.forEach(thread -> thread.start());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentMap);
    }


    public static List<String> readFrom(Integer ix) {
        List<String> list = new ArrayList<>();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(url + ix + ".txt"));
            String s = null;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                list.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



    public static void writeFile() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        List<String> list = new ArrayList<>();
        int count = 200;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf(c));
            }
        }
        //打乱
        Collections.shuffle(list);
        //将数据写入文件 每两百个一个文件
        for (int i = 0; i < 26; i++) {
            try {
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(url + (i + 1) + ".txt")));
                String collect = list.subList(i * count, (i + 1) * count).stream().collect(Collectors.joining("\n"));
                out.print(collect);
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }
        }
    }


}
