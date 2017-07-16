package persistentqueue.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.math.BigInteger;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    public class PersistentQueueHandshakeHandler extends DefaultHandshakeHandler {

        private SecureRandom random = new SecureRandom();

        @Override
        protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {

            return new UsernamePasswordAuthenticationToken(getSecureSessionId(), null);
        }

        private String getSecureSessionId(){

            return new BigInteger(130, random).toString(32);
        }
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/persistent-queue").setHandshakeHandler(new PersistentQueueHandshakeHandler());
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.enableSimpleBroker("/private");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
