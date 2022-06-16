package com.example.cnds.jdk8.collection;



import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : wangjun
 * @date : 2021/11/3  14:46
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<Score> scores = new ArrayList<>();
        scores.add(new Score(12,"xiaohong"));
        scores.add(new Score(14,"xiaohei"));
        scores.add(new Score(1,"xiaowang"));
        Collections.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.getScore() - o1.getScore();
            }
        });
        System.out.println(scores.toString());

        List<Integer> arr = new ArrayList<Integer>();
        arr.add(2);
        arr.add(4);
        arr.add(9);
        arr.add(1);
        Collections.reverse(arr);
        //只是反转而已
        System.out.println(arr);


        Score[] scoreArry = new Score[]{new Score(19, "xiaohong"), new Score(14, "xiaohei")};
        Arrays.sort(scoreArry);
        System.out.println(scoreArry[0].toString());


        Assert.assertTrue(scoreArry.length==2);

    }
}
