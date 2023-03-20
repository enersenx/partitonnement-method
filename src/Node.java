// node class to represent the nodes in the search tree
    public class Node {
        Integer[] partition;//represents VR
        int depth;
        int diff;

        public Node(Integer[] partition, int depth, int diff) {
            this.partition = partition;
            this.depth = depth;
            this.diff = diff;
        }
    }