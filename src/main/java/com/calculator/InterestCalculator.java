package com.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Interest Rate calculator
 * <p>
 * Provides calculation of interest amount given an amount of money.
 */
public class InterestCalculator {

  private Map<BigDecimal, BigDecimal> interestRanges = new LinkedHashMap<BigDecimal, BigDecimal>();

  /**
   * Initialize the constructor with a range of values and the associated
   * values.
   *
   */
  public InterestCalculator() {

    interestRanges.put(new BigDecimal(5000), new BigDecimal(0.03));
    interestRanges.put(new BigDecimal(1000), new BigDecimal(0.02));
    interestRanges.put(BigDecimal.ZERO, new BigDecimal(0.01));
  }

  /**
   * Calculate the total amount of interest received for a given amount.
   *
   * @param originalAmount - The base amount of money
   * @return The total interest from the base amount of money given
   */
  public BigDecimal calculate(final BigDecimal originalAmount) {

    BigDecimal remainingAmount = new BigDecimal(originalAmount.toString());
    BigDecimal calculatedInterest = BigDecimal.ZERO;
    Map<BigDecimal, BigDecimal> interestRanges = getInterestRanges();

    for (BigDecimal rangeValue : interestRanges.keySet()) {

      if (originalAmount.compareTo(rangeValue) > 0) {
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
  private Map<BigDecimal, BigDecimal> getInterestRanges() {
    return interestRanges;
  }
}
