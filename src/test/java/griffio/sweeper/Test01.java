package griffio.sweeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.ASSERT;
import static griffio.sweeper.SquareType.MINE;
import static griffio.sweeper.SquareType.SAFE;

@Test
public class Test01 {

  static Logger log = LoggerFactory.getLogger(Test01.class);

  @Test
  public void field_parser() {
    Field field = FieldParser.toField(FieldFixtures.FourByFour[0]);
    ASSERT.that(field.hints().size()).isEqualTo(16);
  }

  @Test
  public void two_by_four() throws Exception {

    Field field = new Field(1, 2, 4);
    field.addSquare(0, 0, Square.create(MINE));
    field.addSquare(0, 1, Square.create(SAFE));
    field.addSquare(0, 2, Square.create(SAFE));
    field.addSquare(0, 3, Square.create(SAFE));
    field.addSquare(1, 0, Square.create(SAFE));
    field.addSquare(1, 1, Square.create(SAFE));
    field.addSquare(1, 2, Square.create(SAFE));
    field.addSquare(1, 3, Square.create(SAFE));

    String actual = HintTablePrinting.printHints(field.getIndex(), field.hints());

    ASSERT.that(actual).isEqualTo(FieldFixtures.Expected_TwoByFour);
  }

}
