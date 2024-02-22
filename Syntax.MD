Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

O. Priority Queues/Merged Intervals

    min heap. Max heap is (b-a)
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);

    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

    pq.peek()
    pq.poll()
    pq.add()

****  Arrays.sort(<an instance of int[][]>, (a,b)-> Integer.compare(a[0], b[0]));

        /* Sorting by start time */
        Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
          public int compare(int[] a, int[] b) {
            return a[0] - b[0];
          }
        });

A. HashMaps

HashMap<Character, Integer> map = new HashMap<>();

1. map.remove(ch)
2. map.containsKey(ch)
3. map.get(ch)
4. map.put(ch)

B. Hash

1. HashSet<Integer> set = new HashSet<>();
2. if(!set.contains(num)) 
3. set.add(num)
4. set.remove(num)
5. hash_map.keySet()
6. map.values().contains(ele)


C. Strings/Arrays

1. return new int[]{1, 3};
2. int[] result=new int[2];
3. int a; String.valueOf(a);
4. Define a compartor
****  Arrays.sort(<an instance of int[][]>, (a,b)-> Integer.compare(a[0], b[0]));
5. To convert any list to Array, use list.toArray(new result.size())
6. Character.isLetterOrDigit(ch)

D. LinkedList

1. list.getLast()
2. list.get(index i)
3. list.getFirst()

E. Trees

BFS:

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            if(!found){
                TreeNode temp = q.poll();
                if(temp.val == subRoot.val) found = true;  
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode ele = q.poll();
                if(ele.left!=null) q.add(ele.left);
                if(ele.right!=null) q.add(ele.right);
            }
        }


DFS:

    private boolean dfs(TreeNode root, TreeNode subRoot){
        //logic - DFS
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }