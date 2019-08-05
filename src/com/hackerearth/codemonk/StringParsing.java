package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringParsing {

    public static int evaluateExpression(String str) {

        char ch = str.charAt(1);                                    //getting operator
        int expValue = Integer.parseInt(str.substring(2, 3));        //getting first operand

        for (int i = 3; i < str.length() - 1; i++) {                //parsing the entire string within braces
            String subStr = str.substring(i, i + 1);
            if (subStr.equals("(")) {
                int j = i;
                Stack<Character> stack = new Stack<Character>();    //stack to find balanced parenthesis
                stack.push(str.charAt(i));
                while (!stack.isEmpty()) {
                    i++;
                    if (str.charAt(i) == '(')
                        stack.push('(');
                    else if (str.charAt(i) == ')')
                        stack.pop();
                }
                //recursively calling the method
                if (ch == '+')
                    expValue += evaluateExpression(str.substring(j, i + 1));
                else if (ch == '-')
                    expValue -= evaluateExpression(str.substring(j, i + 1));
                else if (ch == '*')
                    expValue *= evaluateExpression(str.substring(j, i + 1));
                else if (ch == '/')
                    expValue /= evaluateExpression(str.substring(j, i + 1));

            } else {
                //based on the operator, evaluating the expression
                if (ch == '+')
                    expValue += Integer.parseInt(subStr);
                else if (ch == '-')
                    expValue -= Integer.parseInt(subStr);
                else if (ch == '*')
                    expValue *= Integer.parseInt(subStr);
                else if (ch == '/')
                    expValue /= Integer.parseInt(subStr);
            }
        }

        return expValue;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int output = evaluateExpression(input);
        System.out.println(output);
    }
}
