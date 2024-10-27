class Solution {
    // Arrays to store information about the tree
    private int[] heights;
    private int[] d;        
    private int[] l;       
    private int[] r;       
    private int lenLeaves;
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        // Initialize arrays with sufficient size
        heights = new int[50000];   
        d = new int[100001];         
        l = new int[100001];
        r = new int[100001];        
        lenLeaves = 0;               
        
        // DFS to process the tree and fill arrays
        search(root, 0);
        
        int n = lenLeaves;
        // Arrays to store maximum heights from left and right
        int[] maxl = new int[n];     
        int[] maxr = new int[n];     
        
       
        for (int i = 1; i < n; i++) {
            maxl[i] = Math.max(maxl[i-1], heights[i-1]);
        }
        
        
        for (int i = n-2; i >= 0; i--) {
            maxr[i] = Math.max(maxr[i+1], heights[i+1]);
        }
        
        // Process each query
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
           
            int maxxl = maxl[l[query]];          
            int maxxr = maxr[r[query]];          
   
            ret[i] = Math.max(Math.max(maxxl, maxxr), d[query]-1);
        }
        
        return ret;
    }
    
    // DFS to process the tree
    private void search(TreeNode p, int h) {
        d[p.val] = h;    // Store current node's height
        
        // If current node is a leaf
        if (p.left == null && p.right == null) {
            heights[lenLeaves] = h;   // Store leaf height
            l[p.val] = r[p.val] = lenLeaves;  // Both boundaries point to same index
            lenLeaves++;              // Increment leaf counter
            return;
        }
        
        l[p.val] = lenLeaves;        // Store left boundary
        
        // Recursively process left and right subtrees
        if (p.left != null) {
            search(p.left, h + 1);
        }
        if (p.right != null) {
            search(p.right, h + 1);
        }
        
        r[p.val] = lenLeaves - 1;    // Store right boundary
    }
}