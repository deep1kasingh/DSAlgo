package leetcode.importantAndUsefulLinks.garph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int m = rooms.size();
        if(m==0) return true;
        boolean[] markVisited = new boolean[m];
        int roomsVisited = DFS(rooms, 0, markVisited, 0, m);
        return roomsVisited == m;
    }

    private int DFS(List<List<Integer>> rooms, int x, boolean[] markVisited, int roomsVisited, int m) {
        if(!markVisited[x]) {
            List<Integer> roomsKeys = rooms.get(x);
            markVisited[x]=true;
            roomsVisited++;
            int tmp = roomsVisited;
            for(int i=0;i<roomsKeys.size();i++){
                if(tmp == m) break;
                int nextRoom = roomsKeys.get(i);
                tmp = DFS(rooms, nextRoom, markVisited, roomsVisited, m);
            }
            markVisited[x]=false;
            return tmp;
        }
        return roomsVisited;
    }

    public static void main(String[] args) {
        List<List<Integer>> keysAndRooms = new ArrayList<>();
        keysAndRooms.add(Arrays.asList(1,3));
        keysAndRooms.add(Arrays.asList(3,0,1));
        keysAndRooms.add(Arrays.asList(2));
        keysAndRooms.add(Arrays.asList(0));
        boolean anser = new KeysAndRooms().canVisitAllRooms(keysAndRooms);
        System.out.println(anser);
    }
}
