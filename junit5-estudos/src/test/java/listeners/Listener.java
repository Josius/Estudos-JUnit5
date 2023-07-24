package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
		System.out.println("This test was Disabled: " + context.getTestMethod() + " - with reason: " + reason);
		System.out.println(	"--------------------");
	}

	@Override
	public void testSuccessful(ExtensionContext context) {
		System.out.println("This test was Sucessful: " + context.getTestMethod());
		System.out.println(	"--------------------");
	}

	@Override
	public void testAborted(ExtensionContext context, Throwable cause) {
		System.out.println("This test was aborted: " + cause.getMessage());
		System.out.println(	"--------------------");
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		System.out.println("This test was failed: " + cause.getMessage());
		System.out.println(	"--------------------");
	}
}
