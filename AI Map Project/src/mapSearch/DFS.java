package mapSearch;
/*****************************************************
 * Seth Lambert
 * 2/11/18
 * Intro to Artificial Intelligence
 *
 * DFS
 * 
 * Essentially the same code shared in class.
 *
 *****************************************************/
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	public String DFS(String s0, ArrayList<Node> v, String goal){
		String path = "";
		Stack stack = new Stack();
		Node s0Node = findNode(s0, v);
		s0Node.setVisited(true);
		stack.push(s0Node);
		
		while(!stack.isEmpty()){
			Node tNode = (Node)stack.pop();
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
					stack.push(uNode);
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
//	ArrayList<Node> v = new ArrayList();
//	ArrayList temp1 = new ArrayList();
//	temp1.add("b");
//	temp1.add("c");
//	// Create node a
//	v.add(new Node("a", false, temp1));
//	ArrayList temp2 = new ArrayList();
//	temp2.add("d");
//	temp2.add("e");
//	// Create node b
//	v.add(new Node("b", false, temp2));
//	ArrayList temp3 = new ArrayList();
//	temp3.add("f");
//	// Create node c
//	v.add(new Node("c", false, temp3));
//	// Creat nodes d, e, f
//	v.add(new Node("d"));
//	v.add(new Node("e"));
//	v.add(new Node("f"));
//	
//	DFS obj = new DFS();
//	System.out.println(obj.DFS(s0, v, goal));
//}
}

