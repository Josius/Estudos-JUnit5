package junit5tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class FirstTestClass {

	@BeforeAll
	void beforeAll(){
		System.out.println("--This is the before all method");
	}

	@BeforeEach
	void beforeEach(){
		System.out.println("***This is the before each method***");
	}

	@AfterAll
	void afterAll(){
		System.out.println("++This is the after all method");
	}

	@AfterEach
	void afterEach(){
		System.out.println("%%%This is the after each method");
	}

	@Test
	void firsMethod() {
		System.out.println("Este é o primeiro método de teste");
	}

	@Test
	@DisplayName("BR5678 - CT21 - Este é o segundo método de teste que será executado")
	void secondMethod() {
		System.out.println("Este é o segundo método de teste");
	}
}
