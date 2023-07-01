package hr.algebra.dogsapi;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import java.util.ArrayList;
import java.util.List;

@EnableJms
@Configuration
public class ActiveMQConfig {
    //String BROKER_URL = "tcp://localhost:32774";
    String brokerUrl = "tcp://localhost:32768";
    @Value("${spring.activemq.user}")
    String brokerUsername;
    @Value("${spring.activemq.password}")
    String brokerPassword;
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setPassword(brokerUsername);
        connectionFactory.setUserName(brokerPassword);

        // Whitelist trusted packages
        List<String> trustedPackages=new ArrayList<>();
        trustedPackages.add("hr.algebra.dogsapi");
        trustedPackages.add("hr.algebra.dogsapi.controller");

        connectionFactory.setTrustedPackages(trustedPackages);
        // Ensure setTrustAllPackages is not set to true
        connectionFactory.setTrustAllPackages(false);

        return connectionFactory;
    }
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName("queue1");
        return template;
    }
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("1-1");
        return factory;
    }
}