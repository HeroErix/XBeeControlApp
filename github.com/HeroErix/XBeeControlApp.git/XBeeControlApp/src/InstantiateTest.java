import static org.junit.Assert.*;

import org.junit.Test;

public class InstantiateTest {

	InterfaceControl test = new InterfaceControl();
	
	@Test
	public void setupTest() {
		test.main(null);
		assertNotNull(test.setup);
	}
	
	@Test
	public void windowTest() {
		test.main(null);
		test.setup.button.doClick();
		assertNotNull(test.setup.window);
	}	
	
	@Test
	public void mySenderTest() {
		test.main(null);
		assertNotNull(test.mySender);
	}
	
	@Test
	public void myDeviceTest() {
		test.main(null);
		assertNotNull(test.mySender.myDevice);
	}

}
