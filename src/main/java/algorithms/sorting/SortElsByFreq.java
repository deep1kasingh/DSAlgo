package algorithms.sorting;

import java.util.*;

public class SortElsByFreq {

    class ElAndIndx {
        int value;
        int index;

        public ElAndIndx(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    class IndexAndCount {
        int index;
        int count;

        public IndexAndCount(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    private ArrayList<Integer> sortElem(ArrayList<Integer> arr) {
        ArrayList<ElAndIndx> elAndIndxes = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            ElAndIndx elAndIndx = new ElAndIndx(arr.get(i), i);
            elAndIndxes.add(elAndIndx);
        }
        //TC: O(nlogn) SC: O(3n)
        Collections.sort(elAndIndxes, (o1, o2) -> o1.value < o2.value ? -1 : 1);
        //TC: O(n) SC: O(3n)
        ArrayList<IndexAndCount> indexAndCounts = new ArrayList<>();
        int num = elAndIndxes.get(0).value;
        int index = elAndIndxes.get(0).index;
        int countOfNum = 1;
        for(int i=1;i<elAndIndxes.size();i++){
            if(elAndIndxes.get(i).value == num){
                countOfNum++;
            } else {
                indexAndCounts.add(new IndexAndCount(index, countOfNum));
                index = elAndIndxes.get(i).index;
                num = elAndIndxes.get(i).value;
                countOfNum = 1;
            }
        }
        indexAndCounts.add(new IndexAndCount(index, countOfNum));
        Collections.sort(indexAndCounts, (o1, o2) -> {
            if(o1.count > o2.count) return -1;
            else if(o1.count > o2.count) return 1;
            else {
                if(o1.index < o2.index) return -1;
                else return 1;
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<indexAndCounts.size();i++){
            for(int j=0;j<indexAndCounts.get(i).count;j++){
                result.add(arr.get(indexAndCounts.get(i).index));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SortElsByFreq sortElsByFreq = new SortElsByFreq();
        ArrayList<Integer> inputs = new ArrayList<Integer>(Arrays.asList(2, 5, 2, 8, 5, 6, 8, 8));
        ArrayList<Integer> result = sortElsByFreq.sortElem(inputs);
//        for(int i=0;i<result.size();i++){
//            System.out.println(result.get(i));
//        }

        ArrayList<Integer> inputs1 = new ArrayList<Integer>(Arrays.asList(2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8));
        ArrayList<Integer> result1 = sortElsByFreq.sortElem(inputs1);
        for(int i=0;i<result1.size();i++){
            System.out.println(result1.get(i));
        }
    }
}
