import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	
	ArrayList<String> verticies;
	HashMap<String, String> edgeList;
	
	public Graph(String [][] graphIn) {
		
		for(int i = 0; i < graphIn.length; i++) {
			for(int j = 0; j < graphIn.length; j++ ) {
			verticies.add(graphIn[i][0]);
			edgeList.put(graphIn[i][0], graphIn[i][j]);
			}
		}	
	}

    /**
     * Returns the values in the vertices instance variable.
     * @return the values in the vertices instance variable.
     */
	public ArrayList<String> getVerticies() {
		return verticies;
	}

    /**
     *
     * @return
     */
	public HashMap<String,String> getEdgeList(){
		return edgeList;
	}

    /**
     *
     * @return Returns the graph as a list of vertices, and the edges associated with them. Format:
     *
     *           v1: edge1, edge2, ...
     *
     *           v2: edge1, edge2 ...
     *
     *           etc for each vertex
     */
	@Override
	public String toString() {
		
		//example
		System.out.println("v1: edge1, edge 2");
		return "";
	}

}
