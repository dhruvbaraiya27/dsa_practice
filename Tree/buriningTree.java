/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {

    // Step 1: Map all nodes to their parent and locate the target node
    private static Node mapParents(Node root, int target, HashMap<Node, Node> parentMap) {
        Node targetNode = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Level-order traversal to fill parent map and find the target node
        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.data == target) {
                targetNode = temp;
            }

            if (temp.left != null) {
                parentMap.put(temp.left, temp); // Map child to parent
                q.add(temp.left);
            }

            if (temp.right != null) {
                parentMap.put(temp.right, temp); // Map child to parent
                q.add(temp.right);
            }
        }

        return targetNode;
    }

    // Step 2: Burn the tree starting from the target node using BFS
    private static int burnTree(Node targetNode, HashMap<Node, Node> parentMap) {
        int time = 0; // Tracks the number of time units
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        // Start burning from the target node
        q.add(targetNode);
        visited.add(targetNode);

        // BFS level by level
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false; // To check if fire spread this second

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();

                // Check left child
                if (temp.left != null && !visited.contains(temp.left)) {
                    visited.add(temp.left);
                    q.add(temp.left);
                    flag = true;
                }

                // Check right child
                if (temp.right != null && !visited.contains(temp.right)) {
                    visited.add(temp.right);
                    q.add(temp.right);
                    flag = true;
                }

                // Check parent
                if (parentMap.containsKey(temp) && !visited.contains(parentMap.get(temp))) {
                    visited.add(parentMap.get(temp));
                    q.add(parentMap.get(temp));
                    flag = true;
                }
            }

            // If any node burned in this round, increment time
            if (flag) {
                time++;
            }
        }

        return time;
    }

    // Main function: orchestrates the logic
    public static int minTime(Node root, int target) {
        HashMap<Node, Node> parentMap = new HashMap<>();

        // Step 1: Build parent relationships and find target node
        Node targetNode = mapParents(root, target, parentMap);

        // Step 2: Burn the tree and return total time
        return burnTree(targetNode, parentMap);
    }
}
