package com.company;

import java.util.EmptyStackException;

class Infixtopostfix {
    private Stack<Character> operatorStack;
    private String postfix;

    public String convert (String infix){
        char [] charArray = infix.toCharArray();
        operatorStack = new Stack<>();
        postfix=" ";
        for(int i=0;i<charArray.length;i++) {
            if (isOperator(charArray[i])) {
                if (charArray[i] == '(' && i + 1 < charArray.length && charArray[i + 1] == '-') {
                    i = negativeDigit(i + 1, charArray);
                } else
                    processOperator(charArray[i]);
            }
            else{
                if(isOperand(charArray[i])){
                    postfix+=charArray[i];
                    if(i+1<charArray.length && !isOperand(charArray[i+1]))
                        postfix+=' ';
                }
                else
                    System.out.println("Niepoprawna komenda");

            }
        }
        while(!operatorStack.isEmpty())
            postfix+=" "+operatorStack.pop();
        return postfix;
    }

    private void processOperator (char op){
        if (operatorStack.isEmpty() || op=='(')
            operatorStack.push(op);
        else{
            char topOp=operatorStack.peek();
            if (precedence(op)>precedence(topOp))
                operatorStack.push(op);
            else{
                while (!operatorStack.isEmpty() && (precedence(op)<=precedence(topOp))) {
                    topOp = operatorStack.pop();
                    if(topOp!='(')
                        postfix += topOp+" ";
                    if(!operatorStack.isEmpty())
                        topOp=operatorStack.peek();
                }
                if(op!=')')
                    operatorStack.push(op);
                else {
                    if(!operatorStack.isEmpty())
                        operatorStack.pop();
                }
            }
        }

    }


    private int precedence(char op){
        switch (op){
            case '+': case '-':case ')': return 1;
            case '*':case '/':case '%': return 2;
            default: return 0;
        }
    }

    private int negativeDigit(int posiiton, char[] array){
        while(posiiton<array.length && array[posiiton]!=')'){
            postfix+=array[posiiton];
            posiiton++;
        }
        postfix+=" ";
        return posiiton;
    }

    public static boolean isOperator(char op){
        return (op == '+' || op == '-' || op =='*'
                || op == '/' || op=='%' || op == '(' || op == ')');
    }

    public static boolean isOperand(char op){
        return Character.isDigit(op);
    }

    public static boolean isPalindrome(String napis){
         Stack<Character> normalStack = new Stack<>();
         Stack<Character> reverseStack = new Stack<>();
        char [] Array = napis.toCharArray();
        for(int i=0;i<Array.length;i++){
            if(Array[i]!=' ')
                normalStack.push(Array[i]);
        }

        for(int i=Array.length-1;i>=0;i--){
            if(Array[i]!=' '){
                reverseStack.push(Array[i]);
            }
        }
try {
    while (normalStack.peek() == reverseStack.peek()) {
        normalStack.pop();
        reverseStack.pop();
    }
}

        catch(EmptyStackException e) { return true;}
        return false;
    }


}
