package leetcode.importantAndUsefulLinks.garph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = createAdjList(prerequisites, numCourses);
        List<Integer> orderOfCourse = new ArrayList<>();
        boolean[] markVisited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++) {
            DFS(adjList, i, orderOfCourse, markVisited);
        }
        if(orderOfCourse.size() == numCourses){
            int[] orderOfCourseArray = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                orderOfCourseArray[i] = orderOfCourse.get(i);
            }
            return orderOfCourseArray;
        } else {
            return new int[numCourses];
        }
    }

    private void DFS(List<Integer>[] adjList, int x, List<Integer> orderOfCourse, boolean[] markVisited){
        if(!markVisited[x]){
            markVisited[x] = true;
            for(int i=0;i<adjList[x].size();i++){
                int beforeCourseId = adjList[x].get(i);
                DFS(adjList, beforeCourseId, orderOfCourse, markVisited);
            }
            orderOfCourse.add(x);
        }
    }

    private List<Integer>[] createAdjList(int[][] prerequisites, int numCourses) {
        List<Integer>[] adjList = new List[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<prerequisites.length;i++){
            if(prerequisites[i].length > 0) {
                int idx = prerequisites[i][0];
                for (int j = 1; j < prerequisites[i].length; j++) {
                    adjList[idx].add(prerequisites[i][j]);
                }
            }
        }
        return adjList;
    }

    public static void main(String[] args) {
//        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
//        int[][] prerequisites = new int[][]{{1,0}};
        int[][] prerequisites = new int[][]{{}};
        int[] anser = new CourseSchedule().findOrder(2, prerequisites);
        System.out.println("deepika");
    }
}
