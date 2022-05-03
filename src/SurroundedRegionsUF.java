public class SurroundedRegionsUF {
    public static void main(String[] args) {
        char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] board = new char[][] {{'O'}};
        //char[][] board = new char[][] {{'X','O','X'},{'X','O','X'},{'X','O','X'}};
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
                if (board[i][j] == 'O') {
                    if (i == 0 || i == x - 1 || j == 0 || j == y - 1) {
                        uf.union(i * y + j, x * y); //join to dummy
                    }
                    //add all adjacent 'O's too
                    for (int[] d: dir) {
                        int newRow = i + d[0];
                        int newCol = j + d[1];
                        if (newRow >= 0 && newRow < x && newCol >= 0 && newCol < y && board[newRow][newCol] == 'O') {
                            uf.union(y * newRow + newCol, y * i + j);
                        }
                    }
                }


            }
        }
        //Now go through and flip all unconnected O's
        for (int i = 1; i < board.length -1; i++) {
            for (int j = 1; j < board[0].length -1; j++) {
                if (board[i][j] == 'O' && !uf.isConnected(i * y + j, x * y)) {
                    board[i][j] = 'X';
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
            int root = parent[a];
            if (parent[root] != root) {
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

