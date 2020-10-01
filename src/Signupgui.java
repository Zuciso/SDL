import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Signupgui extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JButton b1;
    public Signupgui() {

        t1=new JTextField("UserName");
        t2=new JTextField("PassWord");
        t3=new JTextField("Mobile Number");
        t4=new JTextField("Address");
        b1=new JButton("Submit");

        JPanel j = new JPanel();
        j.setLayout(new GridLayout(5,1));
        j.add(t1);
        j.add(t2);
        j.add(t3);
        j.add(t4);
        j.add(b1);
        add(j);
        b1.addActionListener(this);
        setVisible(true);
        setSize(200, 200);
        setLayout(new FlowLayout());
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}