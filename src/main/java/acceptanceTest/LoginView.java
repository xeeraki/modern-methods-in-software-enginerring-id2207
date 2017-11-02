package acceptanceTest;

import javax.swing.*;

import controller.Controller;
import model.EventRequest;
import model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginView extends JFrame {

    public static void main(String[] args) {
        new LoginView();
    }

    JButton btnLogin = new JButton("Login");
    JButton btnCancel = new JButton("Cancel");
    JPanel jpanel = new JPanel();
    JTextField userText = new JTextField(15);

    JPasswordField userPass = new JPasswordField(15);
    JLabel jlabel = new JLabel();
    JLabel jlabel2 = new JLabel();
    MainView regView;

    public LoginView() {
        super("Login with username and userPass");
        View();
        Controller controller = new Controller();
        getContentPane().add(jpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        initView(controller,this);

    }

    private void View() {
        setSize(600, 400);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        setLocation(xPos, yPos);
        jpanel.setLayout(null);


        userText.setBounds(150, 30, 200, 20);
        userPass.setBounds(150, 65, 200, 20);
        btnLogin.setBounds(150, 100, 90, 20);
        btnCancel.setBounds(250, 100, 90, 20);
        jlabel.setBounds(70, 30, 150, 20);
        jlabel.setText("username");
        jlabel2.setText("userPass");
        jlabel2.setBounds(70, 65, 150, 20);
        jpanel.add(btnLogin);
        jpanel.add(userText);
        jpanel.add(userPass);
        jpanel.add(jlabel);
        jpanel.add(jlabel2);
        jpanel.add(btnCancel);
    }


    public void initView(Controller controller, LoginView login) {
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String username = userText.getText();
                String password = LoginView.this.userPass.getText();

                User currentUser = controller.login(username, password);

                if (currentUser != null) {
                    regView = new MainView(currentUser, controller, login);
                    login.setVisible(false);
                    regView.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null, "Wrong Password or Username");
                    userText.setText("");
                    LoginView.this.userPass.setText("");
                    userText.requestFocus();
                }

            }
        });
    }

    public JButton getLoginButton() {
        return btnLogin;
    }

    public JTextField getUserField() {
        return userText;
    }

    public JPasswordField getPassField() {
        return userPass;
    }

    public MainView getMainView() {
        return regView;
    }
}