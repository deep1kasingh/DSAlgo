package datastructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        String s = "deepika";
        char[] inputS = s.toCharArray();
        Arrays.sort(inputS);
        System.out.println(new String(inputS));
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"deepika"});

        String wordWritten = "cat sand dog";
        System.out.println(wordWritten.substring(10));
    }


}
