package datastructures.trie;

import java.util.*;

/**
 * leetcode probelm: https://leetcode.com/problems/design-search-autocomplete-system/
 * Took me 1 hr 30 mins to solve
 */
class AutocompleteSystem {

    public static class Trie {
        TrieNode root = new TrieNode();

        private void insertWord(String sentence, int count) {
            TrieNode curr = root;
            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
                curr.wordToTimesMap.put(sentence, curr.wordToTimesMap.getOrDefault(sentence, 0) + count);
            }
        }

        private Map<String, Integer> getSentenceToCountMap(String prefix) {
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!curr.children.containsKey(c)) {
                    return new HashMap<>();
                }
                curr = curr.children.get(c);
            }
            return curr.wordToTimesMap;
        }
    }

    public static class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> wordToTimesMap;

        TrieNode() {
            children = new HashMap();
            wordToTimesMap = new HashMap<>();
        }
    }

    public static class CharValue {
        String word;
        int count;

        CharValue(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    Trie trie;
    String prefix = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            trie.insertWord(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            trie.insertWord(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        Map<String, Integer> wordToTimesMap = trie.getSentenceToCountMap(prefix);
        PriorityQueue<CharValue> pq = new PriorityQueue<>((a, b) -> (a.count == b.count) ? (a.word.compareTo(b.word)) : (b.count - a.count));

        for (String key : wordToTimesMap.keySet()) {
            pq.add(new CharValue(key, wordToTimesMap.get(key)));
        }

        List<String> result = new ArrayList<>();
        int i = 3;
        while (i-- > 0 && !pq.isEmpty()) {
            result.add(pq.poll().word);
        }
        return result;
    }

    public static void main(String[] args) {
        AutocompleteSystem acs = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                new int[]{5, 3, 2, 2});
        acs.input('i');
        acs.input(' ');
        acs.input('a');
        acs.input('#');
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
