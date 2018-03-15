import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TopSort {

    public static boolean checkForCycle(Graph g){
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

	public static ArrayList<String> dfsTopSort(Graph g) {
		long startTime = System.nanoTime();
		if(checkForCycle(g)) {
            return null;
        }
        ArrayList<String> allEdges = getAllEdges(g);
        ArrayList<String> VertexWithNoIncomingEdges = new ArrayList<>();
		for(String V : g.verticies){
		    if(!allEdges.contains(V)){
		        VertexWithNoIncomingEdges.add(V);
            }
        }
        ArrayList<String> ender = new ArrayList<>();
        for(int i = VertexWithNoIncomingEdges.size() - 1; i > -1; i--){
            String current = VertexWithNoIncomingEdges.get(i);
            ArrayList<String> currentEdgeList = g.getEdgeList(current);
            if(i > 0) {
                String next = VertexWithNoIncomingEdges.get(i - 1);
                ArrayList<String> nextEdgeList = g.getEdgeList(next);
                if(!currentEdgeList.equals(nextEdgeList) ){
                    ender.add(current);
                    for(String e : currentEdgeList){
                        ender.add(e);
                    }
                } else {
                    ender.add(current);
                }
            } else {
                ender.add(current);
                for(String e : currentEdgeList){
                    ender.add(e);
                }
                String lastKey = ender.get(ender.size()-1);
                ArrayList<String> lastKeyEdges = g.getEdgeList(lastKey);
                for(String e : lastKeyEdges){
                    ender.add(e);
                }
            }
        }
		//write code
		
		

		long difference = System.nanoTime() - startTime;
		System.out.println("Elapsed Time: " + difference);
		
		return ender;
	}

	public void dfs(String vertex, Graph g) {

	}

	public static ArrayList<String> sourceTopSort(Graph g) {
		long startTime = System.nanoTime();
		if(checkForCycle(g)) return null;
		
		//write code
		
		

		long difference = System.nanoTime() - startTime;
		System.out.println("Elapsed Time: " + difference);
		
		return new ArrayList<String>();
	}

}
