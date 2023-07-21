package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
/* SOBRE ASSUMPTIONS
 * Com base em certa condição booleana, podemos pular a execução de certos testes
 */
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsTest {

	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@ValueSource(ints = { 1, 5, 6 })
	void intValues(int theParam) {
		assumeTrue(theParam > 4);
		System.out.println("theParam : " + theParam);
	}

	@ParameterizedTest
	@CsvSource(value = { "ciclops,wolverine", "rogue,storm", "beast,gambit", "jubilee, jean grey", "professor,X" })
	void csvSource_StringString(String param_1, String param_2) {
		assumeFalse("ciclops".equals(param_1), "The assumption failed for the " + param_2);
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}

	@ParameterizedTest
	@CsvSource(value = { "ciclops,32,true", "rogue,21,false", "beast,5,true" })
	void csvSource_StringIntBoolean(String param_1, int param_2, boolean param_3) {
		assumingThat(param_2 > 20, () -> System.out.println("This code ran"));
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2 + ", param_3: " + param_3);
	}
}
