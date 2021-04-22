package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordSearch2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> resultArr = new ArrayList<String>();
        String[] memo = new String[s.length()];
        backtrack(s, 0, new HashSet<>(wordDict), resultArr, "", memo);
        return resultArr;
    }

    private String backtrack(String word, int start, HashSet<String> wordDict, List<String> result, String curr, String[] memo){
        if(start == word.length()) {
            result.add(curr);
            return curr;
        }
        if(memo[start] != null){
            return memo[start];
        }
        String wordWritten = "";
        for(int j=start+1; j<=word.length(); j++){
            String subWord = word.substring(start, j);
            if(wordDict.contains(subWord)){
                if(curr.isEmpty()){
                    wordWritten = backtrack(word, j, wordDict, result, subWord, memo);
                } else {
                    wordWritten = backtrack(word, j, wordDict, result, curr + " " + subWord, memo);
                }
                if(!wordWritten.isEmpty() && j<word.length()){
                    memo[j-1] = wordWritten.substring(j-1);
                }
            }
        }
        return wordWritten;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        new WordSearch2().wordBreak(s, dict);
    }
}
