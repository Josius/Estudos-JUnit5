package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@ValueSource(ints = { 1, 5, 6 })
	void intValues(int theParam) {
		System.out.println("theParam : " + theParam);
	}

	@ParameterizedTest
	// as 3 annotations abaixo devem ser usadas somente com métodos que recebem um único parâmetro
	@NullAndEmptySource // passa uma string null e uma string vazia
	// @NullSource // passa um string null, também não usar com tipos primitivos
	// @EmptySource // string vazia passada para o @ValueSource, não usar com tipos primitivos, como no método acima
	@ValueSource(strings = { "firstString", "segundaString" })
	void stringValues(String theParam) {
		System.out.println("theParam: " + theParam);
	}
}