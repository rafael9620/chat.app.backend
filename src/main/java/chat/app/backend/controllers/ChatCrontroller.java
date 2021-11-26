package chat.app.backend.controllers;

import chat.app.backend.models.MyMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatCrontroller {

    @MessageMapping
    @SendTo("/chat/message") // Con esta anotacion notificamos a los clientes de la existencia de un mensaje
    public MyMessage getMessage(MyMessage myMessage){
        myMessage.setDate(new Date().getTime());
        myMessage.setText("Recibido por el Broker" + myMessage.getText());

        return myMessage;
    }
}

