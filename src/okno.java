import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class okno extends JDialog {
    private JPanel contentPane;;
    private JButton buttonOtpravit;
    private JTextField poleVvodaSoobsch;
    private JLabel chatName;
    private JTextArea soobschVivod;




    public okno () {
        setSize(800,600);
        setContentPane(contentPane);
        setModal(true);



        buttonOtpravit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onCancel() {

        dispose();
    }

    public static void main(String[] args) {
        okno dialog = new okno();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
