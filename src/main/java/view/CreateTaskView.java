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
import model.*;
import model.EventRequest;
import model.Position;


public class CreateTaskView extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField originalBudgetField;
	JButton createButton = new JButton("Create");
	private JTextField descriptionField;
	private JLabel lblDescription;
	private JList eventList;
	private int currentEventId;
	private User currentUser;
	private JLabel lblTeam;
	private JList teamList;


	public CreateTaskView(Controller controller, User currentUser) {
		super("SEP Task View page");
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
		
		originalBudgetField = new JTextField();
		originalBudgetField.setBounds(164, 10, 114, 19);
		panel.add(originalBudgetField);
		originalBudgetField.setColumns(10);
		
		JLabel lblOriginalBudget = new JLabel("Budget");
		lblOriginalBudget.setBounds(12, 12, 114, 19);
		panel.add(lblOriginalBudget);
		
		
		JLabel eventsLabel = new JLabel("Events List");
		eventsLabel.setBounds(328, 12, 70, 15);
		panel.add(eventsLabel);
		
		
		createButton.setBounds(233, 313, 117, 25);
		panel.add(createButton);
		
		descriptionField = new JTextField();
		descriptionField.setBounds(135, 64, 163, 86);
		panel.add(descriptionField);
		descriptionField.setColumns(10);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 66, 105, 15);
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
		
		
		createTaskAction();
		setVisible(true);
		
		
		
	}
	
	
	
	public void createTaskAction(){
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double originalBudget = Double.valueOf(originalBudgetField.getText());
				String description = descriptionField.getText();
				EventRequest event = (EventRequest) eventList.getSelectedValue();
				Team team = (Team) teamList.getSelectedValue();
				controller.createTask(currentUser, originalBudget, 0, description, "", event,team);
			}
		});
	}
}
