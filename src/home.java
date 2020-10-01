import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class home extends JFrame implements ActionListener {
    JButton b1,b2;
    public home(){

        b1=new JButton("Login");
        b2=new JButton("Signup");
        JPanel ok = new JPanel();
        ok.setLayout(new GridLayout(2,1));
        ok.add(b1);
        ok.add(b2);
        add(ok);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
        setSize(200,200);
        setLayout(new FlowLayout());
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            new Signupgui();
            System.out.println("ok");
            dispose();
        }
        else{
            new Logingui();
            dispose();
        }
    }
}
