package project_ai;

import java.util.Scanner;

public class Project_AI {

    final static private String GOAL_STATE = "012345678";

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String rootState = "125340678";
        System.out.println("please enter 1)BFS , 2)DFS ?");
        int serchkey = s.nextInt();

        switch (serchkey) {
            case 1:
                long startTime = System.currentTimeMillis();
                SearchTree search = new SearchTree(new Node(rootState), GOAL_STATE);
                search.breadthFirstSearch();
                long finishTime = System.currentTimeMillis();
                long totalTime = finishTime - startTime;
                System.out.println("Time  :" + totalTime + " :Millis Seccend");
                break;
            case 2:
                long startTime2 = System.currentTimeMillis();
                SearchTree search2 = new SearchTree(new Node(rootState), GOAL_STATE);
                search2.depthFirstSearch();
                long finishTime2 = System.currentTimeMillis();
                long totalTime2 = finishTime2 - startTime2;
                System.out.println("Time  :" + totalTime2 + " :Millis Seccend");

                break;
            default:
                System.out.println("Rong answer");
        }

    }

}
