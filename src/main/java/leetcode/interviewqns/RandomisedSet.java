package leetcode.interviewqns;

import java.util.*;

class RandomizedSet {
    Map<Integer,Integer> keyToIndexMapping;
    List<Integer> randomList;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        keyToIndexMapping = new HashMap<>();
        randomList = new ArrayList();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(keyToIndexMapping.containsKey(val)){
            return false;
        } else {
            randomList.add(randomList.size(),val);
            keyToIndexMapping.put(val, randomList.size()-1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!keyToIndexMapping.containsKey(val)){
            return false;
        }
        int idx = keyToIndexMapping.get(val);
        int lastVal = randomList.get(randomList.size()-1);
        randomList.set(idx, lastVal);
        randomList.remove(randomList.size()-1);
        keyToIndexMapping.put(lastVal, idx);
        keyToIndexMapping.remove(new Integer(val));
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return randomList.get(rand.nextInt(randomList.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());

    }
}