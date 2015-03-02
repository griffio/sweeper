package griffio.sweeper;

import com.google.common.base.Preconditions;

import java.io.IOException;

public class FieldAnalyzer {

  private final int rows;
  private final int cols;
  private final boolean[][] mined;
  private final int[][] hints;

  public FieldAnalyzer(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.mined = new boolean[rows + 2][cols + 2];
        this.hints = new int[rows + 2][cols + 2];
    }

    public void placeMine(int rowNumber, int colNumber) {
        Preconditions.checkArgument(rowNumber > 0, "min row is 1");
        Preconditions.checkArgument(rowNumber <= rows, String.format("max row is %d", rows));
        Preconditions.checkArgument(colNumber > 0, "min col is 1");
        Preconditions.checkArgument(colNumber <= cols, String.format("max col is %d", cols));
        this.mined[rowNumber][colNumber] = true;
    }

    public int[][] hints() {

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                for (int adjacentRow = row - 1; adjacentRow <= row + 1; adjacentRow++) {
                    for (int adjacentCol = col - 1; adjacentCol <= col + 1; adjacentCol++) {
                        if (mined[adjacentRow][adjacentCol]) {
                            hints[row][col]++;
                        }
                    }
                }
            }
        }

        return hints.clone();
    }

    public void printField(Appendable presenter) throws IOException {
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                if (mined[row][col]) {
                    presenter.append(" *");
                } else {
                    presenter.append(" .");
                }
            }
            presenter.append("\n");
        }
    }

    public void printHints(Appendable presenter) throws IOException {
        int[][] hints = hints();
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                if (mined[row][col]) {
                    presenter.append(" *");
                } else {
                    presenter.append(" ").append(String.valueOf(hints[row][col]));
                }
            }
            presenter.append("\n");
        }
    }

}