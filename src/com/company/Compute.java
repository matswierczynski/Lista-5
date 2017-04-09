package com.company;

@SuppressWarnings("DefaultFileTemplate")
class Compute {
    private Stack<Integer> digitStack;

    public int compute(String chain) {
        char[] charArray = chain.toCharArray();
        digitStack = new Stack<>();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] != ' ') {
                if (Infixtopostfix.isOperator(charArray[i])) {
                    if (Infixtopostfix.isOperand(charArray[i + 1])) {

                        i = addDigit(i , charArray);
                    } else {
                        processOperator(charArray[i]);
                    }
                } else {
                    i = addDigit(i, charArray);
                }
            }
        }
        processOperator(charArray[charArray.length-1]);
        return digitStack.pop();
    }
    private void processOperator(char operator) {
        switch (operator) {
            case '+': {
                digitStack.push(digitStack.pop() + digitStack.pop());
                break;
            }

            case '-': {
                int right = digitStack.pop();
                digitStack.push(digitStack.pop() - right);
                break;
            }

            case '/': {
                int right = digitStack.pop();
                digitStack.push(digitStack.pop() / right);
                break;
            }

            case '*': {
                int right = digitStack.pop();
                digitStack.push(digitStack.pop() * right);
                break;

            }

            case '%': {
                int right = digitStack.pop();
                digitStack.push(digitStack.pop() % right);
                break;
            }

        }
    }

    private int addDigit(int position, char[] array) {
        StringBuilder tmp = new StringBuilder(Character.toString(array[position]));
        position++;
        while (position<array.length && array[position] != ' ' ) {
            tmp.append(array[position]);
            position++;
        }
        digitStack.push(Integer.parseInt(tmp.toString()));
        return position;
    }

}