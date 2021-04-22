package leetcode.interviewqns;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> dictionary = new HashMap<>();
        for (String word : wordDict) {
            int indx = word.charAt(0) - 'a';
            List<String> list;
            if (!dictionary.containsKey(indx)) {
                list = new ArrayList<>();
            } else {
                list = dictionary.get(indx);
            }
            list.add(word);
            dictionary.put(indx, list);
        }
        for (Integer key : dictionary.keySet()) {
            List<String> dicTList = dictionary.get(key);
            Collections.sort(dicTList, (o1, o2) -> Integer.compare(o2.length(), o1.length()));
        }
        return getWords(dictionary, s, 0);
    }

    private boolean getWords(Map<Integer, List<String>> dictionary, String s, int currIdx) {
        if (currIdx == s.length()) {
            return true;
        }
        boolean containsWordsFlag = false;
        int alphaIndex = s.charAt(currIdx) - 'a';
        if (dictionary.containsKey(alphaIndex)) {
            List<String> list = dictionary.get(alphaIndex);
            for (int i = 0; i < list.size(); i++) {
                String word = list.get(i);
                int len = word.length();
                int nextIndx = currIdx + len;
                if (nextIndx <= s.length() && s.subSequence(currIdx, nextIndx).equals(word)) {
                    containsWordsFlag = containsWordsFlag || getWords(dictionary, s, nextIndx);
                }
            }
        }
        return containsWordsFlag;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }
}
