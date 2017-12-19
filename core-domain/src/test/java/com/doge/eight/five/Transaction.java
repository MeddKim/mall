package com.doge.eight.five;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int year;
    private double value;
    private Currency currency;
    private Trader trader;

    public Transaction(int year,double value,Currency currency){
        this.year = year;
        this.value = value;
        this.currency = currency;
    }
}
