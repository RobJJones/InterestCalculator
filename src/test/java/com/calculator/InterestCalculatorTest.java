package com.calculator;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.assertEquals;

public class InterestCalculatorTest {

  @Test
  public void test_calculate_shouldReceiveOneHundredAndThirtyTwo() {
    BigDecimal expectedValue = new BigDecimal(132.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate( new BigDecimal(6400.00)));
  }

  @Test
  public void test_calculate_shouldReceiveLowestInterest() {
    BigDecimal expectedValue = new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(1000.00)));
  }

  @Test
  public void test_calculate_shouldReceiveLowestAndMiddleInterest() {
    BigDecimal expectedValue = new BigDecimal(90.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(5000.00)));
  }

  @Test
  public void test_calculate_shouldReturnZeroForNegativeBalance() {
    BigDecimal expectedValue = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(-10000.00)));
  }

  @Test
  public void test_calculate_shouldCalculatePoundsAndPence() {
    BigDecimal expectedValue = new BigDecimal(0.99).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, InterestCalculator.calculate(new BigDecimal(98.99)));
  }

}
