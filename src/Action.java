import javax.swing.*;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener {
Manager m = new Manager();

boolean pww = false;
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Window.search){
            
            System.out.println("Searching for: "+Window.jt.getText());
            System.out.println("Password: "+m.getPasswort(Window.jt.getText()));

            Window.jl = new JLabel(Window.jt.getText()+": "+m.getPasswort(Window.jt.getText()));

        }

        if(e.getSource()==Window.newEntry){
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
