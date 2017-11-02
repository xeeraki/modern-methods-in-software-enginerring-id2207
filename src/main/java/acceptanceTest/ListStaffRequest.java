package acceptanceTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import model.StaffRequest;
import model.User;

public class ListStaffRequest extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField teamField;
	private JTextField eventField;
	JButton closeButton = new JButton("Close");
	private JLabel lblEvent;
	private JTextPane descriptionField;
	private JLabel lblDescription;
	private JList requestList;
	private int currentEventId;
	private User currentUser;


	public ListStaffRequest(Controller controller, User currentUser) {
		super("SEP List Staff Request");
		this.controller = controller;
		this.currentUser = currentUser;
		setSize(800, 600);
		View();
		closeStaffReqListener();
		setVisible(true);

	}

	private void View() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		setLocation(xPos, yPos);
		panel.setLayout(null);


		getContentPane().add(panel);

		teamField = new JTextField();
		teamField.setBounds(164, 10, 150, 19);
		panel.add(teamField);
		teamField.setColumns(10);

		JLabel lblTeamName = new JLabel("Team");
		lblTeamName.setBounds(12, 12, 117, 15);
		panel.add(lblTeamName);

		eventField = new JTextField();
		eventField.setBounds(164, 41, 114, 19);
		panel.add(eventField);
		eventField.setColumns(10);

		lblEvent = new JLabel("Event");
		lblEvent.setBounds(12, 39, 134, 15);
		panel.add(lblEvent);

		descriptionField = new JTextPane();
		descriptionField.setBounds(164, 85, 119, 88);
		panel.add(descriptionField);

		lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 84, 134, 15);
		panel.add(lblDescription);


		JLabel requestLabel = new JLabel("Staff Requests");
		requestLabel.setBounds(328, 32, 114, 15);
		panel.add(requestLabel);

		List<StaffRequest> req = controller.getStaffReq();

		StaffRequest[] requests  = req.toArray(new StaffRequest[req.size()]);

		requestList = new JList(requests);
		panel.add(requestList);
		requestList.setBounds(356, 59, 228, 167);
		JScrollPane pane = new JScrollPane();

		getContentPane().add(pane, BorderLayout.NORTH);


		closeButton.setBounds(237, 314, 117, 25);
		panel.add(closeButton);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addListMouseListener(requestList);
		closeButton.setVisible(true);
	}

	public void addListMouseListener(JList list) {
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				StaffRequest req = (StaffRequest) list.getModel().getElementAt(index);
				teamField.setText(req.getTeam().getName());
				eventField.setText(req.getEvent().getName());
				descriptionField.setText(req.getDescription());
				
				
				
			}
			
		});
	}
	

	public void closeStaffReqListener(){
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffRequest req = (StaffRequest) requestList.getSelectedValue();
				controller.deleteStaffRequest(req);
				
			}
		});
	}
	
	
}
