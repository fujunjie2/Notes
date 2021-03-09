package com.spi;

public class FixedAmountDiscount implements Discount{
    @Override
    public double calculate(int price, double amount) {
        System.out.println("原价" + price + ", 折后价：" + (price - amount) );
        return price - amount;
    }
}
