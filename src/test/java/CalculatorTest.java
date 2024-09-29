import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelos.Calculator;

class CalculatorTest {

	static Calculator calculator;
	@Test
	//@BeforeEach // Se ejecuta antes de cada test
	//@AfterEach // Se ejecuta después de cada test
	//@BeforeAll // Se ejecuta antes de todos los test
	//@AfterAll // Se ejecuta después de todos los test
	//todos estos métodos deben ser estáticos
	@BeforeAll
	static void setup() {
		calculator = new Calculator();
	}
	@Test
	@DisplayName("Test add method")
	void testAdd() {
		double result = calculator.add(10, 50);
		assertEquals(60, result);
	}
	
	@Test
	@DisplayName("Test subtract method")
	void testSubtract() {
		double result = calculator.subtract(50, 10);
		assertEquals(40, result);
	}
	
	@Test
	@DisplayName("Test multiply method")
	void testMultiply() {
		double result = calculator.multiply(10, 50);
		assertEquals(500, result);
	}
	
	@Test
	@DisplayName("Test divide method")
	void testDivide() {
		double result = calculator.divide(50, 10);
		assertEquals(5, result);
	}	
	@Test
	@DisplayName("Test divide by zero")
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, () -> calculator.divide(50, 0));
	}
	
	@Test
	@DisplayName("Multiple assertions")
	
	void testMultipleAssertions() {
		assertAll(
				() -> assertEquals(60, calculator.add(10, 50)), 
				() -> assertEquals(40, calculator.subtract(50, 10)),
				() -> assertEquals(500, calculator.multiply(10, 50)), 
				() -> assertEquals(5, calculator.divide(50, 10))
				);
	}

}
