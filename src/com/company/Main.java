package com.company;

import java.util.EmptyStackException;

class Main {

    public static void main(String[] args) {
        Infixtopostfix _infixtopostfix = new Infixtopostfix();
        Compute cmp = new Compute();
        String s="((2+3)*2+2)%5";
        String s1="((10+2)*(2+3))/10";
        String s2="(2+2)/(2-2)";
        try {
            String ONP = _infixtopostfix.convert(s);
            System.out.println(ONP);
            int wynik = cmp.compute(ONP);
            System.out.println(wynik);

            ONP = _infixtopostfix.convert(s1);
            System.out.println(ONP);
            wynik = cmp.compute(ONP);
            System.out.println(wynik);

            ONP = _infixtopostfix.convert(s2);
            System.out.println(ONP);
            wynik = cmp.compute(ONP);
            System.out.println(wynik);

        } catch (EmptyStackException e) {
            System.out.println("Stos jest pusty!");
        }

        catch (ArithmeticException e) {System.out.println("Dzielenie przez zero");}



        String val1="oko";
        String val2="kajak";
        String val3="zakopane na pokaz";
        String val4="wrocław";
        String val5="algorytmy i struktury danych";

        System.out.println(val1+" "+Infixtopostfix.isPalindrome(val1));
        System.out.println(val2+" "+Infixtopostfix.isPalindrome(val2));
        System.out.println(val3+" "+Infixtopostfix.isPalindrome(val3));
        System.out.println(val4+" "+Infixtopostfix.isPalindrome(val4));
        System.out.println(val5+" "+Infixtopostfix.isPalindrome(val5));
    }
}
