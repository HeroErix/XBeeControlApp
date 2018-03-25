import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;

public class ControlWindow {

	JFrame frame;
	JLabel lblCommand;
	JSpinner spinner;
	JSpinner spinner_1;
	JButton btnSet;
	JButton btnReset;
	JButton button;
	JButton button_1;
	JButton btnOff_2;
	JButton btnOn_2;
	JButton btnOff_1;
	JButton btnOn_1;
	JButton btnOff;
	JButton btnOn;
	JButton btnConf;
	
	/**
	 * Create the application.
	 */
	public ControlWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("XBee Command Window");
		frame.setBounds(100, 100, 674, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Flow Meter", null, panel_1, null);
		
		JLabel lblLedPosition = new JLabel("LED Position:");
		panel_1.add(lblLedPosition);
		
		spinner = new JSpinner();
		panel_1.add(spinner);
		
		btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(spinner.getValue().toString()){
					case "0": setCommand("DFAA"); break;
					case "1": setCommand("DFAB"); break;
					case "2": setCommand("DFAC"); break;
					case "3": setCommand("DFAD"); break;
					case "4": setCommand("DFAE"); break;
					case "5": setCommand("DFAF"); break;
					case "6": setCommand("DFAG"); break;
					case "7": setCommand("DFAH"); break;
					case "8": setCommand("DFAI"); break;
					case "9": setCommand("DFAJ"); break;
					case "10": setCommand("DFAK"); break;
					case "11": setCommand("DFAL"); break;
					case "12": setCommand("DFAM"); break;
					case "13": setCommand("DFAN"); break;
					case "14": setCommand("DFAO"); break;
					default: lblCommand.setText("Command Invalid"); break;
				}
			}
		});
		panel_1.add(btnSet);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DFAR");
			}
		});
		panel_1.add(btnReset);
		
		button = new JButton("+");
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DFA+");
			}
		});
		
		button_1 = new JButton("-");
		panel_1.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DFA-");
			}
		});
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Ventilator", null, panel_3, null);
		
		JLabel lblLeak = new JLabel("Leak:");
		panel_3.add(lblLeak);
		
		btnOff_2 = new JButton("Off");
		btnOff_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DVA0");
			}
		});
		panel_3.add(btnOff_2);
		
		btnOn_2 = new JButton("On");
		btnOn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DVA1");
			}
		});
		panel_3.add(btnOn_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("IV Pump", null, panel_2, null);
		panel_2.setLayout(new GridLayout(2, 3, 0, 0));
		
		JLabel lblAir = new JLabel("Air:");
		panel_2.add(lblAir);
		
		btnOff = new JButton("Off");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DIA0");
			}
		});
		panel_2.add(btnOff);
		
		btnOn = new JButton("On");
		btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DIA1");
			}
		});
		panel_2.add(btnOn);
		
		JLabel lblCrimp = new JLabel("Crimp:");
		panel_2.add(lblCrimp);
		
		btnOff_1 = new JButton("Off");
		btnOff_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DIA2");
			}
		});
		panel_2.add(btnOff_1);
		
		btnOn_1 = new JButton("On");
		btnOn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommand("DIA3");
			}
		});
		panel_2.add(btnOn_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Port", null, panel, null);
		
		JLabel label = new JLabel("Port #:");
		panel.add(label);
		
		spinner_1 = new JSpinner();
		panel.add(spinner_1);
		
		btnConf = new JButton("Confirm");
		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceControl.setPort(spinner_1.getValue().toString());
				lblCommand.setText("COM" + spinner_1.getValue().toString());
			}
		});
		panel.add(btnConf);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		
		lblCommand = new JLabel("Command");
		panel_4.add(lblCommand);
		
		JButton btnSendCommand = new JButton("Send Command");
		btnSendCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceControl.send();
			}
		});
		panel_4.add(btnSendCommand);
	}
	
	void setCommand(String command){
		InterfaceControl.setCommand(command);
		lblCommand.setText(command);
	}

}
