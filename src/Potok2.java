import java.util.Timer;
import java.util.TimerTask;

public class Potok2 implements Runnable {
    int i = 1;
        @Override
        public void run() {
            System.out.println("Начинаем поток обновлений...");
            while (true) {
                if (i>0) {
                    try {
                        obnovitChat();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Ошибка обновления чата!");
                    }
                    System.out.println("Обновление чата...");
                }

                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Ошибка \"заспания\" потока!");
                }
            }
            }


        private void obnovitChat() throws InterruptedException {

        }


}
