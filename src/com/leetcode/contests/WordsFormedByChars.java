package com.leetcode.contests;

import java.util.HashMap;
import java.util.Map;

public class WordsFormedByChars {

    public static void main(String[] args) {
        WordsFormedByChars wordsFormedByChars = new WordsFormedByChars();
        System.out.println(wordsFormedByChars.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(wordsFormedByChars.countCharacters(new String[]{"hello", "world", "leetcode"}, "ollhe"));
    }

    private int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (char ch : chars.toCharArray()) {
            Integer count = map.get(ch);
            if (count != null) {
                count++;
                map.put(ch, count);
            } else {
                map.put(ch, 1);
            }
        }

        for (String word : words) {
            Map<Character, Integer> temp = new HashMap<>(map);
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                Integer count = temp.get(ch);
                if (count == null || count < 1) {
                    flag = false;
                    break;
                }
                temp.put(ch, --count);
            }
            if (flag) {
                result += word.length();
            }
        }

        return result;
    }
}
