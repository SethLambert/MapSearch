package mapSearch;
/*****************************************************
 * Seth Lambert
 * 2/11/18
 * Intro to Artificial Intelligence
 *
 * Project 1
 * 
 * Gets map data from a text file and uses two basic searches to
 * 	find a route from one a starting location to a goal.
 * 
 * This program is set up with enough data to set up a best first
 * 	and A* search at a later time.
 *
 *****************************************************/
import java.io.*;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.LinkedList;

public class MapSearch {

	public static String start;
	public static String goal;
	static ArrayList<MapNode> allPaths = new ArrayList<MapNode>();
	
	public static void main(String[] args){
		
		//Breadth First Search
		loadMapFile("map.txt");
		LinkedList<LinkedList<MapNode>> mapList = loadLinkList(allPaths);
		ArrayList<Node> mapArrayList = loadMapArrayList(mapList);
//		for(int i=0;i<mapArrayList.size();i++){
//			System.out.println(mapArrayList.get(i).getValue()+mapArrayList.get(i).getChildren());
//		}
		BFS obj1 = new BFS();
		System.out.println("Breadth first search path: " + obj1.BFS(start, mapArrayList, goal));
		
		//Depth First Search
		loadMapFile("map.txt");
		LinkedList<LinkedList<MapNode>> mapList1 = loadLinkList(allPaths);
		ArrayList<Node> mapArrayList1 = loadMapArrayList(mapList);
		DFS obj2 = new DFS();
		System.out.println("Depth first search path: " + obj2.DFS(start, mapArrayList1, goal));
	}
	
	/**  loadMapArrayList
	 * Converts the LinkedList data into an ArrayList that works 
	 * 		with the BFS and DFS searches                        */
	private static ArrayList<Node> loadMapArrayList(
			LinkedList<LinkedList<MapNode>> mapList) {
		ArrayList<Node> v = new ArrayList();
		for(int i = 0;i<mapList.size();i++){
		ArrayList<String> children = new ArrayList();			
			LinkedList<MapNode> k = mapList.get(i);
			for(int j = 0;j<k.size()-1;j++){
				children.add(k.get(j).getNext());
			}
			String a;
			try {
	            a = k.get(0).getCurrent();
	        } catch (IndexOutOfBoundsException e) {
	            continue;}
			Node x = new Node(a, false, children);
			v.add(x);
		}
		return v;
	}

	/**  loadLinkList
	 * Collects the data from the allPaths ArrayList into a linkedList of 
	 * 		linkedList's. This contains MapNodes that have distance and 
	 * 		path distance data                						    */
	private static LinkedList<LinkedList<MapNode>> loadLinkList(
			ArrayList<MapNode> all) {
		LinkedList<LinkedList<MapNode>> mapList = new LinkedList<>();
		int k = 0, i=0;
		for(int j=0;k!=-1;j++){
			LinkedList<MapNode> list = new LinkedList<MapNode>();
			for(i=j;i<all.size()-1;i++){
				if(all.get(i).getCurrent().contentEquals(all.get(i+1).getCurrent())){
					list.add(all.get(i));
				}else{
					list.add(all.get(i));
					j=i;
					i=all.size()-1;
				}
			}list.add(all.get(all.size()-1));
			mapList.add(list);
			if(j>all.size()-1)
				k=-1;
		}
		return mapList;
	}

	/**loads data from the text file to the allPaths ArrayList**/
	private static void loadMapFile(String filename) {
		/***Reference: https://www.caveofprogramming.com/java/
				java-file-reading-and-writing-files-in-java.html**/
		String line = null;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(filename);

           // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            int lineNum = 1; //initialize line counter
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	
                //Get start and goal from first line
                if(lineNum == 1){
            		String get[] = line.split(":");
            		setStart(get[0]);
            		setGoal(get[1]);
            	}
                
                //Get node data from each line
                String current="", next="";
                int sld1=0, sld2=0, path=0;
                if(lineNum > 1){
                	String get[] = line.split(",");
               		String k[] = get[0].split("-");
               		current = k[0];
                   	sld1 = Integer.parseInt(k[1]);
                   	k = get[1].split("-");
                   	next = k[0];
                   	sld2 = Integer.parseInt(k[1]);
                   	path = Integer.parseInt(get[2]);
                }
                MapNode j = new MapNode(current, next, sld1, sld2, path);
                if(lineNum>1)
                	allPaths.add(j);
                lineNum++;
                
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                filename + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filename + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
	

	public static String getStart() {
		return start;
	}


	public static void setStart(String start) {
		MapSearch.start = start;
	}


	public static String getGoal() {
		return goal;
	}


	public static void setGoal(String goal) {
		MapSearch.goal = goal;
	}
}
