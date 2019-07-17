import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class InterestCalculatorTest {


  @Test
  public void shouldReceiveOneHundredAndNinetyTwoInterest() {
    BigDecimal expectedValue = new BigDecimal(192.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate( new BigDecimal(6400.00)));
  }

  @Test
  public void shouldReceiveTwoPercentInterest() {
    BigDecimal expectedValue = new BigDecimal(20.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(1000.00)));
  }

  @Test
  public void shouldCalculateTwoThousandPounds(){
    BigDecimal expectedValue = new BigDecimal(40.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(2000.00)));
  }

  @Test
  public void shouldCalculateOverFiveThousandPounds() {
    BigDecimal expectedValue = new BigDecimal(300.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(10000.00)));
  }

  @Test
  public void shouldReturnZeroForNegativeBalance() {
    BigDecimal expectedValue = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(-10000.00)));
  }

  @Test
  public void shouldCalculatePoundsAndPence() {
    BigDecimal expectedValue = new BigDecimal(0.99).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(98.99)));
  }
}
