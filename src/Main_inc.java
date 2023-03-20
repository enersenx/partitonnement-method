
import java.util.Arrays;

public class Main_inc {
	public static int n;

	public static void main(String[] args) {
		
		int m = 26;
		int n = 26;
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~DFS~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		for (int i = 4; i <= n; i=i+2) {
			
			
			System.out.println("\niteration "+i+" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			//create instance
			
			setN(i);
			Partition_one p = new Partition_one();
			p.generate_instance();
			
			
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
	        
		}
		
		System.out.println("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~ASTAR~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Partition_one.reset();
		
		
		
		for (int i = 4; i <= m; i=i+2) {
			
			System.out.println("\niteration "+i+" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			
			setN(i);
			Partition_one a = new Partition_one();
			a.generate_instance();
			
			//AStar
			long startTime_a = System.nanoTime();
				HNode solution_a = Partition_one.astar(a);
			long endTime_a = System.nanoTime();
			// Calculate the elapsed time
	        long elapsedTime_a = endTime_a - startTime_a;
	        
	        // print the TV
	        System.out.println("\nTV: " + Arrays.toString(a.getTV()));
	        // Print the elapsed time in milliseconds
	        System.out.println("Elapsed time: " + (elapsedTime_a / 1000000) + " ms");
	        if(solution_a == null) {
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
		Main_inc.n = n;
	}
	
}
