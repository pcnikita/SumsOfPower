# SumsOfPowers
The code in this repository finds a formula for the first n numbers to a given power.
Sums of powers of natural numbers can take on a number of forms. They can be expressed in contracted form as \Sigma_{i=0}^n\ i^k where n is the required number of terms of the sum and k is a power. It can also be expressed explicitly as 1^k + 2^k +... n^k where n is the n'th term and k is the power. The sums of certain powers are the Rieman Zeta function evaluated at negative integers. Perhaps the most notable and well known example of such series is for k=1. The story dates back to 1700 when Gauss was assigned to find the sum of the first 100 whole numbers. Gauss came up with the  formula \frac{n\cdot (n+1)}{2} to find the sum of the first n whole numbers. There are formulas that can be used to find the sum of the first n squares or cubes, but the question is how can we generalize this for higher powers. The answer to this question comes from making a few observations about the known formulas (sum of whole numbers, sum of squares and sum of cubes).

The formulas for the first n whole numbers, n first squares and n first cubes are \frac{n(n+1)}{2}, \frac{n(n+1)(2n+1)}{6} and \frac{n^2(n+1)^2}{4}. 

The first observation is that if the given power is k, then the highest order term will have power k+1. 

The second observation is that the formula is a polynomial with rational coefficients. Since the partial sum of the first 0 numbers to a power k is always 0, it follows that the coefficient of n^0 is always 0 for any sum of powers. Since 0 is a root of this polynomial and since the numbers are always positive, it follows that all the other roots of the polynomial are negative. The general form of the polynomial will be x(x + a_{n-1})(x + a_{n-2})...(x + a_{1}).

Based on obervations 1 and 2, the formula will generally be a polynomial of order k+1 if we have to find the formula for the first n numbers to the power of k.

The third observation is that if the power is k, then the resulting formula will have k+2 coefficients. The floating coefficient is always 0.

Having observed these, we can build a framework to find the coefficients and therefore find the formula for higher order numbers.
