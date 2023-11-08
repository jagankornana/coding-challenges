package com.leetcode.course;

import java.util.ArrayList;

public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath obj = new SimplifyPath();
        System.out.println(obj.simplifyPath("/../abc"));
    }

    public String simplifyPath(String path) {
        ArrayList<String> list = new ArrayList<>();
        for (String str : path.split("/")) {
            if (str.isEmpty() || str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(str);
            }
        }
        return "/" + String.join("/", list);
    }
}
