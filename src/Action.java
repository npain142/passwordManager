import javax.swing.*;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener {
Manager m = new Manager();

boolean pww = false;
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Frame.search){
            
            System.out.println("Searching for: "+Frame.jt.getText());
            System.out.println("Password: "+m.getPasswort(Frame.jt.getText()));

            Frame.jl = new JLabel(Frame.jt.getText()+": "+m.getPasswort(Frame.jt.getText()));

        }

        if(e.getSource()==Frame.newEntry){
            if(!pww){
            PwWindow pw = new PwWindow();
            pww = true;
            }

            PwWindow.jf.setVisible(true);

        }

        if(e.getSource() == PwWindow.add){

            m.addPasswort(PwWindow.name.getText(),PwWindow.pw.getText());

            PwWindow.jf.setVisible(false);

        }

    }

}
