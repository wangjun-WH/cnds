package com.example.cnds.jdk8.collection;

/**
 * @author : wangjun
 * @date : 2021/11/3  14:47
 */
public class Score implements Comparable<Score> {
    private Integer score;
    private String name;

    public Score(Integer score, String name) {
        this.score = score;
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Score o) {
        return score - o.score;
    }
}
