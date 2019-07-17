# InterestCalculator

## Summary

This is a simple interest rate calculator that determines the interest rate given a value.

The rates of interest are:

1% - For amounts below 1000

2% - For amounts 1000 or above, but below 5000

3% - For amounts of 5000 or above

## Rounding

Half-up rounding is used. Please see https://docs.oracle.com/javase/8/docs/api/java/math/RoundingMode.html for more information.

## Example Usage

`System.out.printf("Interest rate for £10000 is £%s", InterestCalculator.calculate(new BigDecimal(10000.00)));`

`System.out.printf("Interest rate for £98.99 is £%s", InterestCalculator.calculate(new BigDecimal(98.99)));`
