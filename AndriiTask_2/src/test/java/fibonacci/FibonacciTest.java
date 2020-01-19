package fibonacci;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class FibonacciTest {

	@Parameterized.Parameter(0)
	public int n;
	@Parameterized.Parameter(1)
	public int fib;

	// (name = "{index}: {0}th Fibonacci number = {1} ")
	@Parameterized.Parameters(name = "{index}: {0}th Fibonacci number = {1}")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{
				{0, 0},
				{1, 0},
				{2, 1},
				{3, 1},
				{4, 2},
				{5, 3},
				{9, 21},
				{13, 144} };
		return Arrays.asList(data);
	}

	@Test
	public void findNthFibonacciIterativeTests() {
		assertEquals(fib, Fibonacci.findNthFibonacciIterative(n));
	}

	@Test
	public void findNthFibonacciRecursiveTests() {
		assertEquals(fib, Fibonacci.findNthFibonacciRecursive(n));
	}

	@Test(expected = IllegalArgumentException.class)
	public void findNthFibonacciIterativeException() {
		Fibonacci.findNthFibonacciIterative(-n - 1);
	}
}