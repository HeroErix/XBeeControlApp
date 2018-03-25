import java.awt.EventQueue;

public class InterfaceControl {
	
	private final static int BAUD_RATE = 9600;
	private static String port = "COM5";
	private static String command = "";
	static DataSender mySender;
	static PortSetup setup;
	
	public static void main(String[] args) {
		setup = new PortSetup();
		setup.frame.setVisible(true);
		mySender = new DataSender(port, getBaudRate());	
	}	
	
	public static void send() {
		mySender.send(command);
	}

	public String getCommand() {
		return command;
	}

	public static void setCommand(String command) {
		InterfaceControl.command = command;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		InterfaceControl.port = "COM" + port;
		System.out.println(InterfaceControl.port);
		mySender = new DataSender(getPort(), getBaudRate());	
	}

	public static int getBaudRate() {
		return BAUD_RATE;
	}
}
