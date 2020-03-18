package project_ai;
import java.util.*;

public class SearchTree {
    private Node root;
    private String goalSate;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public String getGoalSate() {
        return goalSate;
    }

    public void setGoalSate(String goalSate) {
        this.goalSate = goalSate;
    }

    public SearchTree(Node root, String goalSate) {
        this.root = root;
        this.goalSate = goalSate;
    }

    public void breadthFirstSearch() {
    
        Set<String> stateSets = new HashSet<>();
        int totalCost = 0;
        int time = 0;
        Node node = new Node(root.getState());
        Queue<Node> queue = new LinkedList<>();
        Node currentNode = node;
        while (!currentNode.getState().equals(goalSate)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                queue.add(child);

            }
            currentNode = queue.poll();
            time += 1;
        }

        NodeUtil.printSolution(currentNode, stateSets, root, time);

    }


    public void depthFirstSearch() {
  
        Set<String> stateSets = new HashSet<>();
        int totalCost = 0;
        int time = 0;
        Node node = new Node(root.getState());
      
        MyQueue<Node> mainQueue = new MyQueue<>();
 
        MyQueue<Node> successorsQueue = new MyQueue<>();
        Node currentNode = node;
        while (!currentNode.getState().equals(goalSate)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                successorsQueue.enqueue(child);

            }
     
            mainQueue.addQueue(successorsQueue);
       
            successorsQueue.clear();
            currentNode = mainQueue.dequeue();
            time += 1;
            nodeSuccessors.clear();
        }
        NodeUtil.printSolution(currentNode, stateSets, root, time);

    }


  
    public void uniformCostSearch() {
    
        Set<String> stateSets = new HashSet<>();
        int totalCost = 0;
        int time = 0;
        Node node = new Node(root.getState());
        node.setCost(0);

        NodePriorityComparator nodePriorityComparator = new NodePriorityComparator();

        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(10, nodePriorityComparator);
        Node currentNode = node;
        while (!currentNode.getState().equals(goalSate)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                child.setTotalCost(currentNode.getTotalCost() + Character.getNumericValue(child.getState().charAt(child.getParent().getState().indexOf('0'))), 0);
                nodePriorityQueue.add(child);

            }
            currentNode = nodePriorityQueue.poll();
            time += 1;
        }
        NodeUtil.printSolution(currentNode, stateSets, root, time);

    }

    public void bestFirstSearch() {
   
        Set<String> stateSets = new HashSet<>();
        int totalCost = 0;
        int time = 0;
        Node node = new Node(root.getState());
        node.setCost(0);

      
        NodePriorityComparator nodePriorityComparator = new NodePriorityComparator();

        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(10, nodePriorityComparator);
        Node currentNode = node;
        while (!currentNode.getState().equals(goalSate)) {
            stateSets.add(currentNode.getState());
            List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);

                
                nodePriorityQueue.add(child);

            }
            currentNode = nodePriorityQueue.poll();
            time += 1;
        }
     
        NodeUtil.printSolution(currentNode, stateSets, root, time);

    }


}