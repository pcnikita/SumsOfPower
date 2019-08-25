*******************************************************************************************************************************************
Note:
Go to https://latexbase.com/d/0ab7ec7d-eddb-4b35-8e26-a64d09654a92 and paste everything outside of the stars in the text box. It will yield a nice LaTeX rendering which is easier to read.

Improvements :
-[] Create a method that checks the error.
-[] Check how far each of the first n partial sums deviate from the actual value
-[] Check how far each of the (10+n)th, (100+n)th and (1000+n)th deviate from the actual value.
-[] Display function as a polynomial.
-[] Perform algebraic manipulations automatically to display canonical form of polynomial.
-[] Improve accuracy? (i don't know how good the accuracy is at the moment).

*******************************************************************************************************************************************
\documentclass[12pt]{article}

\usepackage{amsmath}
\usepackage{graphicx}
\usepackage{hyperref}
\usepackage[latin1]{inputenc}
\begin{document}

\title{Framework to find sum of first n numbers to the power of k}
\author{Popescu N.}
\date{25 Aug 2019}
\maketitle

The code in this repository finds a formula for the first n numbers to a given power. Sums of powers of natural numbers can take on a number of forms. They can be expressed in contracted form as $\Sigma_{i=0}^n\ i^k$ where n is the required number of terms of the sum and k is a power. It can also be expressed explicitly as $1^k + 2^k +... n^k$ where n is the n'th term and k is the power. The sums of certain powers are the Rieman Zeta function evaluated at negative integers. Perhaps the most notable and well known example of such series is for k=1. The story dates back to 1700 when Gauss was assigned to find the sum of the first 100 whole numbers. Gauss came up with the formula $\frac{n\cdot (n+1)}{2}$ to find the sum of the first n whole numbers. There are formulas that can be used to find the sum of the first n squares or cubes, but the question is how can we generalize this for higher powers. The answer to this question comes from making a few observations about the known formulas (sum of whole numbers, sum of squares and sum of cubes).
\newline
\linebreak
The formulas for the first n whole numbers, n first squares and n first cubes are $\frac{n(n+1)}{2}$, $\frac{n(n+1)(2n+1)}{6}$ and $\frac{n^2(n+1)^2}{4}$.
\newline
\linebreak
The first observation is that if the given power is k, then the highest order term will have power k+1.
\newline
\linebreak
The second observation is that the formula is a polynomial with rational coefficients. Since the partial sum of the first 0 numbers to a power k is always 0, it follows that the coefficient of $n^0$ is always 0 for any sum of powers. Since 0 is a root of this polynomial and since the numbers are always positive, it follows that all the other roots of the polynomial are negative. The general form of the polynomial will be $x(x + a_{n-1})(x + a_{n-2})...(x + a_{1})$.
\newline
\linebreak
Based on observations 1 and 2, the formula will generally be a polynomial of order k+1 if we have to find the formula for the first n numbers to the power of k.
The third observation is that if the power is k, then the resulting formula will have k+2 coefficients. The floating coefficient is always 0.
\newline
\linebreak
Having observed these, we can build a framework to find the coefficients and therefore find the formula for higher order numbers.
\newline
\linebreak
First, we notice that if we want to add the n first numbers to the power of 10, the polynomial that goes through the first n partial sums will have degree 11. Thus, $$f(n) = a_{11}\cdot n^{11} + a_{10}\cdot n^{10}... + a_1\cdot n^1 + 0$$
\newline
\linebreak
To find the first n partial sums, we need to plug in n from 1 to 11 in the f(n) formula. But the first n partial sums can also be computed by adding the terms $1^{11}$ for the first partial sum, then $1^{11} + 2^{11}$ for the second partial sum all the way up to the 11th partial sum.
\newline
\linebreak
We have a system of 11 equations and 11 unknowns( $a_{1}$ to $a_{11}$). After solving the system, $a_{1}$ to $a_{11}$ are the coefficients of the 11th degree polynomial. Through further algebraic manipulation, one can find an expression of the form $$\frac{n(n-b_{1})...(n-b_{10})}{r}$$ where $b_1$ to $b_{10}$ are the 10 negative roots of the polynomial and r is a number.

\end{document}
