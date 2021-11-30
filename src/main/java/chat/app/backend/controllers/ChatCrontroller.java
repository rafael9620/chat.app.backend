package chat.app.backend.controllers;

import chat.app.backend.models.MyMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

@Controller
public class ChatCrontroller {

    private String[] colors = {"red", "blue", "yellow", "green", "orange", "purple"};

    @MessageMapping("/message")
    @SendTo("/chat/message") // Con esta anotacion notificamos a los clientes de la existencia de un mensaje
    public MyMessage getMessage(MyMessage myMessage){
        myMessage.setDate(new Date().getTime());
        if (myMessage.getTypes().equals("NEW_USER")){
            myMessage.setColor(colors[new Random().nextInt(colors.length)]);
            myMessage.setText(" - Nuevo usuario conectado");
        }
        //myMessage.setText(" - Nuevo usuario conectado2");
        return myMessage;
    }


    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String comprobarEstado(String username) {
        return username.concat(" esta escribiendo...");
    }
}

