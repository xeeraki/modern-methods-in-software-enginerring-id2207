package view;

import javax.swing.*;

import controller.Controller;
import model.Client;

import java.util.List;
import java.awt.*;
import java.awt.event.*;


public class CreateEventView extends JFrame {

    private final Controller controller;


    JPanel panel = new JPanel();
    private JTextField eventName;
    private JTextField dateFrom;
    JButton SubmitButton = new JButton("Send");
    private JLabel lblDate;
    private JTextField budget;
    private JLabel lblBudget;
    private JTextPane description;
    private JLabel lblDescription;
    private JTextField dateTo;
    private JLabel lblDateTo;
    private JList clientList;



    public CreateEventView(Controller controller) {
        super("SEP Event Registration");
        setSize(800, 600);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        setLocation(xPos, yPos);
        panel.setLayout(null);

        this.controller = controller;


        getContentPane().add(panel);

        eventName = new JTextField();
        eventName.setBounds(164, 30, 114, 19);
        panel.add(eventName);
        eventName.setColumns(10);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(47, 32, 70, 15);
        panel.add(lblName);

        dateFrom = new JTextField();
        dateFrom.setBounds(164, 76, 114, 19);
        panel.add(dateFrom);
        dateFrom.setColumns(10);

        lblDate = new JLabel("From");
        lblDate.setBounds(47, 78, 99, 15);
        panel.add(lblDate);

        budget = new JTextField();
        budget.setBounds(164, 145, 114, 19);
        panel.add(budget);
        budget.setColumns(10);

        lblBudget = new JLabel("Budget");
        lblBudget.setBounds(47, 147, 70, 15);
        panel.add(lblBudget);

        description = new JTextPane();
        description.setBounds(159, 192, 119, 88);
        panel.add(description);

        lblDescription = new JLabel("Description");
        lblDescription.setBounds(47, 192, 99, 15);
        panel.add(lblDescription);


        JLabel lblClient = new JLabel("Client");
        lblClient.setBounds(328, 32, 70, 15);
        panel.add(lblClient);


        SubmitButton.setBounds(233, 317, 117, 25);
        panel.add(SubmitButton);

        dateTo = new JTextField();
        dateTo.setBounds(164, 114, 114, 19);
        panel.add(dateTo);
        dateTo.setColumns(10);

        lblDateTo = new JLabel("To");
        lblDateTo.setBounds(47, 116, 70, 15);
        panel.add(lblDateTo);

        List<Client> client = controller.getClients();
        Client[] clients = client.toArray(new Client[client.size()]);

        clientList = new JList(clients);
        panel.add(clientList);
        clientList.setBounds(356, 59, 228, 167);
        JScrollPane pane = new JScrollPane();

        getContentPane().add(pane, BorderLayout.SOUTH);



        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        createEventListener(clientList);
    }

    public void createEventListener(JList clientList) {
        SubmitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String from = dateFrom.getText();
                String to = dateTo.getText();
                String description1 = description.getText();
                String name1 = eventName.getText();
                Client client1 = (Client) clientList.getSelectedValue();
                double budget1 = Double.parseDouble(budget.getText());
                //Status status1 = (Status)Status.getText();
                controller.createEventRequest(from, to, description1, name1, client1, budget1);
            }
        });
    }
}
