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
import model.Status;
import model.Task;
import model.Team;
import model.User;


public class CreateStaffRequest extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	JButton createButton = new JButton("Create");
	private JTextField descriptionField;
	private JLabel lblDescription;
	private JList eventList;
	private int currentEventId;
	private User currentUser;
	private JLabel lblTeam;
	private JList teamList;


	public CreateStaffRequest(Controller controller, User currentUser) {
		super("SEP Staff Request");
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
		
		List<EventRequest> event = controller.getEvents();
		EventRequest[] events  = event.toArray(new EventRequest[event.size()]);
		
		eventList = new JList(events);
		panel.add(eventList);
		eventList.setBounds(338, 42, 228, 93);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		lblTeam = new JLabel("Team");
		lblTeam.setBounds(12, 159, 70, 15);
		panel.add(lblTeam);
		
		List <Team> team = new ArrayList<>();
		
		if(currentUser.getPosition() == Position.ProductionManager){
			team = controller.getProductionTeam();
		}
		
		if(currentUser.getPosition() == Position.ServiceManager){
			team = controller.getServiceTeam();
		}
		
		Team[] teams  = team.toArray(new Team[team.size()]);
		
		
		teamList = new JList(teams);
		teamList.setBounds(86, 173, 217, 77);
		panel.add(teamList);
		
		
		createStaffListener();
		setVisible(true);
		
		
		
	}
	
	
	
	public void createStaffListener(){
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = descriptionField.getText();
				EventRequest event = (EventRequest) eventList.getSelectedValue();
				Team team = (Team) teamList.getSelectedValue();
				controller.createStaffRequest(event, team, description);
			}
		});
	}
}
