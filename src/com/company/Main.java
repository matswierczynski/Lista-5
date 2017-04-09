package com.company;

import java.util.EmptyStackException;

class Main {

    public static void main(String[] args) {
        Infixtopostfix _infixtopostfix = new Infixtopostfix();
        Compute cmp = new Compute();
        String s="(10+2)*5";
        try {
            String ONP = _infixtopostfix.convert(s);
            System.out.println(ONP);
            int wynik = cmp.compute(ONP);
            System.out.println(wynik);
        } catch (EmptyStackException e) {
            System.out.println("Stos jest pusty!");
        }
    }
}
