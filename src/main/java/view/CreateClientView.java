package view;

import javax.swing.*;

import controller.Controller;

import java.awt.*;
import java.awt.event.*;

public class CreateClientView extends JFrame {

	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField clientName;
	private JTextField clientEmail;
	private JLabel lblDate;
	private JTextField clientPhone;
	private JLabel lblDateTo;
	JButton btnSubmit = new JButton("Submit");
	

	public CreateClientView(Controller controller) {
		super("SEP create task page");
		setSize(800, 600);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		setLocation(xPos, yPos);
		panel.setLayout(null);
		
		this.controller = controller;
		
		

		getContentPane().add(panel);
		
		clientName = new JTextField();
		clientName.setBounds(164, 30, 114, 19);
		panel.add(clientName);
		clientName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(47, 32, 70, 15);
		panel.add(lblName);
		
		clientEmail = new JTextField();
		clientEmail.setBounds(164, 76, 114, 19);
		panel.add(clientEmail);
		clientEmail.setColumns(10);
		
		lblDate = new JLabel("Email");
		lblDate.setBounds(47, 78, 99, 15);
		panel.add(lblDate);
		
	
		
		btnSubmit.setBounds(161, 176, 117, 25);
		panel.add(btnSubmit);
		
		clientPhone = new JTextField();
		clientPhone.setBounds(164, 114, 114, 19);
		panel.add(clientPhone);
		clientPhone.setColumns(10);
		
		lblDateTo = new JLabel("Phone");
		lblDateTo.setBounds(47, 116, 99, 15);
		panel.add(lblDateTo);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		createClientListener();
	}






	
	public void createClientListener(){
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = clientName.getText();
				String email = clientEmail.getText();
				String phone = clientPhone.getText();
				controller.createClient(name,email,phone);
			}
		});
	}
	
	public JButton getSubmitBtn(){
		return btnSubmit;
	}

	public JTextField getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName.setText(clientName);
	}

	public JTextField getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail.setText(clientEmail);
	}

	public JLabel getLblDate() {
		return lblDate;
	}

	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public JTextField getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone.setText(clientPhone);
	}

	public JLabel getLblDateTo() {
		return lblDateTo;
	}

	public void setLblDateTo(JLabel lblDateTo) {
		this.lblDateTo = lblDateTo;
	}
}
