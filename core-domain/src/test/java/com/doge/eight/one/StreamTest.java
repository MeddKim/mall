package com.doge.eight.one;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    //流：源（集合数组或输入/输出资源）-> 元素序列 -> 数据操作（filter、map、reduce、find、match、sort、limit、skip、distinct. etc）
    // map 接收一个函数，该函数被应用到每个元素上，并将其映射成一个新的元素
    // flatMap 扁平化一个流
    // 流只能消费一次
    //distinct: 对于Stream中包含的元素进行去重操作（去重逻辑依赖元素的equals方法）
    // reduce：规约，反复结合每个元素，直到流被规约成一个值

    @Test
    public void TestArrayStream(){
        String[] arrayOfWords = {"hello","world"};
//        将数组转为一个流
        Stream<String> stringOfWorld = Arrays.stream(arrayOfWords);

//        System.out.println(stringOfWorld.collect(Collectors.toList()));

//        List<String[]> worlds = Arrays.stream(arrayOfWords).map(word->word.split("")).distinct().collect(Collectors.toList());


    }
}
