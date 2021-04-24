package edu.neu.psa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question2 {

    public static void main(String[] args) {

        int[][] prereq = {{1,0}};

        System.out.println(canFinish(2, prereq));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Queue<Integer> q = new LinkedList<Integer>();
        int coursesTaken = 0;

        int[] dependencyCount = new int[numCourses];

        ArrayList<Integer>[] dependencies = new ArrayList[numCourses];
        // initialize
        for(int p = 0; p < numCourses ; p++){
            dependencies[p] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < prerequisites.length ; i++){

            dependencies[prerequisites[i][0]].add(prerequisites[i][1]);

            dependencyCount[prerequisites[i][1]]++;
        }

        for(int i = 0 ; i < dependencyCount.length ; i++){

            //adding courses with no dependencies in queue
            if(dependencyCount[i] == 0){
                q.add(i);
                coursesTaken += 1;
            }
        }

        while(!q.isEmpty()){

            int course = q.poll();

            for(int i = 0; i < dependencies[course].size() ; i++){

                int index = dependencies[course].get(i);

                dependencyCount[index]--;

                if(dependencyCount[index] == 0){
                    coursesTaken += 1;
                    q.add(index);
                }
            }
        }

        return (coursesTaken != numCourses) ? false : true;
    }
}