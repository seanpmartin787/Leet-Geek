public class SurroundedRegionsUF {
    public static void main(String[] args) {
        //char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] board = new char[][] {{'O'}};
        char[][] board = new char[][] {{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        SurroundedRegionsUF test = new SurroundedRegionsUF();
        test.solve(board);
        System.out.println("all solved!");
    }
    public void solve(char[][] board) {
        //We can accomplish this with UF, optimizing with path compression and ranked union
        //Basically we want to union every 0 into sets,
        // any set that is not joined to the dummy node set should be filled to x
        int x = board.length;
        int y = board[0].length;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        UnionFind uf = new UnionFind(x * y + 1); //the plus one is the dummy one

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if ((i == 0 || i == x-1 || y == 0 || y == j-1) && board[x][y] == 'O') {
                    uf.union(i * x + j, x * y); //join to dummy
                }
                //add all adjacent 'O's too
                for (int[] d: dir) {
                    if (x + d[0] >= 0 && x + d[0] < board.length && y + d[1] >= 0 && y + d[1] < board[0].length
                            && board[x][y] == 'O')
                }

            }
        }


    }
    public class UnionFind {

        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            rank = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i; //they will each start as their own set
            }
        }

        public void union (int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);

            if (aRoot == bRoot) return; //already same set

            if(rank[aRoot] > rank[bRoot]) {
                parent[bRoot] = aRoot;
            } else if (rank[aRoot] < rank[bRoot]) {
                parent[aRoot] = bRoot;
            } else {
                //pick one and increase rank
                parent[bRoot] = aRoot;
                rank[aRoot]++;
            }

        }

        public int find (int a) {
            int root = a;
            if (a != parent[a]) {
                //if not the parent, recurse
                root = find(parent[a]);
                //this path compression actually gets them to point to the top, not just grandparent
            }

            return root;
        }

        public boolean isConnected (int a, int b) {
            return find(a) == find(b);
        }


    }


}

