package griffio.sweeper;

import com.google.common.base.Function;

import static griffio.sweeper.SquareType.MINE;

public class SquareToHint implements Function<Square<SquareType>, String> {
  @Override
  public String apply(Square<SquareType> square) {
    return square.get().equals(MINE) ? MINE.toString() : String.valueOf(square.getCount());
  }
}
