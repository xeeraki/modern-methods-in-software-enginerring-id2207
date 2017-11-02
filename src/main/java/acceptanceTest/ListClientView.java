package acceptanceTest;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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



public class ListClientView extends JFrame {

    private final Controller controller;


    JPanel panel = new JPanel();
    private JTextField clientNameField;
    private JTextField clientPhoneField;
    private JLabel lblDate;
    private JTextPane clientEventField;
    private JLabel lblClientEvents;
    private JTextField clientEmailField;
    private JLabel lblDateTo;
    private JList eventList;
    private int currentEventId;

    public ListClientView(Controller controller) {
        super("SEP Client List View");
        this.controller = controller;
        View();
        addListMouseListener(eventList);
        setVisible(true);


    }


    private void View() {
        setSize(600, 400);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        setLocation(xPos, yPos);
        panel.setLayout(null);


        getContentPane().add(panel);

        clientNameField = new JTextField();
        clientNameField.setBounds(164, 10, 114, 19);
        panel.add(clientNameField);
        clientNameField.setColumns(10);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(47, 12, 70, 15);
        panel.add(lblName);

        clientPhoneField = new JTextField();
        clientPhoneField.setBounds(164, 41, 114, 19);
        panel.add(clientPhoneField);
        clientPhoneField.setColumns(10);

        lblDate = new JLabel("Phone");
        lblDate.setBounds(47, 39, 99, 15);
        panel.add(lblDate);

        clientEventField = new JTextPane();
        clientEventField.setBounds(127, 122, 156, 175);
        panel.add(clientEventField);

        lblClientEvents = new JLabel("Events");
        lblClientEvents.setBounds(47, 120, 99, 15);
        panel.add(lblClientEvents);


        JLabel clientsLabel = new JLabel("Clients");
        clientsLabel.setBounds(328, 32, 70, 15);
        panel.add(clientsLabel);

        clientEmailField = new JTextField();
        clientEmailField.setBounds(164, 64, 114, 19);
        panel.add(clientEmailField);
        clientEmailField.setColumns(10);

        lblDateTo = new JLabel("Email");
        lblDateTo.setBounds(47, 66, 70, 15);
        panel.add(lblDateTo);

        List<Client> client = controller.getClients();
        Client[] clients = client.toArray(new Client[client.size()]);

        eventList = new JList(clients);
        panel.add(eventList);
        eventList.setBounds(356, 59, 228, 167);
        JScrollPane pane = new JScrollPane();

        getContentPane().add(pane, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addListMouseListener(JList list) {
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                Client client = (Client) list.getModel().getElementAt(index);
                /*List<EventRequest> events = controller.getEventsWithClient(client);

                StringBuilder sb = new StringBuilder();
                for (EventRequest event : events) {
                    sb.append(event.getName() + " budget: " + event.getBudget() + "\n");
                }*/
                //clientEventField.setText(sb.toString());
                clientNameField.setText(client.getName());
                clientEmailField.setText(client.getMail());
                clientPhoneField.setText(client.getPhone());
            }

        });
    }

    public JTextField getClientNameField() {
        return clientNameField;
    }

    public void setClientNameField(JTextField clientNameField) {
        this.clientNameField = clientNameField;
    }

    public JList getEventList() {
        return eventList;
    }

    public void setEventList(JList eventList) {
        this.eventList = eventList;
    }

}

