import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Graph {
	
	ArrayList<String> verticies;
	LinkedHashMap<String, String> edgeList;
	
	public Graph(String [][] graphIn) {
		verticies = new ArrayList<>();
		edgeList = new LinkedHashMap<>();
        String value = "";
		for(int i = 0; i < graphIn.length; i++) {
            verticies.add(graphIn[i][0]);
			for(int j = 1; j < graphIn[i].length; j++ ) {
			      value += graphIn[i][j];
			      if(j!=graphIn[i].length-1){
			          value+=",";
                  }
			}
			edgeList.put(verticies.get(i),value);
			value = "";
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
