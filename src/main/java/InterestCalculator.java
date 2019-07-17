import java.math.BigDecimal;
import java.math.RoundingMode;

/** Interest Rate calculator
 *
 * Provides calculation of interest rate given an amount of money.
 *
 */
public class InterestCalculator {

  /**
   * @param originalAmount - The base amount of money
   * @return The interest from the base amount of money given:
   *         1% of interest when originalAmount below 1000
   *         2% of interest when originalAmount below 5000
   *         3% of interest when originalAmount 5000 or above
   */
  public static BigDecimal calculate(final BigDecimal originalAmount) {

    BigDecimal calculatedAmount = new BigDecimal(originalAmount.toString());
    BigDecimal zero = new BigDecimal(0);
    BigDecimal oneThousand = new BigDecimal(1000.00);
    BigDecimal fiveThousand = new BigDecimal(5000.00);
    BigDecimal lowestPercent = new BigDecimal(0.01);
    BigDecimal middlePercent = new BigDecimal(0.02);
    BigDecimal topPercent = new BigDecimal(0.03);

    if (originalAmount.compareTo(zero)>-1&&originalAmount.compareTo(oneThousand)<0) {
      calculatedAmount = calculatedAmount.multiply(lowestPercent);
    } else if (originalAmount.compareTo(oneThousand)>-1&&originalAmount.compareTo(fiveThousand)<0) {
      calculatedAmount = calculatedAmount.multiply(middlePercent);
    } else if (originalAmount.compareTo(fiveThousand)>-1) {
      calculatedAmount = calculatedAmount.multiply(topPercent);
    } else {
      calculatedAmount = zero;
    }

    //Return with the scale for currency (2 decimal places)
    return calculatedAmount.setScale(2, RoundingMode.HALF_UP);
  }
}
