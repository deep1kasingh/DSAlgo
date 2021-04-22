package leetcode.importantAndUsefulLinks.dp;

import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return findLongestSubset(nums);
    }

    private List<Integer> findLongestSubset(int[] nums){
        List<List<Integer>> subsetList = new ArrayList<List<Integer>>(nums.length);
        int[] subsetCount = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            subsetList.add(i, new ArrayList<Integer>(Arrays.asList(nums[i])));
            subsetCount[i]=1;
        }

        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                List<Integer> currenSubset1 = subsetList.get(j);
                if(nums[j]%nums[i]==0){
                    List<Integer> currenSubset = subsetList.get(j);
                    updateList(subsetList,i,j, subsetCount, nums[i]);
                }
            }
        }

        int findMaxIdx = -1;
        int currMax = 0;
        for(int i=0;i<nums.length;i++){
            if(subsetCount[i]>currMax){
                currMax = subsetCount[i];
                findMaxIdx = i;
            }
        }
        if(findMaxIdx != -1){
            return subsetList.get(findMaxIdx);
        } else {
            return new ArrayList<>();
        }
    }

    private void updateList(List<List<Integer>> subsetList, int i, int j, int[] subsetCount, int el){
        if(subsetCount[i] < 1+subsetCount[j]){
            subsetCount[i] =  1+subsetCount[j];
            List<Integer> currenSubset = new ArrayList<>(subsetList.get(j));
            currenSubset.add(el);
            subsetList.set(i, currenSubset);
        }
    }
}

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(list,tempList,nums,used);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList(tempList));
        }
        for(int i=0;i<nums.length;i++){
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            tempList.add(nums[i]);
            used[i]=true;
            backtrack(list, tempList,nums,used);
            used[i]=false;
            tempList.remove(tempList.size()-1);
        }
    }
}


class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Set<Integer> tempSet = new HashSet<>();
        backtrack(list, tempList, tempSet, nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList,Set<Integer> tempSet, int[] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList(tempList));
        }
        for(int i=0;i<nums.length;i++){
            if(tempSet.contains(nums[i])) continue;
            tempList.add(nums[i]);
            tempSet.add(nums[i]);
            backtrack(list, tempList, tempSet, nums);
            tempList.remove(tempList.size()-1);
            tempSet.remove(nums[i]);
        }
    }
}


class subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(list, tempList, nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList(tempList));
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}


class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(list, tempList, 0, nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int start, int[] nums){
        list.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(list, tempList,i+1, nums);
            tempList.remove(tempList.size()-1);
        }
    }
}


class palindromepartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        findPalindromes(list,tempList, s, 0);
        return list;
    }

    private void findPalindromes(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length()){
            list.add(new ArrayList(tempList));
        } else {
            for(int i=start;i<s.length();i++){
                if(isPalindrome(s, start,i)){
                    tempList.add(s.substring(start,i+1));
                    findPalindromes(list, tempList,s,i+1);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        for(int i=start, j=end;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}



class combinationsum2
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(list, tempList, 0, target, candidates, 0);
        return list;
    }

    private boolean backtrack(List<List<Integer>> list, List<Integer> tempList, int start, int target, int[] candidates, int sum){
        if(target < sum){
            return false;
        } else if(target == sum){
            list.add(new ArrayList<>(tempList));
            return false;
        } else {
            boolean flag = true;
            for(int i=start;i<candidates.length && flag;i++){
                if(i > start && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                flag = backtrack(list, tempList, i+1, target, candidates, sum + candidates[i]);
                tempList.remove(tempList.size()-1);
            }
            return true;
        }
    }
}


class combiantionsum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(list, tempList, candidates, target, 0,0);
        return list;
    }

    private boolean backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int target, int sum, int start) {
        if(sum == target){
            list.add(new ArrayList<>(tempList));
            return false;
        } else if(sum > target) {
            return false;
        } else {
            boolean flag = true;
            for(int i=start;i<nums.length && flag;i++){
                tempList.add(nums[i]);
                flag = backtrack(list, tempList, nums, target, sum + nums[i], i);
                tempList.remove(tempList.size()-1);
            }
            return true;
        }
    }
}