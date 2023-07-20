package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestClass {

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
