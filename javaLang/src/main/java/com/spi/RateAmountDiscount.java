package com.spi;

public class RateAmountDiscount implements Discount{
    @Override
    public double calculate(int price, double amount) {
        double after = price * amount / 1000;
        System.out.println("原价" + price + ", 折后价：" + (price - after) );
        return price - after;
    }
}
