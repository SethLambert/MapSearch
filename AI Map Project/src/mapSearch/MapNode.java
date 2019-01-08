package mapSearch;
/*****************************************************
 * Seth Lambert
 * 2/11/18
 * Intro to Artificial Intelligence
 *
 * MapNode
 * 
 * Creates nodes that have one child, including both nodes
 * 	straight line distance and the path length.
 *
 *****************************************************/
import java.util.ArrayList;

public class MapNode {

	private String current, next;
	private int sld1, sld2, path;
	private boolean visited;
	private ArrayList<String> neighbors;
	
	public MapNode(String current, String next, int sld1, int sld2, int path){
		this.current = current;
		this.next = next;
		this.sld1=sld1;
		this.sld2=sld2;
		this.path=path;
		this.visited=false;
	}
	
	public MapNode(String string, boolean b, ArrayList temp1) {
		this.current = string;
		this.visited = b;
		this.neighbors = temp1;
	}

	public MapNode(String string) {
		this.current = string;
	}

	public String toString(){
		return (current + " to " + next + " in " + path + " meters.\n");
	}
	
	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getSld1() {
		return sld1;
	}

	public void setSld1(int sld1) {
		this.sld1 = sld1;
	}

	public int getSld2() {
		return sld2;
	}

	public void setSld2(int sld2) {
		this.sld2 = sld2;
	}

	public int getPath() {
		return path;
	}

	public void setPath(int path) {
		this.path = path;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public ArrayList<String> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<String> neighbors) {
		this.neighbors = neighbors;
	}

}
