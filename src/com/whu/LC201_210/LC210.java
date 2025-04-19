package com.whu.LC201_210;
import java.util.*;
public class LC210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 入度数组
        int[] inDegree = new int[numCourses];

        // 邻接表
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        // 计算每门课的入度，构建邻接表
        for(int[] prerequisite:prerequisites){
            int disCourse = prerequisite[0];
            int preCourse = prerequisite[1];
            inDegree[disCourse]++;
            adjList.get(preCourse).add(disCourse);
        }

        // 找到入度为0的课程列表队列
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        // 记录已经完成的课程数量
        int count=0;
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int selectedCourse = queue.poll();
            ans.add(selectedCourse);
            count++;
            // 后续的列表
            List<Integer> nextCourses = adjList.get(selectedCourse);
            for(int nextCourse:nextCourses){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse]==0){
                    queue.offer(nextCourse);
                }
            }
        }
        if(count!=numCourses){
            return new int[]{};
        }
        return ans.stream().mapToInt(o->o).toArray();
    }
}
