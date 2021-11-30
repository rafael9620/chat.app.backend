package chat.app.backend.controllers;

import chat.app.backend.models.MyMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatCrontroller {

    @MessageMapping("/message")
    @SendTo("/chat/message") // Con esta anotacion notificamos a los clientes de la existencia de un mensaje
    public MyMessage getMessage(MyMessage myMessage){
        myMessage.setDate(new Date().getTime());
        if (myMessage.getTypes().equals("NEW_USER")){
            myMessage.setText(" - Nuevo usuario conectado");
        }
        //myMessage.setText(" - Nuevo usuario conectado2");
        return myMessage;
    }
}

