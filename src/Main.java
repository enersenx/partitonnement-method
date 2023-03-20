
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
	
	public static int n;

	public static void main(String[] args) {
/*
		System.out.println("introduisez la taille du tableau :");
		Scanner scan = new Scanner(System.in);
		int i=scan.nextInt();
		setN(i);
		System.out.println("n in main :"+n);
		
		//create instance
		Partition p = new Partition();
		
		//generate an instance of the problem
		p.generate_instance();
		
		//generate an instance of VR
		p.generate_instance_VR();
		System.out.println("Validity of generated VR :");
		System.out.println(p.verify_partition(p.getTV(), p.getVR()));
		
		//examples to test verify method
		Integer[] TV_example = {1,2,5,10,9,15,21,19,-4,7,12,6,3};
		Integer[] VR_valid = {0,0,1,0 ,1,1 ,1 ,0 ,1 ,1,0 ,0,0};
		Integer[] VR_not_valid = {0,0,1,0 ,1,1 ,2 ,0 ,null,1,0 ,0,0};
		Integer[] VR_not_valid_2 = {0,0,0,0 ,0,0 ,0 ,0 ,null,0,0 ,0,0};
		
		System.out.println("Validité de VR not valid en exemple :");
		System.out.println(p.verify_partition(TV_example, VR_not_valid));
		
		System.out.println("Validité de VR not valid 2 en exemple :");
		System.out.println(p.verify_partition(TV_example, VR_not_valid_2));
		
		System.out.println("Validité de VR valid en exemple :");
		System.out.println(p.verify_partition(TV_example, VR_valid));
		
	
		//evaluate solution
		System.out.println("Evaluation de VR_valid :");
		System.out.println(p.evaluate_solution(TV_example, VR_valid));
	*/
		
		
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
			Partition p = new Partition();
			Integer[] TV = arr[i];
			p.setTV(TV);
			Integer[] VR = new Integer [TV.length];
			p.setVR(VR);
			
			//DFS
			List<Integer> totalNodesSolution = Partition.getTotalNodesSolution();
	        
	    	
			long startTime_dfs = System.nanoTime();
				List<Node> solutions = Partition.dfs(p);
			long endTime_dfs = System.nanoTime();
			// Calculate the elapsed time
	        long elapsedTime_dfs = endTime_dfs - startTime_dfs;
	        
	        // print the TV
	        System.out.println("\nTV: " + Arrays.toString(p.getTV()));
	        // Print the elapsed time in milliseconds
	        System.out.println("Elapsed time: " + (elapsedTime_dfs / 1000000) + " ms");
	       // number of solutions in solution space
	        System.out.println("Found " + solutions.size() + " solutions:");
	        // number of nodes in solution space
	        System.out.println("Nodes generated for solution space: " + Partition.getTotalNodes() + "\n");
	        //minimum difference
	        System.out.println("Difference = " + Partition.getBestNode().diff);
	        //nodes generated to reach first solution
	        System.out.println("Nodes generated to reach solution #0 = " + totalNodesSolution.get(0) + "\n");
	        
	        
	        // list of optimal solutions 
	        int optimumCount = 0;
	        
	        try {
	        	
	        	String name_file = "output" + number + ".txt";
				PrintWriter writer = new PrintWriter(name_file, "UTF-8");
				
				System.out.println("All optimal solutions dfs. . .");
			        for (Node element : solutions) {
			            //System.out.println(Arrays.toString(element.partition));
			        	if(element.diff == Partition.getBestNode().diff) {
			        		writer.println(Arrays.toString(element.partition));
			        		optimumCount++;
			        	}
			        }
			        System.out.println("Number of optimal solutions: "+ optimumCount);
			        writer.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        Partition.reset();
		}
		
       
        
        
		
	}

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		Main.n = n;
	}

	
	

}
