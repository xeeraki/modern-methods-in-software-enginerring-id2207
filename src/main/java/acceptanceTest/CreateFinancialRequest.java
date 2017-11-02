package acceptanceTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controller;
import model.EventRequest;
import model.User;


public class CreateFinancialRequest extends JFrame {
	
	private final Controller controller;
	JPanel panel = new JPanel();
	JButton createButton = new JButton("Create");
	private JTextField descriptionField;
	private JLabel lblDescription;
	private JList eventList;
	private User currentUser;
	private JLabel lblFinance;
	private JTextField financeField;


	public CreateFinancialRequest(Controller controller, User currentUser) {
		super("SEP Financial Request");
		setSize(800, 600);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		setLocation(xPos, yPos);
		panel.setLayout(null);

		this.controller = controller;
		this.currentUser = currentUser;


		getContentPane().add(panel);


		JLabel eventsLabel = new JLabel("Events");
		eventsLabel.setBounds(328, 12, 70, 15);
		panel.add(eventsLabel);


		createButton.setBounds(233, 313, 117, 25);
		panel.add(createButton);

		descriptionField = new JTextField();
		descriptionField.setBounds(135, 29, 163, 86);
		panel.add(descriptionField);
		descriptionField.setColumns(10);

		lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 27, 105, 15);
		panel.add(lblDescription);

		List<EventRequest> event= controller.getEvents();
		EventRequest[] events  = event.toArray(new EventRequest[event.size()]);

		eventList = new JList(events);
		panel.add(eventList);
		eventList.setBounds(338, 42, 228, 93);
		JScrollPane pane = new JScrollPane();

		getContentPane().add(pane, BorderLayout.NORTH);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



		lblFinance = new JLabel("Financial");
		lblFinance.setBounds(12, 159, 105, 15);
		panel.add(lblFinance);

		financeField = new JTextField();
		financeField.setColumns(10);
		financeField.setBounds(135, 157, 163, 86);
		panel.add(financeField);


		createResourceListener();
		setVisible(true);


	}

	public void createResourceListener(){
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = descriptionField.getText();
				String finance = financeField.getText();
				EventRequest event = (EventRequest) eventList.getSelectedValue();
				controller.createFinancialRequest(event, description, finance, currentUser);
			}
		});
	}

}
