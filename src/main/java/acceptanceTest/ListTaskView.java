package acceptanceTest;

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
import model.Position;
import model.Task;
import model.User;

public class ListTaskView extends JFrame {

    private final Controller controller;


    JPanel panel = new JPanel();
    JButton updateButton = new JButton("Update");
    private JTextField originalBudgetField;
    private JTextField additionalBudgetField;
    private JLabel lblAdditionalBudget;
    private JTextPane descriptionField;
    private JLabel lblDescription;
    private JList tasksList;
    private JTextField expectedPlanField;
    private int currentEventId;
    private User currentUser;


    public ListTaskView(Controller controller, User currentUser) {
        super("SEP Task List View");
        this.controller = controller;
        this.currentUser = currentUser;
        List<Task> taskToDisplay = ListTasks(controller, currentUser);
        Task[] tasks = taskToDisplay.toArray(new Task[taskToDisplay.size()]);

        //add tasks to the J List which later queues in task list
        tasksList = new JList(tasks);
        panel.add(tasksList);
        tasksList.setBounds(356, 59, 228, 167);
        JScrollPane pane = new JScrollPane();

        getContentPane().add(pane, BorderLayout.NORTH);


        JLabel lblPlan = new JLabel("Expected plan");
        lblPlan.setBounds(12, 184, 105, 15);
        panel.add(lblPlan);

        expectedPlanField = new JTextField();
        expectedPlanField.setBounds(164, 185, 119, 93);
        panel.add(expectedPlanField);
        expectedPlanField.setColumns(10);


        updateButton.setBounds(237, 314, 117, 25);
        panel.add(updateButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addListMouseListener(tasksList);
        updateButton.setVisible(false);


        updateEventListener();
        setVisible(true);


    }

    private List<Task> ListTasks(Controller controller, User currentUser) {
        setSize(800, 600);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        setLocation(xPos, yPos);
        panel.setLayout(null);


        getContentPane().add(panel);

        originalBudgetField = new JTextField();
        originalBudgetField.setBounds(164, 10, 114, 19);
        panel.add(originalBudgetField);
        originalBudgetField.setColumns(10);

        JLabel lblOriginalBudget = new JLabel("Budget");
        lblOriginalBudget.setBounds(12, 12, 117, 15);
        panel.add(lblOriginalBudget);

        additionalBudgetField = new JTextField();
        additionalBudgetField.setBounds(164, 41, 114, 19);
        panel.add(additionalBudgetField);
        additionalBudgetField.setColumns(10);

        lblAdditionalBudget = new JLabel("Additional Budget");
        lblAdditionalBudget.setBounds(12, 39, 134, 15);
        panel.add(lblAdditionalBudget);

        descriptionField = new JTextPane();
        descriptionField.setBounds(164, 85, 119, 88);
        panel.add(descriptionField);

        lblDescription = new JLabel("Description");
        lblDescription.setBounds(12, 84, 134, 15);
        panel.add(lblDescription);


        JLabel tasksLabel = new JLabel("Tasks");
        tasksLabel.setBounds(328, 32, 70, 15);
        panel.add(tasksLabel);

        List<Task> allTasks = controller.getTasks();
        List<Task> taskToDisplay = new ArrayList<>();

        for (Task task : allTasks) {
            if ((currentUser.getPosition() == Position.ProductionManager || currentUser.getPosition() == Position.ServiceManager) &&
                    task.getTeam().getManager().getPosition() == currentUser.getPosition()) {
                taskToDisplay.add(task);
            } else {
                if (task.getTeam().getMembers().contains(currentUser)) taskToDisplay.add(task);
            }

        }
        return taskToDisplay;
    }

    public void addListMouseListener(JList list) {
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                Task task = (Task) list.getModel().getElementAt(index);
                originalBudgetField.setText(String.valueOf(task.getBudget()));
                additionalBudgetField.setText(String.valueOf(task.getAdditionalBudget()));
                descriptionField.setText(task.getDescription());
                expectedPlanField.setText(task.getExpectedPlan());

                if (!(currentUser.getPosition() == Position.ServiceManager || currentUser.getPosition() == Position.ProductionManager)) {
                    updateButton.setVisible(true);
                }


            }

        });
    }


    public void updateEventListener() {
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double additionalBudget = Double.valueOf(additionalBudgetField.getText());
                String expectedPlan = expectedPlanField.getText();
                Task task = (Task) tasksList.getSelectedValue();
                controller.updateTask(additionalBudget, expectedPlan, task);

            }
        });
    }


}
