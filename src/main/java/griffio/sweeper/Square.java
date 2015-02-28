package griffio.sweeper;

import java.util.function.Supplier;

import static griffio.sweeper.SquareType.MINE;

public class Square<SquareType> implements Supplier<SquareType> {

  private SquareType value;
  private int count;

  private Square(SquareType value) {
    this.value = value;
  }

  public int increment() {
    return this.count++;
  }

  public int getCount() {
    return count;
  }

  public boolean isMined() {
    return value.equals(MINE);
  }

  public boolean isSafe() {
    return !isMined();
  }

  @Override
  public SquareType get() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(this.count);
  }

  public static <SquareType> Square<SquareType> create(SquareType value) {
    return new Square<>(value);
  }


}
