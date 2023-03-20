
import java.util.Arrays;

public class Main_one {
	public static int n;

	public static void main(String[] args) {
		int number = 0;
		
		Integer[][] arr = {{31, 10, 20, 19,  4,  3,  6},
				{25, 35, 45,  5, 25,  3,  2,  2}, 
				{3, 4, 3, 1, 3, 2, 3, 2, 1},
				{2, 10, 3, 8, 5, 7, 9, 5, 3, 2},
				{484, 114, 205, 288, 506, 503, 201, 127, 410},
				{23, 31,  29,  44,  53,  38,  63, 85, 89, 82},
				{771, 121, 281, 854, 885, 734,  486, 1003, 83, 62},
				{70, 73, 77, 80, 82, 87, 90, 94, 98, 106, 110, 113, 115, 118, 120},
				{382745, 799601, 909247, 729069, 467902,  44328,  34610, 698150, 823460, 903959, 853665, 551830, 610856, 670702, 488960, 951111, 323046, 446298, 931161,  31385, 496951, 264724, 224916, 169684}
				};
		for (int i = 0; i < arr.length; i++) {
			
			
			number++;
			System.out.println("\niteration "+number+" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			//create instance
			Partition_one p = new Partition_one();
			Integer[] TV = arr[i];
			p.setTV(TV);
			Integer[] VR = new Integer [TV.length];
			p.setVR(VR);
			
			
			//DFS
			long startTime_dfs = System.nanoTime();
				Node solution = Partition_one.dfs_one(p);
			long endTime_dfs = System.nanoTime();
			// Calculate the elapsed time
	        long elapsedTime_dfs = endTime_dfs - startTime_dfs;
	        
	        // print the TV
	        System.out.println("\nTV: " + Arrays.toString(p.getTV()));
	        // Print the elapsed time in milliseconds
	        System.out.println("Elapsed time: " + (elapsedTime_dfs / 1000000) + " ms");
	        if(solution == null) {
	        	// number of nodes generated to reach first solution
		        System.out.println("Nodes generated until ECHEC = " + Partition_one.getTotalNodes() + "\n");
		        //nodes visited to reach first solution
		        System.out.println("Nodes visited until ECHEC = " + Partition_one.getVisitedNodes() + "\n");
		        
	        	System.out.println("ECHEC");
	        }else {
	        	// number of nodes generated to reach first solution
		        System.out.println("Nodes generated to reach solution #0 = " + Partition_one.getTotalNodesSolution().get(0) + "\n");
		        //nodes visited to reach first solution
		        System.out.println("Nodes visited to reach solution #0 = " + Partition_one.getVisitedNodesSolution().get(0) + "\n");
		        
	        	//minimum difference
		        System.out.println("Difference = " + solution.diff);
	        }
	        
	       
	        Partition_one.reset();
	        
			//AStar
			long startTime_a = System.nanoTime();
				HNode solution_a = Partition_one.astar(p);
			long endTime_a = System.nanoTime();
			// Calculate the elapsed time
	        long elapsedTime_a = endTime_a - startTime_a;
	        
	        // print the TV
	        System.out.println("\nTV: " + Arrays.toString(p.getTV()));
	        // Print the elapsed time in milliseconds
	        System.out.println("Elapsed time: " + (elapsedTime_a / 1000000) + " ms");
	        if(solution == null) {
	        	// number of nodes generated to reach first solution
		        System.out.println("Nodes generated until ECHEC = " + Partition_one.getTotalNodes() + "\n");
		        //nodes visited to reach first solution
		        System.out.println("Nodes visited until ECHEC = " + Partition_one.getVisitedNodes() + "\n");
		        
	        	System.out.println("ECHEC");
	        }else {
	        	// number of nodes generated to reach first solution
		        System.out.println("Nodes generated to reach solution #0 = " + Partition_one.getTotalNodesSolution().get(0) + "\n");
		        //nodes visited to reach first solution
		        System.out.println("Nodes visited to reach solution #0 = " + Partition_one.getVisitedNodesSolution().get(0) + "\n");
		        
	        	//minimum difference
		        System.out.println("Difference = " + solution_a.diff);
	        }
	        
	       
	        Partition_one.reset();
		}
		
       
        
        
		
	}

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		Main.n = n;
	}
	
}
