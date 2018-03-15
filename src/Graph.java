import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Graph {
	
	ArrayList<String> verticies;
	HashMap<String, ArrayList<String>> edgeList;
	
	public Graph(String [][] graphIn) {
		verticies = new ArrayList<>();
		edgeList = new LinkedHashMap<>();
        ArrayList<String> value = new ArrayList<>();
		for(int i = 0; i < graphIn.length; i++) {
            verticies.add(graphIn[i][0]);
			for(int j = 1; j < graphIn[i].length; j++ ) {
			      value.add(graphIn[i][j]);
			}
			edgeList.put(verticies.get(i),value);
			value.clear();
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
	public ArrayList<String> getEdgeList(String key){
		return edgeList.get(key);
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
