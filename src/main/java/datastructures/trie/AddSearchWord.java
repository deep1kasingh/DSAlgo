package datastructures.trie;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    public static class Trie {
        TrieNode root = new TrieNode();

        private void addWord(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        private boolean searchWord(String word, int start, TrieNode curr) {
            if (start == word.length() && curr.isWord) return true;
            if (start == word.length()) return false;
            char c = word.charAt(start);
            if (c == '.') {
                for (Character ci : curr.children.keySet()) {
                    if (searchWord(word, start + 1, curr.children.get(ci))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                return searchWord(word, start + 1, curr.children.get(c));
            }
        }
    }

    public static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();

    }

    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean search(String word) {
        return trie.searchWord(word, 0, trie.root);
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
