package junit5tests;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {
	
	// se o método está em uma classe diferente da classe de teste, esse método sempre precisa ser estático
	static Stream<Arguments> sourceStream_StringDouble() {
		// processing
		return Stream.of(arguments("oriundo", 8.5), 
								arguments("de", 7.2),
								arguments("outra", 10.8),
								arguments("classe", 8.1));
	}
}
