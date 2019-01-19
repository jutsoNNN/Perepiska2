

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class ChatController {
    Chat chat;
    File chatFile;

    public ChatController(String nazvanie) {
        chatFile = new File("C:\\Users\\Kageyama\\IdeaProjects\\"+ nazvanie);
        //Если чат существует, то открываем его и загружаем сообщения
        if((chatFile.exists())&&(!chatFile.isDirectory())){
            //todo загрузить файл в чат
            obnovitChat();
        }else{
            //Иначе, создаем новый чат
            chat = new Chat(nazvanie,"А.В.",new Date());
            //todo сохранить файл чат
            sohranitChat();
        }
    }

    public void sohranitChat(){
        Gson gson = new Gson();
        String chatJson = gson.toJson(chat);
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(chatFile.getAbsolutePath());
            bw = new BufferedWriter(fw);
            bw.write(chatJson);
            bw.flush();
            bw.close();
            fw.close();
        }
        catch ( IOException e)
        {
            e.printStackTrace();
        }
    }

    public void obnovitChat(){
        try {
            byte[] encoded = Files.readAllBytes(
                    Paths.get(chatFile.getAbsolutePath()));
            String chatJson = new String(encoded, StandardCharsets.UTF_8);
            Gson gson = new Gson();
            chat = gson.fromJson(chatJson,Chat.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        chat.getSoosbchenia();

    }



    public void dobavitSoobsch(String soobsch){
        obnovitChat();
        if(chat.getSoosbchenia()==null){
            chat.setSoosbchenia(new ArrayList<Soobsch>());
        }
        chat.getSoosbchenia().add(new Soobsch(new Date(), soobsch, "Avtor"));
        sohranitChat();
    }

    public void otpravitSoobsch(){
        obnovitChat();
        //do something more
    }



}
