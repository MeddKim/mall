package com.doge.eight.five;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupTest {


    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(2007,1500.0,Currency.EUR),
            new Transaction(2007,2300.0,Currency.USD),
            new Transaction(2007,9900.0,Currency.GBP),
            new Transaction(2007,1100.0,Currency.EUR),
            new Transaction(2007,7800.0,Currency.JPY),
            new Transaction(2007,6700.0,Currency.CHF),
            new Transaction(2007,5600.0,Currency.EUR),
            new Transaction(2007,4500.0,Currency.USD),
            new Transaction(2007,3400.0,Currency.CHF),
            new Transaction(2007,3200.0,Currency.GBP),
            new Transaction(2007,4600.0,Currency.USD),
            new Transaction(2007,5700.0,Currency.JPY),
            new Transaction(2007,6800.0,Currency.EUR),
            new Transaction(2007,7890.0,Currency.CNY),
            new Transaction(2008,8890.0,Currency.CNY)
    );
    //Collectors类提供的收集器的三大功能： 流元素规约汇总为一个值、元素分组、元素分区

    /**
     * 对列表进行分类
     */
    @Test
    public void groupTra(){
        Map<Currency,List<Transaction>> transactionsByCurrency = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));

//        transactionsByCurrency.forEach((key,item)->{
//            System.out.print(key + ":");
//            System.out.println(item.size());
//        });

        Map<CurrencyArea,List<Transaction>> currencyAreaListMap = transactions.stream()
                .collect(Collectors.groupingBy(
                        tra->{
                            switch (tra.getCurrency()){
                                case USD:
                                    return CurrencyArea.AMERICA;
                                case EUR:
                                    return CurrencyArea.DUROPE;
                                default:
                                    return CurrencyArea.NOLOG;
                            }
                        }
                ));

        currencyAreaListMap.forEach((key,item)->{
            System.out.print(key + ":");
            System.out.println(item.size());
        });
    }

    /**
     * 求取最大值
     */
    @Test
    public void getMaxTest(){
        Optional<Transaction> maxTra = transactions.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Transaction::getValue)));

        //不推荐
        Transaction maxTra3 = transactions.stream()
                .collect(Collectors.reducing(new Transaction(),
                        (a,b) -> a.getValue() > b.getValue()?a:b)
                );

        Optional<Double> maxTra1 = transactions.stream()
                .map(Transaction::getValue).reduce(Double::max);

        Optional<Double> maxTra2 = transactions.stream()
                .map(Transaction::getValue).reduce((aDouble, aDouble2) -> aDouble > aDouble2? aDouble:aDouble2);

        System.out.println(maxTra.get().getValue());
        System.out.println(maxTra1.get());
        System.out.println(maxTra1.get());
        System.out.println(maxTra3.getValue());
    }

    /**
     * 求和
     */
    @Test
    public void countTest(){
        double sum = transactions.stream()
                .collect(Collectors.summingDouble(Transaction::getValue));

        double sum1 = transactions.stream()
                .map(Transaction::getValue).reduce(Double.valueOf(0),(a,b) -> a + b);

        //推荐
        double sum2 = transactions.stream().mapToDouble(Transaction::getValue).sum();

        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);
    }
    /**
     * 求元素数量,总和，平均值，最大值，最小值
     */
    @Test
    public void summarizingTest(){
        DoubleSummaryStatistics doubleSummaryStatistics = transactions.stream()
                .collect(Collectors.summarizingDouble(Transaction::getValue));
        System.out.println("元素个数:" + doubleSummaryStatistics.getCount());
        System.out.println("总和:" + doubleSummaryStatistics.getSum());
        System.out.println("平均值:" + doubleSummaryStatistics.getAverage());
        System.out.println("最大值:" + doubleSummaryStatistics.getMax());
        System.out.println("最小值:" + doubleSummaryStatistics.getMin());
    }
}
