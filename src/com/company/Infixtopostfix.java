package com.company;

class Infixtopostfix {
    private Stack<Character> operatorStack;
    private String postfix;

    public String convert (String infix){
        char [] charArray = infix.toCharArray();
        operatorStack = new Stack<>();
        postfix=" ";
        for(int i=0;i<charArray.length;i++){
            if(isOperator(charArray[i])){
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

    public static boolean isOperator(char op){
        return (op == '+' || op == '-' || op =='*'
                || op == '/' || op == '(' || op == ')');
    }

    public static boolean isOperand(char op){
        return Character.isDigit(op);
    }


}
