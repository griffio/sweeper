package griffio.sweeper;

import java.util.Scanner;

import static griffio.sweeper.SquareType.MINE;
import static griffio.sweeper.SquareType.SAFE;

/**
 * String s = "4 4 *... .... .*.. ....";
 */
public class FieldParser {

  public static Field toField(String input) {

    Scanner scanner = new Scanner(input);

    int rows = scanner.nextInt();
    int cols = scanner.nextInt();

    Field field = new Field(1, rows, cols);

    for (int row = 0; row < rows; row++) {
      String[] squares = scanner.next().split("");
      for (int col = 0; col < cols; col++) {
        if (squares[col].equals("*")) {
          field.addSquare(row, col, Square.create(MINE));
        }
        if (squares[col].equals(".")) {
          field.addSquare(row, col, Square.create(SAFE));
        }
      }
    }

    return field;

  }

}
