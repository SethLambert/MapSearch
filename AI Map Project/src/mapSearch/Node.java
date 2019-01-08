package mapSearch;
/*****************************************************
 * Seth Lambert
 * 2/11/18
 * Intro to Artificial Intelligence
 *
 * Node
 * 
 * Essentially the same code shared in class.
 *
 *****************************************************/
import java.util.ArrayList;
import java.util.ArrayList;

public class Node {
	
	private String value;
	private boolean visited;
	private ArrayList<String> children;
	
	public Node(String value) {
		this.value = value;
		this.visited = false;
		this.children = new ArrayList<>();
	}
	
	public Node(String value, boolean visited, ArrayList<String> children) {
		this.value = value;
		this.visited = visited;
		this.children = children;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean getVisited() {
		return this.visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public ArrayList<String> getChildren() {
		return this.children;
	}
	
	public void setChildren(ArrayList<String> children) {
		this.children = children;
	}
	
	public void addChild(String child) {
		this.children.add(child);
	}
	
}
