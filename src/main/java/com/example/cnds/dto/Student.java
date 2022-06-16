package com.example.cnds.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : wangjun
 * @date : 2021/11/19  15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String name;
    private Integer age;


    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new StudentBuilder().age(222).name("22718546362472").build());
        list.add(new StudentBuilder().age(222).name("22718540380203").build());
        list.add(new StudentBuilder().age(222).name("22718537389436").build());
        list.sort(Comparator.comparing(Student::getName,Comparator.reverseOrder()));
        System.out.println("www");
    }
}
