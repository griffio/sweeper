package griffio.sweeper;

import com.google.common.base.Function;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import javax.annotation.Nullable;

import static griffio.sweeper.SquareType.MINE;

public class Field {

  private static final HintTransformer transformer = new HintTransformer();

  private static class HintTransformer implements Function<Square, String> {
    @Nullable
    @Override
    public String apply(Square square) {
      return square.get().equals(MINE) ? MINE.toString() : String.valueOf(square.getCount());
    }
  }

  private final int index;

  private final HashBasedTable<Integer, Integer, Square> squares;

  public Field(int index, int rows, int cols) {
    this.index = index;
    this.squares = HashBasedTable.create(rows, cols);
  }

  public int getIndex() {
    return index;
  }

  protected void incrementSquare(int row, int col) {
    Square square = squares.get(row, col);
    if (square != null && square.isSafe()) {
      square.increment();
    }
  }

  protected void adjacencySweep(Table.Cell<Integer, Integer, Square> mineCell, int rowOffSet) {
    incrementSquare(mineCell.getRowKey() + rowOffSet, mineCell.getColumnKey());
    incrementSquare(mineCell.getRowKey() + rowOffSet, mineCell.getColumnKey() + 1);
    incrementSquare(mineCell.getRowKey() + rowOffSet, mineCell.getColumnKey() - 1);
  }

  protected void mineSweep() {
    for (Table.Cell<Integer, Integer, Square> squareCell : squares.cellSet()) {
      Square currentSquare = squares.get(squareCell.getRowKey(), squareCell.getColumnKey());
      if (currentSquare.isMined()) {
        adjacencySweep(squareCell, 0);
        adjacencySweep(squareCell, 1);
        adjacencySweep(squareCell, -1);
      }
    }
  }

  public void addSquare(int row, int col, Square squareCell) {
    squares.put(row, col, squareCell);
  }

  public Table<Integer, Integer, String> hints() {
    mineSweep();
    return Tables.transformValues(squares, transformer);
  }

}