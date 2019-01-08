package mapSearch;
/*****************************************************
 * Seth Lambert
 * 2/11/18
 * Intro to Artificial Intelligence
 *
 * BFS
 * 
 * Essentially the same code shared in class.
 *
 *****************************************************/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public String BFS(String s0, ArrayList<Node> v, String goal){
		String path = "";
		Queue queue = new LinkedList();
		Node s0Node = findNode(s0, v);
		s0Node.setVisited(true);
		queue.add(s0Node);
		
		while(!queue.isEmpty()){
			Node tNode = (Node)queue.remove();
			if(tNode.getValue().equalsIgnoreCase(goal)){
				path += goal;
				return path;
			}
			path += tNode.getValue();
			
			ArrayList<String> neighborList = tNode.getChildren();
			
			if(neighborList==null) continue;
			
			for(int i=0; i<neighborList.size(); i++){
				String child = neighborList.get(i);
				Node uNode = findNode(child, v);
				if (!uNode.getVisited()){
					uNode.setVisited(true);
					queue.add(uNode);
				}//end if
			}// end for
		}//end while
		System.out.println(path);
		return path;
	}//end BFS
	
	public Node findNode(String name, ArrayList<Node> v){
		for(int i=0; i<v.size(); i++){
			Node aNode = v.get(i);
			if(aNode.getValue().equalsIgnoreCase(name)){
				return aNode;
			}
		}return null;
	}

//public static void main(String args[]){
//	String s0 = "a";
//	String goal = "e";
//	ArrayList<MapNode> v = new ArrayList();
//	ArrayList temp1 = new ArrayList();
//	temp1.add("b");
//	temp1.add("c");
//	// Create node a
//	v.add(new MapNode("a", false, temp1));
//	ArrayList temp2 = new ArrayList();
//	temp2.add("d");
//	temp2.add("e");
//	// Create node b
//	v.add(new MapNode("b", false, temp2));
//	ArrayList temp3 = new ArrayList();
//	temp3.add("f");
//	// Create node c
//	v.add(new MapNode("c", false, temp3));
//	// Creat nodes d, e, f
//	v.add(new MapNode("d"));
//	v.add(new MapNode("e"));
//	v.add(new MapNode("f"));
//	
//	BFS obj = new BFS();
	//System.out.println(obj.BFS(s0, v, goal));
//}
}
