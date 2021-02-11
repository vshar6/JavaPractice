package linear;

import java.util.List;

public class NQueenProblem {

    private static Integer GRID_SIZE = 8;

    public void placeQueen(int row, int[] column, List<int[]> results) {
        if(row==GRID_SIZE) {
            results.add(column.clone());
        } else {
            for(int col = 0;col < GRID_SIZE;col++) {
                if(checkValid(row, column, col)) {
                    column[row] = col;
                    placeQueen(row+1, column, results);
                }
            }
        }
    }

    private boolean checkValid(int row, int[] column, int col) {
        for(int currentRow=0;currentRow < row;currentRow ++) {
            int currentColumn = column[currentRow];

            if(col == currentColumn) {
                return false;
            }
            int columnDistance = Math.abs(col - currentColumn);
            int rowDistance = row - currentRow;

            if(columnDistance==rowDistance) {
                return false;
            }
        }
        return true;
    }
}
