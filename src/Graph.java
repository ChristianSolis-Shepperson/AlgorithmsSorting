import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Graph {
	
	ArrayList<String> verticies;
	HashMap<String, ArrayList<String>> edgeList;
	
	public Graph(String [][] graphIn) {
		verticies = new ArrayList<>();
		edgeList = new LinkedHashMap<>();
		for(int i = 0; i < graphIn.length; i++) {
            ArrayList<String> value = new ArrayList<>();
            verticies.add(graphIn[i][0]);
			for(int j = 1; j < graphIn[i].length; j++ ) {
			      value.add(graphIn[i][j]);
			}
			edgeList.put(verticies.get(i),value);
		}
	}

	public Graph() {
		verticies = new ArrayList<>();
		edgeList = new LinkedHashMap<>();
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
	    ArrayList<String> ender = edgeList.get(key);
		return ender;
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
		//System.out.println("v1: edge1, edge 2");
		return "";
	}
    public static String getVertexFromString(String str) {
        return str.substring(0, 1);
    }
    public static String getEdgesFromString(String str) {
        return str.substring(3, str.length());
    }

	public static void main (String [] args){
    }

}
