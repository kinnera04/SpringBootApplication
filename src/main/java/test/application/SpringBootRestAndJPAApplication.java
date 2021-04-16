package test.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import test.application.model.User;
import test.application.model.UserAddress;
import test.application.util.UserType;

@SpringBootApplication
@EnableJms
public class SpringBootRestAndJPAApplication {

		
	@Bean
	  public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
	                          DefaultJmsListenerContainerFactoryConfigurer configurer) {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    // This provides all boot's default to this factory, including the message converter
	    configurer.configure(factory, connectionFactory);
	    return factory;
	  }
	
	@Bean // Serialize message content to json using TextMessage
	  public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_type");
	    return converter;
	  }

	public static void main(String[] args) {
ConfigurableApplicationContext context = SpringApplication.run(SpringBootRestAndJPAApplication.class, args);
		
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		for(User user :createUsers())
	    jmsTemplate.convertAndSend("sendingUsers", user);
	}

	
	private static List<User> createUsers() {
		List<User> users = new ArrayList<>();
		Date date = new Date();
		UserAddress address = new UserAddress("test1Street","test1State",
				"test1City","test1ZipCode");
		UserAddress address1 = new UserAddress("test2Street","test2State",
				"test2City","test2ZipCode");
		User user = new User("test1","test1","test1@gmail.com",
				date,date,UserType.STUDENT,address);

		User user1 = new User("test2","test2","test2@gmail.com",
				date,date,UserType.EMPLOYEE,address1);

		users.add(user);
		users.add(user1);
		return users;
	}

}
