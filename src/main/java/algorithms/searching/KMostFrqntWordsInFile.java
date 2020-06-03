package algorithms.searching;

import java.io.File;
import java.util.*;

public class KMostFrqntWordsInFile {
    private static class CountOb {
        int wordCount;
        int minHeapIndex = -1;

        public CountOb(int wordCount, int minHeapIndex) {
            this.wordCount = wordCount;
            this.minHeapIndex = minHeapIndex;
        }
    }

    private static final String specialCharacters = "[-+.^:,]";
    private static HashMap<String, CountOb> wordCountMap = new HashMap<String, CountOb>();

    private static String[] find(String[] words, int k) throws Exception {
        String[] minHeap = new String[k];
        int wordIndex = 0;
        for (int j = 0; wordIndex < words.length && j < k; wordIndex++) {
            if (wordCountMap.containsKey(words[wordIndex])) {
                incrementWordCountMapCount(words[wordIndex]);
            } else {
                minHeap[j] = words[wordIndex];
                CountOb countOb = new CountOb(1, j);
                wordCountMap.put(words[wordIndex], countOb);
                j++;
            }
        }
        if (wordCountMap.keySet().size() < k)
            throw new Exception("No solution exists. Distinct word length less than k");
        buildMinHeap(minHeap);
        for (; wordIndex < words.length; wordIndex++) {
            if (wordCountMap.containsKey(words[wordIndex])) {
                incrementWordCountMapCount(words[wordIndex]);
                if(wordCountMap.get(words[wordIndex]).minHeapIndex != -1) {
                    minify(minHeap, wordCountMap.get(words[wordIndex]).minHeapIndex);
                } else if(wordCountMap.get(words[wordIndex]).wordCount > wordCountMap.get(minHeap[0]).wordCount){
                    minHeap[0] = words[wordIndex];
                    updateWordCountMapHeapIndex(minHeap[0], 0);
                    minify(minHeap, 0);
                }
            } else {
                CountOb countOb = new CountOb(1, -1);
                wordCountMap.put(words[wordIndex], countOb);
                if(wordCountMap.get(words[wordIndex]).wordCount > wordCountMap.get(minHeap[0]).wordCount){
                    minHeap[0] = words[wordIndex];
                    updateWordCountMapHeapIndex(minHeap[0], 0);
                    minify(minHeap, 0);
                }
            }
        }
        return minHeap;
    }

    private static void buildMinHeap(String[] minHeap) {
        int len = minHeap.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            minify(minHeap, i);
        }
    }

    private static void minify(String[] minHeap, int parent) {
        int leftChild = 2 * parent + 1;
        int rightChild = 2 * parent + 2;
        int minIndex = parent;
        if (leftChild < minHeap.length && wordCountMap.get(minHeap[leftChild]).wordCount < wordCountMap.get(minHeap[minIndex]).wordCount)
            minIndex = leftChild;
        if (rightChild < minHeap.length && wordCountMap.get(minHeap[rightChild]).wordCount < wordCountMap.get(minHeap[minIndex]).wordCount)
            minIndex = rightChild;
        if (minIndex != parent) {
            int minHeapIndex = wordCountMap.get(minHeap[minIndex]).minHeapIndex;
            int parentHeapIndex =  wordCountMap.get(minHeap[parent]).minHeapIndex;
            updateWordCountMapHeapIndex(minHeap[minIndex], parentHeapIndex);
            updateWordCountMapHeapIndex(minHeap[parent], minHeapIndex);
            swap(minHeap, minIndex, parent);
            minify(minHeap, minIndex);
        }
    }

    private static void swap(String[] minHeap, int i, int j) {
        String temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    private static void updateWordCountMapHeapIndex(String word, int index) {
        CountOb countOb = wordCountMap.get(word);
        countOb.minHeapIndex = index;
        wordCountMap.put(word, countOb);
    }

    private static void incrementWordCountMapCount(String word) {
        CountOb countOb = wordCountMap.get(word);
        countOb.wordCount = countOb.wordCount + 1;
        wordCountMap.put(word, countOb);
    }

    public static void main(String[] args) throws Exception {
        File myObj = new File("/Users/d0s03bk/Projects/learning/interview-codes/src/main/java/algorithms/searching/input.txt");
        Scanner myReader = new Scanner(myObj);
        List<String> listOfWords = new ArrayList<String>();
        while (myReader.hasNext()) {
            String data = myReader.nextLine().replaceAll(specialCharacters, "");
            listOfWords.addAll(Arrays.asList(data.split(" ")));
        }
        String[] arrayOfWords = new String[listOfWords.size()];
        listOfWords.toArray(arrayOfWords);
        String[] kMostFrqntWords = find(arrayOfWords, 5);
        for (int i = 0; i < kMostFrqntWords.length; i++) {
            System.out.println(kMostFrqntWords[i]);
        }
    }
}
