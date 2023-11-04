package com.poc.practice;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        char[] input = {'a', 'b', 's', 'r', 't'};
//        obj.reverseString(input);
        obj.reverseStringUsingRecursion(input);
    }

    public void reverseStringUsingRecursion(char[] s) {
        useRecursion(s, 0, s.length - 1);
    }

    private void useRecursion(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        useRecursion(s, left, right);
    }

    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }
    }
}
