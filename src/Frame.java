import javax.swing.*;

public class Frame{

    static JFrame jf;
    static JLabel jl;
    static JPanel jp;
    static JTextField jt;
    static JButton search, newEntry;

    String[] s = {"Daniel"};
    JList l = new JList(s);
    public Frame(){

        create();

    }


    public static void create(){
        jf = new JFrame();
        jp = new JPanel();
        jt = new JTextField(15);
        search = new JButton("Search");
        newEntry = new JButton("+");


        jf.setSize(500,500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jt.setBorder(BorderFactory.createLoweredBevelBorder());
        jt.setSize(100,50);

        search.setBounds(0,0,50,50);
        search.addActionListener(new Action());
        newEntry.addActionListener(new Action());



        jp.add(jt);
        jp.add(search);
        jp.add(newEntry);

        jf.add(jp);

        jf.setVisible(true);

    }

}
