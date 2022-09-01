import javax.swing.*;
import java.awt.*;

public class PwWindow{

    static JButton add;
    static JFrame jf;
    static JPanel jp;
    static JTextField name;
    static JTextField pw;
    public PwWindow(){
        name = new JTextField("Name",10);
        pw = new JTextField("Passwort",10);
        jp = new JPanel();
        jf = new JFrame();
        add = new JButton("Submit");

        jf.setSize(300,200);
        jf.setLocationRelativeTo(null);
        jf.setUndecorated(true);

        add.addActionListener(new Action());

        name.setBorder(BorderFactory.createLoweredBevelBorder());
        pw.setBorder(BorderFactory.createLoweredBevelBorder());
        name.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        jp.add(name);
        jp.add(pw);
        jp.add(add);

        jf.add(jp);
        jf.setVisible(false);
    }


}