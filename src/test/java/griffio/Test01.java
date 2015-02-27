package griffio;

import griffio.sweeper.FieldFixtures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.ASSERT;

@Test
public class Test01 {

  static Logger log = LoggerFactory.getLogger(Test01.class);

  @Test
  public void Four_by_Four() throws Exception {
    ASSERT.that("").isEqualTo(FieldFixtures.Expected_FourByFour);
  }

  @Test
  public void Three_by_Five() throws Exception {
    ASSERT.that("").isEqualTo(FieldFixtures.Expected_ThreeByFive);
  }

  @Test
  public void FourByFour_ThreeByFive() throws Exception {
    ASSERT.that("").isEqualTo(FieldFixtures.Expected_FourByFour_ThreeByFive);
  }
}
