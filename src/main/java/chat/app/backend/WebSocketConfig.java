package chat.app.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker  //Habilita el servidor web socker de Sping Boot
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-websocket")
        .setAllowedOrigins("http://localhost:4200")
        .withSockJS(); //Ruta del servidor en Spring Boot

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/chat/"); // prefijo para los nombres de los eventos
        registry.setApplicationDestinationPrefixes("/app");
    }
}
