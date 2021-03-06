package view;
import javax.swing.*;

import controller.Controller;
import model.User;

import java.awt.*;
import java.awt.event.*;

    public class MainView extends JFrame {

        private final Controller controller;
        private  User user;
        private final LoginView loginView;

        JPanel panel = new JPanel();
        ListClientView listClientsView;

        public ListClientView getListClientsView() {
            return listClientsView;
        }

        public void setListClientsView(ListClientView listClientsView) {
            this.listClientsView = listClientsView;
        }

        JButton btnCreateEvent = new JButton("Create event");
        JButton btnCreateClient = new JButton("Create client");
        JButton btnListEvent = new JButton("List Events");
        JButton btnListStaff = new JButton("List Staff");
        private final JButton btnLogout = new JButton("Logout");
        JButton btnCreateStaff = new JButton("Create Staff");
        private final JButton btnListClients = new JButton("List Clients");
        private final JButton btnCreateTask = new JButton("Create Task");
        private final JButton btnListTasks = new JButton("List Tasks");
        public JButton getBtnListClients() {
            return btnListClients;
        }

        JButton btnCreateResource = new JButton("Create Resource");
        JButton btnListResource = new JButton("List Resource");

        public MainView(User currentUser, Controller controller, LoginView login) {

            super("SEP main page");
            setSize(800, 600);
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension dim = tk.getScreenSize();
            int xPos = (dim.width / 2) - (this.getWidth() / 2);
            int yPos = (dim.height / 2) - (this.getHeight() / 2);
            setLocation(xPos, yPos);
            panel.setLayout(null);
            user = currentUser;
            this.controller = controller;
            this.loginView = login;
            btnCreateEvent.setVisible(false);

            getContentPane().add(panel);

            btnCreateEvent.setVisible(false);
            btnCreateClient.setVisible(false);
            btnListEvent.setVisible(false);
            btnListStaff.setVisible(false);
            btnCreateStaff.setVisible(false);
            btnListClients.setVisible(false);
            btnCreateTask.setVisible(false);
            btnCreateResource.setVisible(false);
            btnListResource.setVisible(false);
            btnListTasks.setVisible(false);

            switch(currentUser.getPosition()){
                case CustomerService:
                    btnCreateEvent.setVisible(true);
                    break;
                case SeniorCustomerService:
                    btnListEvent.setVisible(true);
                    btnCreateClient.setVisible(true);
                    btnListClients.setVisible(true);
                    break;
                case FinancialManager:
                    btnListEvent.setVisible(true);
                    btnListResource.setVisible(true);
                    btnListClients.setVisible(true);
                    break;
                case AdministrationManager:
                    btnListEvent.setVisible(true);
                    btnListClients.setVisible(true);
                    break;
                case ProductionManager:
                    btnCreateTask.setVisible(true);
                    btnCreateStaff.setVisible(true);
                    btnCreateResource.setVisible(true);
                    btnListTasks.setVisible(true);
                    break;
                case ServiceManager:
                    btnCreateTask.setVisible(true);
                    btnCreateStaff.setVisible(true);
                    btnCreateResource.setVisible(true);
                    btnListTasks.setVisible(true);
                    break;
                case HR:
                    btnListStaff.setVisible(true);
                    break;
                case ServiceProductionStaff:

                    btnListTasks.setVisible(true);
                    break;

                case Chef:
                    btnListTasks.setVisible(true);
                    break;
                case AudioSpecialist:
                    btnListTasks.setVisible(true);
                    break;
                case Photographer:
                    btnListTasks.setVisible(true);
                    break;
                case Waitress:
                    btnListTasks.setVisible(true);
                    break;
            }




            btnCreateEvent.setBounds(12, 23, 157, 25);
            panel.add(btnCreateEvent);


            btnCreateClient.setBounds(12, 71, 157, 25);
            panel.add(btnCreateClient);


            btnListEvent.setBounds(12, 122, 157, 25);
            panel.add(btnListEvent);
            btnLogout.setBounds(450, 314, 117, 25);

            panel.add(btnLogout);
            btnListClients.setBounds(12, 169, 157, 25);

            panel.add(btnListClients);
            btnCreateTask.setBounds(12, 213, 150, 25);

            panel.add(btnCreateTask);
            btnListTasks.setBounds(234, 23, 150, 25);

            panel.add(btnListTasks);


            btnCreateStaff.setBounds(234, 71, 150, 25);
            panel.add(btnCreateStaff);


            btnListStaff.setBounds(237, 122, 147, 25);
            panel.add(btnListStaff);

            btnCreateResource.setBounds(234, 169, 150, 25);
            panel.add(btnCreateResource);

            btnListResource.setBounds(234, 213, 150, 25);
            panel.add(btnListResource);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

            createEventListener();
            createClientListener();
            listEventsListener();
            listClientsListener();
            createTaskListener();
            listTasksListener();
            createStaffListener();
            createResourceListener();
            listStaffListener();
            listResourceListener();
            logoutListener();
        }

        public void createStaffListener(){
            btnCreateStaff.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CreateStaffRequest frame = new CreateStaffRequest(controller,user);
                }
            });
        }

        public void createResourceListener(){
            btnCreateResource.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CreateResourceRequest frame = new CreateResourceRequest(controller,user);
                }
            });
        }

        public void listStaffListener(){
            btnListStaff.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ListStaffRequest frame = new ListStaffRequest(controller,user);
                }
            });
        }

        public void listResourceListener(){
            btnListResource.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ListResourceRequest frame = new ListResourceRequest(controller,user);
                }
            });
        }

        public void createTaskListener(){
            btnCreateTask.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CreateTaskView frame = new CreateTaskView(controller,user);
                }
            });
        }

        public void listClientsListener(){
            btnListClients.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    listClientsView = new ListClientView(controller);
                }
            });
        }

        public void createEventListener(){
            btnCreateEvent.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CreateEventView frame = new CreateEventView(controller);
                }
            });
        }

        public void createClientListener(){
            btnCreateClient.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CreateClientView frame = new CreateClientView(controller);
                }
            });
        }

        public void listEventsListener(){
            btnListEvent.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new ListUpdaterView(controller, user);
                }
            });
        }

        public void listTasksListener(){
            btnListTasks.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ListTaskView frame = new ListTaskView(controller, user);
                }
            });
        }

        public void logoutListener(){
            btnLogout.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    user = null;
                    loginView.setVisible(true);
                    dispose();
                }
            });
        }

        public User getUser() {
            return user;
        }
    }
