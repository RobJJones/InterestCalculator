package com.calculator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.assertEquals;

public class InterestCalculatorTest {

  private InterestCalculator fixture;

  @Before
  public void setUp() {
    fixture = new InterestCalculator();
  }

  @Test
  public void test_calculate_shouldReceiveOneHundredAndThirtyTwoInterest() {
    BigDecimal expectedValue = new BigDecimal(132.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(6400.00)));
  }

  @Test
  public void test_calculate_shouldReceiveLowestInterest() {
    BigDecimal expectedValue = new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(1000.00)));

    expectedValue = new BigDecimal(0.01).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(1.00)));

    expectedValue = new BigDecimal(10).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(999.99)));
  }

  @Test
  public void test_calculate_shouldReceiveLowestAndMiddleInterest() {
    BigDecimal expectedValue = new BigDecimal(90.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(5000.00)));

    expectedValue = new BigDecimal(10.02).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(1000.99)));

    expectedValue = new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(1000.01)));
  }

  @Test
  public void test_calculate_shouldReturnZeroForNegativeBalance() {
    BigDecimal expectedValue = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(-10000.00)));
  }

  @Test
  public void test_calculate_shouldCalculatePoundsAndPence() {
    BigDecimal expectedValue = new BigDecimal(0.99).setScale(2, RoundingMode.HALF_UP);
    assertEquals(expectedValue, fixture.calculate(new BigDecimal(98.99)));
  }

}
