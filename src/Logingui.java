import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Logingui extends JFrame implements ActionListener {
    JTextField t1,t2;
    JButton b1;
    public Logingui(){
        t1=new JTextField("UserName");
        t2=new JTextField("PassWord");
        b1=new JButton("Submit");

        JPanel j = new JPanel();
        j.setLayout(new GridLayout(3,1));
        j.add(t1);
        j.add(t2);
        j.add(b1);
        add(j);
        setVisible(true);
        b1.addActionListener(this);
        setSize(200, 200);
        setLayout(new FlowLayout());
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

