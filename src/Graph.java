import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph {

	ArrayList<String> verticies;
	HashMap<String, ArrayList<String>> edgeList;

	public Graph(String[][] graphIn) {

		// temp arraylist to store values for edgelist
		ArrayList<String> temp = new ArrayList<String>();

		// FIXME -- Should Work
		for (int i = 0; i < graphIn.length; i++) {
			for (int j = 1; j <= graphIn.length; j++) {
				verticies.add(graphIn[i][0]);
				temp.add(graphIn[i][j]);
			}
			edgeList.put(graphIn[i][0], temp);
			temp.clear(); //clears array for next set of edges of a vertex to be stored 
		}
	}

	public ArrayList<String> getVerticies() {

		return verticies;
	}

	public ArrayList<String> getEdgeList(String s) {

		return edgeList.get(s);
	}

	// FIXME
	@Override
	public String toString() {

		String result = "";

		// lambda expression to print each vertex and it's edges
		// edgeList.forEach((i,j)-> System.out.println(i+": "+ j));

		for (int i = 0; i < verticies.size(); i++) {
			for (int j = 0; j < edgeList.size(); j++) {
				result += verticies.get(i) + ": " + Arrays.asList(edgeList);
			}
		}

		return result;
	}

}
