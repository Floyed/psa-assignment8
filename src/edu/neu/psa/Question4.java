package edu.neu.psa;

class Question4 {

    public static void main(String[] args) {

        char[][] input = {{'1','1','1'},{'0','0','0'},{'1','1','1'}};

        System.out.println(numIslands(input));

    }

    public static int numIslands(char[][] grid) {

        int res = 0;

        for(int i = 0 ; i < grid.length ; i ++){
            for(int j = 0 ; j < grid[0].length ; j ++){

                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }

            }
        }

        return res;
    }

    public static void dfs(char[][] grid, int x, int y){

        if(grid[x][y] == '1'){
            grid[x][y] = '2';

            if(x - 1 >= 0){
                dfs(grid, x - 1, y);
            }

            if(y - 1 >= 0){
                dfs(grid, x, y - 1);
            }

            if(x + 1 < grid.length){
                dfs(grid, x + 1, y);
            }

            if(y + 1 < grid[0].length){
                dfs(grid, x, y + 1);
            }

        }
    }
}