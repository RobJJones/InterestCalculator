package com.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Interest Rate calculator
 * <p>
 * Provides calculation of interest amount given an amount of money.
 */
public class InterestCalculator {

  public static final int ZERO_VALUE = 0;
  private static Map<BigDecimal,  BigDecimal> interestRanges = new LinkedHashMap<BigDecimal,  BigDecimal>();

  /** Calculate the total amount of interest received for a given amount.
   *
   * @param originalAmount - The base amount of money
   * @return The total interest from the base amount of money given
   */
  public static BigDecimal calculate(final BigDecimal originalAmount) {

    BigDecimal remainingAmount = new BigDecimal(originalAmount.toString());
    BigDecimal calculatedInterest = BigDecimal.ZERO;
    Map<BigDecimal, BigDecimal> interestRanges = getInterestRanges();
    Iterator<BigDecimal> rangeValues = interestRanges.keySet().iterator();

    //Iterate through the list of range values, adding the interest as we progress
    while (rangeValues.hasNext()) {
      BigDecimal rangeValue = rangeValues.next();
      if (originalAmount.compareTo(rangeValue) > ZERO_VALUE) {
        BigDecimal percentage = interestRanges.get(rangeValue);
        calculatedInterest = calculatedInterest.add(remainingAmount.subtract(rangeValue).multiply(percentage));
        remainingAmount = rangeValue;
      }
    }

    //Return with the scale for currency (2 decimal places)
    return calculatedInterest.setScale(2, RoundingMode.HALF_UP);
  }

  /**
   * @return A Map of interest rates to be applied to amounts over a value.
   */
  private static Map<BigDecimal, BigDecimal> getInterestRanges() {

    if (interestRanges.isEmpty()) {
      interestRanges.put(new BigDecimal(5000), new BigDecimal(0.03));
      interestRanges.put(new BigDecimal(1000), new BigDecimal(0.02));
      interestRanges.put(BigDecimal.ZERO, new BigDecimal(0.01));
    }
    return interestRanges;
  }
}
