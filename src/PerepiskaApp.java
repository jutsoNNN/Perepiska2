public class PerepiskaApp {

    public static void main(String[] args){
        OknoChata ok = new OknoChata();
        ChatController cc = new ChatController("1") ;
        cc.dobavitSoobsch("Text example");
        ok.setVisible(true);
        Potok2 p2 = new Potok2();
        p2.run();
    }

}
