package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisabledEnabledTest {

	@Test
	@Disabled(value = "Disabled for demo of @Disabled")
	void firstTest() {
		System.out.println("The first teste is here!");
	}
	
	@Test
	@DisabledOnOs(value = OS.LINUX, disabledReason = "Disabled for demo of" + "@DisabledOnOs")
	void secondTest() {
		System.out.println("The second teste is here!");
	}
	
	@Test
	@EnabledOnOs(value = OS.LINUX, disabledReason = "Disabled for demo of" + "@DisabledOnOs")
	void secondAndAHalfTest() {
		System.out.println("The secondAndAHalf teste is here!");
	}
	
	@Test
//	@DisabledIfSystemProperties(named = "env", matches = "staging")
	void thirdTest() {
		System.out.println("The third teste is here!");
	}
	
	@Test
	@DisabledIf(value = "provider", disabledReason = "Disabled for demod of @DisabledIf")
	void fourthTest() {
		System.out.println("The fourth teste is here!");
	}

	boolean provider(){
		return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY);
	}

	@Test
	void fifthTest() {
		System.out.println("The fifth teste is here!");
	}


}
