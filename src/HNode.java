import java.util.Comparator;


/*
 * Dans ce cas, nous utilisons la somme des éléments de l'ensemble divisée par deux comme estimation de la distance restante.
 * L'heuristique de la somme consiste à calculer la somme des éléments restants et à la diviser par deux. Cette valeur peut être utilisée comme estimation de la distance restante entre l'état actuel et l'état final. Plus la somme des éléments restants est grande, plus il est probable que l'état actuel nécessite plus de mouvements pour atteindre l'état final.
 * 
 */

public class HNode implements Comparable<HNode>{
	 Integer[] partition;//represents VR
     int depth;
     int diff;
     int heuristic;
     
	public HNode(Integer[] partition, int depth, int diff, int heuristic) {
		super();
		this.partition = partition;
		this.depth = depth;
		this.diff = diff;
		this.heuristic = heuristic;
	}

	public int getDiff() {
		return diff;
	}

	public int getHeuristic() {
		return heuristic;
	}
	
	public int getF() {
        return diff + heuristic;
    }

	public int compareTo(HNode n1, HNode n2) {
        return Integer.compare(n1.diff + n1.heuristic, n2.diff + n2.heuristic);
    }

	@Override
	public int compareTo(HNode o) {
		return Integer.compare(this.getF(), o.getF());
    }
	
	
	
	/*
	 * Dans ce cas, nous ajoutons l'heuristique à la distance réelle
	 *  pour obtenir le score total de chaque nœud.
	 */
    
	
//
//	@Override
//	public int compareTo(HNode o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
     
}
