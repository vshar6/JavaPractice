/* https://www.geeksforgeeks.org/islands-in-a-graph-using-bfs/?ref=lbp */

package hierarchical;


import java.util.LinkedList;
import java.util.Queue;

public class Islands {


//    *************************** Practice - please ignore ************************************
//    public int countNumberOfIslands(int[][] islandsAndWater) {
//        int numberOfIslands = 0;
//
//        int rows = islandsAndWater.length;
//        int columns = islandsAndWater[0].length;
//
//        boolean[][] visitedBody = new boolean[rows][columns];                           // A body can be island = true, water = false. this is initialized as water
//
//        for(int row = 0;row<rows;row++) {
//            for(int column = 0; column < columns; column ++) {
//                if(islandsAndWater[row][column] == 1 && !visitedBody[row][column]) {
//                    depthFirstIslands(islandsAndWater,visitedBody, row,column);
//                    numberOfIslands++;
//                }
//
//            }
//        }
//
//
//        return numberOfIslands;
//    }
//    *************************** Practice - please ignore ************************************

//    *************************** Practice - please ignore ************************************
//    private void depthFirstIslands(int[][] islandsAndWater,  boolean[][] visitedBody, int row, int column) {
//        if(row>=islandsAndWater.length || column >= islandsAndWater[0].length || row < 0 || column < 0) {
//            return;
//        } else if(visitedBody[row][column] || islandsAndWater[row][column]==0) {
//            return;
//        }
//
//        visitedBody[row][column]=true;
//
//        depthFirstIslands(islandsAndWater,visitedBody, row-1,column-1);
//        depthFirstIslands(islandsAndWater,visitedBody, row-1,column);
//        depthFirstIslands(islandsAndWater,visitedBody, row-1,column+1);
//
//        depthFirstIslands(islandsAndWater,visitedBody, row,column-1);
//        depthFirstIslands(islandsAndWater,visitedBody, row-1,column+1);
//
//        depthFirstIslands(islandsAndWater,visitedBody, row+1,column-1);
//        depthFirstIslands(islandsAndWater,visitedBody, row+1,column);
//        depthFirstIslands(islandsAndWater,visitedBody, row+1,column+1);
//
//    }
//     ****************************************************************************************

    public int countIslands(int[][] matrix) {

        int numberOfIslands = 0;
        boolean[][] visitedCells = new boolean[matrix.length][matrix[0].length];           // Initialize a boolean matrix with the size equal to the input so as to keeo count of the visited cells

        for(int row = 0;row < matrix.length;row++) {                                        // Iterate the input
            for(int column = 0;column < matrix[0].length;column++) {
                if(matrix[row][column] == 1 && !visitedCells[row][column]) {               // check if a cell is 1 and the cell is not visited
                    //breadthFirst(matrix,row,column,visitedCells);                        // conduct a breadth-first search for all of the adjacent cells for the input cell
                    depthFirst(matrix,row,column,visitedCells);                            // or conduct a depth-first search
                    numberOfIslands++;                                                     // increment the count of islands by 1
                }
            }
        }

        System.out.println("Number of islands:"+numberOfIslands);
        return numberOfIslands;
    }

    private void breadthFirst(int[][] matrix, int row, int column, boolean[][] visitedCells) {
        Queue<int[]> neighbours = new LinkedList<>();
        neighbours.add(new int[]{row, column});

        while(!neighbours.isEmpty()) {
           int elementRow = neighbours.peek()[0];
           int elementColumn = neighbours.peek()[1];
           neighbours.remove();
           if(elementRow < 0 || elementColumn < 0 || elementColumn>=matrix[1].length || elementRow>=matrix.length) {
               continue;
           }
           else if (matrix[elementRow][elementColumn] == 0 || visitedCells[elementRow][elementColumn]) {
               continue; // continue if the cell is water or visited
           }

           visitedCells[elementRow][elementColumn] = true;

//           neighbours.add(new int[]{row,column+1});
//           neighbours.add(new int[]{row,column-1});
//
//           neighbours.add(new int[]{row+1,column});
//           //neighbours.add(new int[]{row+1,column+1});
//           neighbours.add(new int[]{row+1,column-1});
//
//           neighbours.add(new int[]{row-1,column});
//           //neighbours.add(new int[]{row-1,column-1});
//           neighbours.add(new int[]{row-1,column+1});
            neighbours.add(new int[]{row-1,column});
            neighbours.add(new int[]{row-1,column-1});
            neighbours.add(new int[]{row-1,column+1});

            neighbours.add(new int[]{row+1,column});
            neighbours.add(new int[]{row+1,column+1});
            neighbours.add(new int[]{row+1,column-1});

            neighbours.add(new int[]{row,column+1});
            neighbours.add(new int[]{row,column-1});

        }
    }

    private void depthFirst(int[][] matrix, int row, int column, boolean[][] visitedCells) {
        if(row>=matrix.length || row < 0 || column >= matrix[0].length || column < 0 ) {
            return;
        }
        else if(matrix[row][column]==0 || visitedCells[row][column]) {
            return;
        }
        visitedCells[row][column] = true;

        depthFirst(matrix, row + 1, column, visitedCells);
        depthFirst(matrix, row + 1, column - 1, visitedCells);
        depthFirst(matrix, row + 1, column + 1, visitedCells);

        depthFirst(matrix, row, column - 1, visitedCells);
        depthFirst(matrix, row, column + 1, visitedCells);

        depthFirst(matrix, row - 1, column, visitedCells);
        depthFirst(matrix, row - 1, column + 1, visitedCells);
        depthFirst(matrix, row - 1, column - 1, visitedCells);

    }

    public static void main(String [] args) {
        int[][] matrix = {
                {0,1,1,0,0},
                {1,0,0,1,0},
                {0,0,1,0,0},
                {1,0,0,0,1}
        };

        Islands island = new Islands();
        island.countIslands(matrix);
    }
}
