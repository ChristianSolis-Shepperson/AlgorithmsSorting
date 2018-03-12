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
	
	public ArrayList<String> getVerticies() {
		return verticies;
	}
	
	public HashMap<String,String> getEdgeList(){
		return edgeList;
	}
	
	//FIXME
	@Override
	public String toString() {
		
		//example
		System.out.println("v1: edge1, edge 2");
		return "";
	}

}
