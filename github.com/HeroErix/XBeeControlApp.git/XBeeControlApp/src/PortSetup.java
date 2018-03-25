import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PortSetup {

	JFrame frame;
	JButton button;
	JSpinner spinner;
	ControlWindow window;

	/**
	 * Create the application.
	 */
	public PortSetup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 333);
		frame.setTitle("XBee Port Setup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPortRequest = new JLabel("Please enter a number for the port where the controller is attached to the computer.");
		panel.add(lblPortRequest);
		
		JLabel label = new JLabel("Port #:");
		panel.add(label);
		
		spinner = new JSpinner();
		panel.add(spinner);
		
		button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = spinner.getValue().toString();
				InterfaceControl.setPort(p);
				window = new ControlWindow();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		panel.add(button);
	}

}
