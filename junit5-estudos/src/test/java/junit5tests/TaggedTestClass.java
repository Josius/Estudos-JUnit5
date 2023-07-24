package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
public class TaggedTestClass {

	@BeforeAll
	void beforeAll() {
		System.out.println("--This is the before all method");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("***This is the before each method***");
	}

	@AfterAll
	void afterAll() {
		System.out.println("++This is the after all method");
	}

	@AfterEach
	void afterEach() {
		System.out.println("%%%This is the after each method");
	}

	@Test
	@Tag("sanity")
	void firsMethod() {
		System.out.println("Este é o primeiro método de teste");
	}

	@Test
	@Tag("sanity")
	@Tag("acceptance")
	@DisplayName("BR5678 - CT21 - Este é o segundo método de teste que será executado")
	void secondMethod() {
		System.out.println("Este é o segundo método de teste");
	}

	@Test
	@Tag("acceptance")
	void thirdMethod() {
		System.out.println("This is the third method!");
	}

	@Tag("acceptance")
	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@ValueSource(ints = {1, 5, 6})
	void intValues(int theParam) {
		System.out.println("theParam : " + theParam);
	}
}
