package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.Controller;
import model.Client;
import model.EventRequest;
import model.Position;
import model.Team;
import model.User;
import org.w3c.dom.events.EventException;


public class CreateResourceRequest extends JFrame {
	
	private final Controller controller;
	JPanel panel = new JPanel();
	JButton createButton = new JButton("Create");
	private JTextField descriptionField;
	private JLabel lblDescription;
	private JList eventList;
	private User currentUser;
	private JLabel lblResources;
	private JTextField resourcesField;


	public CreateResourceRequest(Controller controller, User currentUser) {
		super("SEP Resources Request");
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



		lblResources = new JLabel("Resources");
		lblResources.setBounds(12, 159, 105, 15);
		panel.add(lblResources);

		resourcesField = new JTextField();
		resourcesField.setColumns(10);
		resourcesField.setBounds(135, 157, 163, 86);
		panel.add(resourcesField);


		createResourceListener();
		setVisible(true);



	}



	public void createResourceListener(){
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = descriptionField.getText();
				String resources = resourcesField.getText();
				EventRequest event = (EventRequest) eventList.getSelectedValue();
				controller.createResourceRequest(event, description, resources, currentUser);
			}
		});
	}

}
