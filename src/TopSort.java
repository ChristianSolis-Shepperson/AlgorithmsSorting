/**
 * @author Dillon Sykes
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class does Depth-First Search and also SourceRemoval.
 */
public class TopSort {
    int [] vertexArray;
    int count = 0;
    ArrayList<String> edges;
    ArrayList<String> vertexs;
    ArrayList<String> VertexWithNoIncomingEdges = new ArrayList<>();
    ArrayList<String> tmp = new ArrayList<>();
    private boolean yesTheNextVertexWithNoIncomingEdgeHasTheSameAdjList;

    /**
     * Checks for cycle in graph for DFS methods.
     * @param g graph currently in question.
     * @return true if there is a cycle, false if not.
     */
    public boolean checkForCycleForDfs(Graph g){
        Stack stack = new Stack();
        ArrayList<String> Vertex = g.getVerticies();

        for (String V : Vertex) {
            ArrayList<String> edges = g.getEdgeList(V);
            stack.push(V);
            for (Object keysOnStack : stack) {
                for (String e : edges) {
                    if (keysOnStack == e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks for cycles in graphs for SourceRemoval.
     * @param g the graph currently being worked on.
     * @return true if there is a cycle, flase is not.
     */
    public boolean checkForCycleForSource(Graph g) {
        ArrayList<String> vertexCheck = new ArrayList<>();
        ArrayList<String> Vertex = g.getVerticies();

        for (String V : Vertex) {
            ArrayList<String> edges = g.getEdgeList(V);
            vertexCheck.add(V);
            for (String keysOnStack : vertexCheck) {
                for (String e : edges) {
                    if (keysOnStack == e) {
                        return true;
                    }
                }
            }
            vertexCheck.remove(0);
        }
        return false;
    }

    /**
     * This method get all the edges in the graph for use in later methods.
     * @param g graph that is currently in use.
     * @return all edges in graph.
     */
    public static ArrayList<String> getAllEdges(Graph g) {
        ArrayList<String> allEdges = new ArrayList<>();
        for (String V : g.verticies) {
            ArrayList<String> edges = g.getEdgeList(V);
            for (String e : edges) {
                allEdges.add(e);
            }
        }
        return allEdges;
    }

    /**
     * Method from book does a dfs recursively .
     * @param vertex Vertex that is currently being worked on.
     * @param g Graph currently in use to get edges.
     */
    public void dfs(String vertex, Graph g) {
        tmp.add(vertex);
        vertexs = g.getVerticies();
        count = count +1;
        vertexArray[vertexs.indexOf(vertex)] = count;
        edges = g.getEdgeList(vertex);
        if(edges.size() != 0){
            for(String e : edges){
                int indexOfEdgeInVertexArray = vertexs.indexOf(e);
                if(vertexArray[indexOfEdgeInVertexArray] == 0 && !yesTheNextVertexWithNoIncomingEdgeHasTheSameAdjList){
                    dfs(e,g);
                }
            }
        }
    }

    /**
     * Returns the a DFS of a graph.
     * took 10hrs to write.
     * @param g Graph to do DFS.
     * @return order that vertexs are visited.
     */
    public ArrayList<String> dfsTopSort(Graph g) {
        ArrayList<String> ender = new ArrayList<>();
		long startTime = System.nanoTime();
        vertexs = g.getVerticies();
        ArrayList<String> allEdges = getAllEdges(g);
		for(String V : g.verticies){
		    if(!allEdges.contains(V)){
		        VertexWithNoIncomingEdges.add(V);
            }
        }
        if(checkForCycleForDfs(g) || VertexWithNoIncomingEdges.size() == 0) {
            return null;
        }
        vertexArray = new int [g.verticies.size()];
		for(int i = 0; i < vertexArray.length; i++){
		    vertexArray[i] = 0;
        }
        for(int i = VertexWithNoIncomingEdges.size() - 1; i > -1; i--){
            String v = VertexWithNoIncomingEdges.get(i);
            if(i > 0) {
                ArrayList<String> currentEdgeList = g.getEdgeList(v);
                String next = VertexWithNoIncomingEdges.get(i - 1);
                ArrayList<String> nextEdgeList = g.getEdgeList(next);
                if(currentEdgeList.equals(nextEdgeList) ){
                    yesTheNextVertexWithNoIncomingEdgeHasTheSameAdjList = true;
                }
            }
            dfs(v, g);
            for(String s : tmp){
                ender.add(s);
            }
            tmp.clear();
            yesTheNextVertexWithNoIncomingEdgeHasTheSameAdjList = false;
        }
		long difference = System.nanoTime() - startTime;
		System.out.println("Elapsed Time: " + difference);
		return ender;
	}


    /**
     * Returns the sourceRemoval order of graph.
     * Took 1h to write.
     * @param g Graph to do Source Removal.
     * @return order that vertexs are removed.
     */
	public ArrayList<String> sourceTopSort(Graph g) {
        ArrayList<String> ender = new ArrayList<>();
		long startTime = System.nanoTime();
        ArrayList<String> allEdges = getAllEdges(g);

        for(String V : g.verticies){
            if(!allEdges.contains(V)){
                VertexWithNoIncomingEdges.add(V);
            }
        }
        if(checkForCycleForSource(g) || VertexWithNoIncomingEdges.size() == 0){
            return null;
        }
        vertexArray = new int [g.verticies.size()];
        for(int i = 0; i < vertexArray.length; i++){
            vertexArray[i] = 0;
        }
        for(int i = 0; i < VertexWithNoIncomingEdges.size(); i++) {
            String v = VertexWithNoIncomingEdges.get(i);
            if (i < VertexWithNoIncomingEdges.size() - 1) {
                ArrayList<String> currentEdgeList = g.getEdgeList(v);
                String next = VertexWithNoIncomingEdges.get(i + 1);
                ArrayList<String> nextEdgeList = g.getEdgeList(next);
                if (currentEdgeList.equals(nextEdgeList)) {
                    yesTheNextVertexWithNoIncomingEdgeHasTheSameAdjList = true;
                }
            }
            dfs(v, g);
            for (String s : tmp) {
                ender.add(s);
            }
            tmp.clear();
            yesTheNextVertexWithNoIncomingEdgeHasTheSameAdjList = false;
        }
		long difference = System.nanoTime() - startTime;
		System.out.println("Elapsed Time: " + difference);
		
		return ender;
	}
}
