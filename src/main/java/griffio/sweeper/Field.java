package griffio.sweeper;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

public class Field {

  private static final SquareToHint hintTransformer = new SquareToHint();

  private final int index;

  private final HashBasedTable<Integer, Integer, Square<SquareType>> squares;

  public Field(int index, int rows, int cols) {
    this.index = index;
    this.squares = HashBasedTable.create(rows, cols);
  }

  private void incrementSquare(int row, int col) {
    Square<SquareType> square = squares.get(row, col);
    if (square != null && square.isSafe()) {
      square.increment();
    }
  }

  private void adjacencySweep(Table.Cell<Integer, Integer, Square<SquareType>> mineCell, int rowOffSet) {
    incrementSquare(mineCell.getRowKey() + rowOffSet, mineCell.getColumnKey());
    incrementSquare(mineCell.getRowKey() + rowOffSet, mineCell.getColumnKey() + 1);
    incrementSquare(mineCell.getRowKey() + rowOffSet, mineCell.getColumnKey() - 1);
  }

  protected void mineSweep() {
    for (Table.Cell<Integer, Integer, Square<SquareType>> squareCell : squares.cellSet()) {
      Square<SquareType> currentSquare = squares.get(squareCell.getRowKey(), squareCell.getColumnKey());
      if (currentSquare.isMined()) {
        adjacencySweep(squareCell, 0);
        adjacencySweep(squareCell, 1);
        adjacencySweep(squareCell, -1);
      }
    }
  }

  public int getIndex() {
    return index;
  }

  public void addSquare(int row, int col, Square<SquareType> squareCell) {
    squares.put(row, col, squareCell);
  }

  public Table<Integer, Integer, String> hints() {
    mineSweep();
    return Tables.transformValues(squares, hintTransformer);
  }

}