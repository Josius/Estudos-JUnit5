package junit5tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

	@ParameterizedTest(name = "Run: {index} - value: {arguments}")
	@ValueSource(ints = {1, 5, 6})
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
	@ValueSource(strings = {"firstString", "segundaString"})
	void stringValues(String theParam) {
		System.out.println("theParam: " + theParam);
	}

	@ParameterizedTest
	// abaixo, como o método recebe 2 parâmetros, enviamos string separada por
	// vírgula
	@CsvSource(value = {"ciclops,wolverine", "rogue,storm", "beast,gambit", "jubilee, jean grey", "professor,X"})
	void csvSource_StringString(String param_1, String param_2) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}

	@ParameterizedTest
	// abaixo, não precisamos especificar o tipo do dado enviado, somente separar
	// por vírgula dentro de aspas duplas e a ordem deve estar como no método que
	// receberá
	@CsvSource(value = {"ciclops,32,true", "rogue,21,false", "beast,5,true"})
		// abaixo, necessário especificar o tipo de parâmetro a ser recebido
	void csvSource_StringIntBoolean(String param_1, int param_2, boolean param_3) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2 + ", param_3: " + param_3);
	}

	// se a string passada tiver uma vírgula em seu texto, precisamos passar um
	// escape -> ('') para não entender essa vírgula como um separador para o método
	@ParameterizedTest
	@CsvSource(value = {"ciclops,'Summers, Scott'", "wolverine,'X,Arma'"})
	void csvSource_StringWithComa(String param_1, String param_2) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}

	// se em algum cenário não pudermos usar a vírgula como delimitador de
	// parâmetros, podemos mudar o tipo de delimitador como um atributo da
	// annotation
	@ParameterizedTest
	@CsvSource(value = {"ciclops?wolverine", "rogue?storm", "beast?gambit", "jubilee?jean grey",
			"professor?X"}, delimiter = '?')
	void csvSource_StringWithDiffDelimiter(String param_1, String param_2) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}

	// passando parâmetros oriundos de um arquivo csv
	@ParameterizedTest
	// abaixo, numLinesToSkip não lê a 1ª linha do arquivo csv
	@CsvFileSource(files = "src/test/resources/params/shoppinglist.csv", numLinesToSkip = 1)
	void csvFileSource_StringDoubleIntStringString(String name, double price, int qty, String uom, String provider) {
		System.out.println(
				"name: " + name + ", price: " + price + ", qty: " + qty + ", uom: " + uom + ", provider: " + provider);
	}

	// passando parâmetros oriundos de dois arquivos csv's
	@ParameterizedTest
	// abaixo, numLinesToSkip não lê a 1ª linha do arquivo csv e lê dois csv's ao
	// alocar dentro de um array
	@CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv",
			"src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
	void csvFileSource_StringDoubleIntStringString2(String name, double price, int qty, String uom, String provider) {
		System.out.println(
				"name: " + name + ", price: " + price + ", qty: " + qty + ", uom: " + uom + ", provider: " + provider);
	}

	// passando parâmetros oriundos de um arquivo csv com outro caractere
	// delimitador
	// não podemos usar delimiter e delimiterString ao mesmo tempo no mesmo arquivo
	@ParameterizedTest
	// abaixo, numLinesToSkip não lê a 1ª linha do arquivo csv
	@CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "___")
	void csvFileSource_StringDoubleIntStringStringSpecifierDelimiter(String name, double price, int qty, String uom,
																	 String provider) {
		System.out.println(
				"name: " + name + ", price: " + price + ", qty: " + qty + ", uom: " + uom + ", provider: " + provider);
	}
	/*
	 * SOBRE STRING VAZIA E NULL NO ARQUIVO CSV (ver no arquivo shoppinglist3.csv)
	 * se quisermos especificar uma string vazia, no campo desejado colocamos aspas duplas vazias
	 * se quisermos especificar uma string null, no campo desejado deixamos vazio, sem nada
	 */

	/*
	 * SOBRE SOURCE METHOD
	 * Podem ser qualquer método da mesma classe dos métodos de teste ou de uma
	 * classe diferente.
	 * Se forem de uma classe diferente, eles precisam ser estáticos
	 * Se forem da mesma classe, podemos declará-los como estáticos a menos que já
	 * tenhamos usado @TestInstance(TestInstance.Lifecycle.PER_CLASS), o qual faz isso por nós
	 */

	//  oriundo de uma lista
	@ParameterizedTest
	@MethodSource(value = "sourceString")
	void methodSource_String(String param) {
		System.out.println("param: " + param);
	}

	List<String> sourceString() {
		// processing done her
		return Arrays.asList("mixirica", "maçã", "banana");
	}

	// oriundo de um stream
	@ParameterizedTest
	@MethodSource(value = "sourceStringAsStream")
	void methodSource_StringStream(String param) {
		System.out.println("param: " + param);
	}

	Stream<String> sourceStringAsStream() {
		// processing
		return Stream.of("beetroot", "apple", "pear");
	}

	// se quisermos testar métodos que tenham a assinatura com mais parâmetros, por exemplo, um método que tenha
	// string e double, que precisamos passar para cada execução de teste? Para isso criamos um método que returna
	// qualquer lista de Arguments ou stream de Arguments, no caso Arguments -> org.junit.jupiter.params.provider
	// .Arguments;
	@ParameterizedTest
	@MethodSource(value = "sourceList_StringDouble")
	void methodSource_StringDoubleList(String param_1, double param_2) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}

	// ao invés de 'Arguments.arguments[...]', importamos o static de 'Arguments' e usamos como abaixo:
	List<Arguments> sourceList_StringDouble() {
		// processing
		return Arrays.asList(arguments("batata", 3.6),
				arguments("carrot", 7.2),
				arguments("cabbage", 10.8));
	}

	// o mesmo acima pode ser feito se quisermos um stream de Arguments
	@ParameterizedTest
	@MethodSource(value = "sourceStream_StringDouble")
	void methodSource_StringDoubleStream(String param_1, double param_2) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}

	Stream<Arguments> sourceStream_StringDouble() {
		// processing
		return Stream.of(arguments("cebola", 8.5),
				arguments("alho", 7.2),
				arguments("garlic", 10.8));
	}

	/* SOBRE MÉTODOS ORIUNDOS DE UMA CLASSE QUE NÃO É A CLASSE DE TESTE, UMA OUTRA CLASSE
	 * para chamar o método de outra classe usamos em value:
	 * nome_do_pacote + nome_da_classe + nome_do_método
	 * o método sempre precisa ser estático
	 */
	@ParameterizedTest
	@MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
	void methodSource_StringDoubleStreamFromDiffClass(String param_1, double param_2) {
		System.out.println("param_1: " + param_1 + ", param_2: " + param_2);
	}
}