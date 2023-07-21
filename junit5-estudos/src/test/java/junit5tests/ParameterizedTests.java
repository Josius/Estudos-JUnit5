package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
	// as 3 annotations abaixo devem ser usadas somente com métodos que recebem um
	// único parâmetro
	@NullAndEmptySource // passa uma string null e uma string vazia
	// @NullSource // passa um string null, também não usar com tipos primitivos
	// @EmptySource // string vazia passada para o @ValueSource, não usar com tipos
	// primitivos, como no método acima
	@ValueSource(strings = { "firstString", "segundaString" })
	void stringValues(String theParam) {
		System.out.println("theParam: " + theParam);
	}

	@ParameterizedTest
	// abaixo, como o método recebe 2 parâmetros, enviamos string separada por vírgula
	@CsvSource(value = { "ciclops,wolverine", "rogue,storm", "beast,gambit", "jubilee, jean grey", "professor,X" }) 
	void csvSource_doubleString(String param_1, String param_2) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}

	@ParameterizedTest
	// abaixo, não precisamos especificar o tipo do dado enviado, somente separar por vírgula dentro de aspas duplas e a ordem deve estar como no método que receberá
	@CsvSource(value = {"ciclops,32,true", "rogue,21,false", "beast,5,true"})
	// abaixo, necessário especificar o tipo de parâmetro a ser recebido
	void csvSource_StringIntBoolean(String param_1, int param_2, boolean param_3) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2 + ", param_3: " + param_3);
	}

	// se a string passada tiver uma vírgula em seu texto, precisamos passar um escape -> ('') para não entender essa vírgula como um separador para o método
	@ParameterizedTest
	@CsvSource(value = {"ciclops,'Summers, Scott'", "wolverine,'X,Arma'"})
	void csvSource_StringWithComa(String param_1, String param_2){
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}

	// se em algum cenário não pudermos usar a vírgula como delimitador de parâmetros, podemos mudar o tipo de delimitador como um atributo da annotation
	@ParameterizedTest
	@CsvSource(value = { "ciclops?wolverine", "rogue?storm", "beast?gambit", "jubilee?jean grey", "professor?X" }, delimiter = '?') 
	void csvSource_StringWithDiffDelimiter(String param_1, String param_2) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}
}