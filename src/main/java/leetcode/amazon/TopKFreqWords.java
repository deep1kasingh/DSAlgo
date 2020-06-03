package leetcode.amazon;

import java.util.*;

public class TopKFreqWords {

    private List<String> find(String[] words, int k) {
        Map<String, Integer> freqOfWordsMap = new HashMap<>();
        for (String word : words) {
            freqOfWordsMap.put(word, freqOfWordsMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (String o1, String o2) -> freqOfWordsMap.get(o1) == freqOfWordsMap.get(o2) ?
                        o2.compareTo(o1) : freqOfWordsMap.get(o1) - freqOfWordsMap.get(o2));
        for (String word : freqOfWordsMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }
        List<String> resultArr = new ArrayList<>();
        while (!heap.isEmpty()) {
            resultArr.add(heap.poll());
        }
        Collections.reverse(resultArr);
        return resultArr;
    }

    public static void main(String[] args) {

    }
}
