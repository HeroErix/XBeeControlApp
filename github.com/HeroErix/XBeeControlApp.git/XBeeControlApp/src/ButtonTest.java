import static org.junit.Assert.*;

import org.junit.Test;

public class ButtonTest {

	InterfaceControl test = new InterfaceControl();
	ControlWindow window = new ControlWindow();
	
	@Test
	public void btnSetTest() {
		window.btnSet.doClick();
		assertEquals(window.lblCommand.getText(), ("DFA" + (char) ((int)window.spinner.getValue()+65)));	
	}
	
	@Test
	public void btnResetTest() {
		window.btnReset.doClick();
		assertEquals(window.lblCommand.getText(), "DFAR");	
	}
	
	@Test
	public void buttonTest() {
		window.button.doClick();
		assertEquals(window.lblCommand.getText(), "DFA+");	
	}
	
	@Test
	public void button1Test() {
		window.button_1.doClick();
		assertEquals(window.lblCommand.getText(), "DFA-");	
	}
	
	@Test
	public void btnOffTest() {
		window.btnOff.doClick();
		assertEquals(window.lblCommand.getText(), "DIA0");	
	}
	
	@Test
	public void btnOnTest() {
		window.btnOn.doClick();
		assertEquals(window.lblCommand.getText(), "DIA1");	
	}
	@Test
	public void btnOff1Test() {
		window.btnOff_1.doClick();
		assertEquals(window.lblCommand.getText(), "DIA2");	
	}
	@Test
	public void btnOn1Test() {
		window.btnOn_1.doClick();
		assertEquals(window.lblCommand.getText(), "DIA3");	
	}
	@Test
	public void btnOff2Test() {
		window.btnOff_2.doClick();
		assertEquals(window.lblCommand.getText(), "DVA0");	
	}
	@Test
	public void btnOn2Test() {
		window.btnOn_2.doClick();
		assertEquals(window.lblCommand.getText(), "DVA1");	
	}
	
	@Test
	public void btnConfTest() {
		window.btnConf.doClick();
		assertEquals(window.lblCommand.getText(), "COM" + window.spinner_1.getValue().toString());	
	}

}
