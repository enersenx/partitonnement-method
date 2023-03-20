import java.io.*;
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
	
	//structure to modelise solution
		//TV vector for the initial array
		//VR vector for the chosen values
	private Integer[] TV = new Integer [Main.getN()];
		//takes 1 if element in S1
		//takes 0 if element in S2
	private Integer[] VR = new Integer [Main.getN()];
	
	//generate instance
	public void generate_instance() {
		Random rand = new Random();
		for (int i = 0; i < TV.length; i++) {
            this.TV[i] = rand.nextInt(100); // generates a random integer between 0 and 99
        }
	}
	
	//generate VR instance
			public void generate_instance_VR() {
				Random rand = new Random();
				for (int i = 0; i < TV.length; i++) {
		            this.VR[i] = rand.nextInt(3); // generates a random integer between 0 and 1 and 2
		        }
		        System.out.println("TV: " + Arrays.toString(TV));
		        System.out.println("VR: " + Arrays.toString(VR));
			}
	
	//verify validity
	//constraints
		//toutes les cases sont remplies par 0 ou 1
		//t[n]+t[n-1] = size of tv
	
	public boolean verify_partition( Integer[] TV, Integer[] VR) {
		// Check that the TV values are in S1 (1) or S2 (0)
		
		// initialize counters for the two sets
	    int countSet1 = 0;
	    int countSet2 = 0;

	    // iterate over the partition vector and count the number of elements in each set
	    for (int i = 0; i < TV.length; i++) {
	    	if (VR[i] == null) return false;
	        if (VR[i] == 1) {
	            countSet1++;
	        } else if (VR[i] == 0) {
	            countSet2++;
	        } else {
	            // if the partition vector contains a value other than 0 or 1, it's not valid
	            return false;
	        }
	    }
	    
	 // check that the counts for S1 and S2 are not 0
	    //if we have at least one element in both S1 and S2
	    if (countSet1 == 0 || countSet2 == 0) {
	        return false;
	    }


	    // check that the counts add up to the total length of the vector
	    if (countSet1 + countSet2 != TV.length) {
	        return false;
	    }
	    
	  //for this modelisation it's impossible for an element to be in both sets at the same time
	    
		  //if all elements exist in S1 or S2 then the sum of S1 and S2 gives S so we don't need to verify this
	    return true;
		
	}

	//evaluate solution
	//difference of sums S1 and S2
	public int evaluate_solution( Integer[] TV, Integer[] VR) {
		
		// initialize variables to track the running sum of elements in each set
	    int sumSet1 = 0;
	    int sumSet2 = 0;

	    // iterate over the vector and sum the elements in each set
	    for (int i = 0; i < TV.length; i++) {
	        if (VR[i] == 1) {
	            sumSet1 += TV[i];
	        } else if (VR[i] == 0) {
	            sumSet2 += TV[i];
	        }
	    }
		return Math.abs(sumSet1-sumSet2);
		
	}

	public Integer[] getTV() {
		return TV;
	}

	public void setTV(Integer[] tV) {
		TV = tV;
	}

	public Integer[] getVR() {
		return VR;
	}

	public void setVR(Integer[] vR) {
		VR = vR;
	}
	
	// DFS algorithm to find the optimal partition
	private static int totalNodes; // to keep track of the total number of nodes
	private static List<Integer> totalNodesSolution = new ArrayList<>(); // to keep track of the number of nodes generated for each solution
	private static Node bestNode;
	
    public static List<Node> dfs(Partition p) {
    	
    	List<Node> solutions = new ArrayList<>(); // initialize a list to hold the solutions
        // create a stack to hold the nodes to explore
        Stack<Node> open = new Stack<Node>();
        
        //we don't need closed list for this implementation because there is no case where the VR array is same

        // create the root node and add it to the stack
        Node root = new Node(p.getVR(), 0, -1);
        open.push(root);
        totalNodes++; // increment the total nodes counter

        // initialize the best solution with an arbitrarily large difference
        int bestDiff = Integer.MAX_VALUE;
        Node bestNode = null;

        // while there are still nodes to explore
        while (!open.empty()) {
            // pop the next node from the stack
            Node node = open.pop();

            // if this node represents a complete partition (final state)
            if (node.depth == p.getTV().length) {
                // calculate the difference in the sums of the two sets
                int diff = p.evaluate_solution(p.getTV(), node.partition);
                node.diff = diff;
                
                if(p.verify_partition(p.getTV(), node.partition)) {
                	solutions.add(node); // add it to the list of solutions
                	totalNodesSolution.add(totalNodes); // add the total number of nodes generated for this solution to the list
                	// if this solution is better than the current best solution
                    if (diff < bestDiff) {
                        bestDiff = diff;
                        bestNode = node;
                    }
                }
                
                
            } else {
                // add two new nodes to the stack, one where the next element is in S1 and one where it's in S2
                //add next element to S1
            	Integer[] partition1 = Arrays.copyOf(node.partition, node.partition.length);
                partition1[node.depth] = 1;
                open.push(new Node(partition1, node.depth + 1, -1));
                totalNodes++; // increment the total nodes counter
              //add next element to S2
                Integer[] partition2 = Arrays.copyOf(node.partition, node.partition.length);
                partition2[node.depth] = 0;
                open.push(new Node(partition2, node.depth + 1, -1));
                totalNodes++; // increment the total nodes counter
            }
        }

        // set the best solution
        Partition.setBestNode(bestNode);
        Partition.setTotalNodesSolution(totalNodesSolution);
        
        //System.out.println("Best solution: " + Arrays.toString(bestNode.partition));
        //System.out.println("Difference: " + bestDiff);
		return solutions;
    }
    
    public static void reset() {
    	totalNodes =0;
    	totalNodesSolution.clear();
    	bestNode = null;
    }

    public static void setTotalNodes(int totalNodes) {
		Partition.totalNodes = totalNodes;
	}

	public static void setTotalNodesSolution(List<Integer> totalNodesSolution) {
		Partition.totalNodesSolution = totalNodesSolution;
	}

	public static List<Integer> getTotalNodesSolution() {
		return totalNodesSolution;
	}

	public static int getTotalNodes() {
		return totalNodes;
	}

	public static Node getBestNode() {
		return bestNode;
	}

	public static void setBestNode(Node bestNode) {
		Partition.bestNode = bestNode;
	}


	

	


	
	
	
	
}
