import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoChata extends JDialog {

    ChatController cvc = new ChatController("123");

    class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //cvc.dobavitSoobsch("");
            System.out.println("Нажатие кнопки.");
        }
    }

    public OknoChata(){
        JPanel glavnOkno = new JPanel();
        JButton b1 = new JButton("Отправить");
        JLabel nazvanieChata = new JLabel("Chat name");
        JTextArea chatSms = new JTextArea();
        ActionListener actionListener = new TestActionListener();
        b1.addActionListener(actionListener);
        chatSms.setEditable(false);
        chatSms.setVisible(true);
        glavnOkno.add(nazvanieChata);
        glavnOkno.add(chatSms);
        glavnOkno.add(b1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        glavnOkno.setSize(800, 600);
        setContentPane(glavnOkno);
        //
        chatSms.append("Тут будут сообщения чата");
        chatSms.setCaretPosition(chatSms.getDocument().getLength());
    }

    public static void main(String[] args){
        OknoChata o1 = new OknoChata();
        o1.setVisible(true);
    }
}
