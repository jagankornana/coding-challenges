package com.leetcode.course;

import java.util.Stack;

public class StockSpanner {

    Stack<StockSpan> stack = new Stack<>();

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

    public StockSpanner() {
    }

    public int next(int price) {
        int span = 0;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            StockSpan stock = stack.pop();
            span += stock.span;
        }
        stack.push(new StockSpan(price, span + 1));
        return span + 1;
    }
}

class StockSpan {
    int price;
    int span;

    StockSpan(int price, int span) {
        this.price = price;
        this.span = span;
    }
}
