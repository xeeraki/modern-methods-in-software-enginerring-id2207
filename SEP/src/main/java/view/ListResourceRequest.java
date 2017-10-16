package view;

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
import model.ResourceRequest;
import model.User;

public class ListResourceRequest extends JFrame {
	
	private final Controller controller;


	JPanel panel = new JPanel();
	private JTextField managerField;
	JButton closeButton = new JButton("Close");
	private JLabel lblResources;
	private JTextPane descriptionField;
	private JLabel lblDescription;
	private JList requestList;
	private int currentEventId;
	private User currentUser;
	JTextPane resourcesField = new JTextPane();


	public ListResourceRequest(Controller controller, User currentUser) {
		super("SEP Resource request page");
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
		
		managerField = new JTextField();
		managerField.setBounds(164, 10, 114, 19);
		panel.add(managerField);
		managerField.setColumns(10);
		
		JLabel lblManagerName = new JLabel("Manager");
		lblManagerName.setBounds(12, 12, 117, 15);
		panel.add(lblManagerName);
		
		lblResources = new JLabel("Resources");
		lblResources.setBounds(12, 39, 134, 15);
		panel.add(lblResources);
		
		descriptionField = new JTextPane();
		descriptionField.setBounds(164, 138, 119, 88);
		panel.add(descriptionField);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 140, 134, 15);
		panel.add(lblDescription);
		
		
		JLabel requestLabel = new JLabel("Resource Requests");
		requestLabel.setBounds(328, 32, 160, 15);
		panel.add(requestLabel);
		
		List<ResourceRequest> req = controller.getResourceReq();
		
		ResourceRequest[] requests  = req.toArray(new ResourceRequest[req.size()]);
		
		requestList = new JList(requests);
		panel.add(requestList);
		requestList.setBounds(356, 59, 228, 167);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		
		
		closeButton.setBounds(237, 314, 117, 25);
		panel.add(closeButton);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addListMouseListener(requestList);
		
		
		resourcesField.setBounds(164, 41, 119, 88);
		panel.add(resourcesField);
		closeButton.setVisible(true);
		
	
		closeResourceReqListener();
		
		setVisible(true);
		
		
		
	}
	
	public void addListMouseListener(JList list) {
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				ResourceRequest req = (ResourceRequest) list.getModel().getElementAt(index);
				managerField.setText(req.getManager().getPosition().toString());
				resourcesField.setText(req.getResources());
				
				descriptionField.setText(req.getDescription());
			}
			
		});
	}
	

	public void closeResourceReqListener(){
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResourceRequest req = (ResourceRequest) requestList.getSelectedValue();
				controller.deleteResourceRequest(req);
				
			}
		});
	}
}
