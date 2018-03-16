import java.util.ArrayList;
import java.util.Stack;

public class TopSort {
    int [] vertexArray;
    int count = 0;
    ArrayList<String> edges;
    ArrayList<String> vertexs;
    ArrayList<String> ender = new ArrayList<>();
    ArrayList<String> VertexWithNoIncomingEdges = new ArrayList<>();
    ArrayList<String> tmp = new ArrayList<>();
    private boolean yesTheNextVertexWithNoIncomingEdgeHasTheSameAdjList;

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

    public ArrayList<String> dfsTopSort(Graph g) {
		long startTime = System.nanoTime();
        vertexs = g.getVerticies();
		if(checkForCycle(g)) {
            return null;
        }
        ArrayList<String> allEdges = getAllEdges(g);

		for(String V : g.verticies){
		    if(!allEdges.contains(V)){
		        VertexWithNoIncomingEdges.add(V);
            }
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



	public static ArrayList<String> sourceTopSort(Graph g) {
		long startTime = System.nanoTime();
		if(checkForCycle(g)) return null;
		
		//write code
		
		

		long difference = System.nanoTime() - startTime;
		System.out.println("Elapsed Time: " + difference);
		
		return new ArrayList<String>();
	}

}
