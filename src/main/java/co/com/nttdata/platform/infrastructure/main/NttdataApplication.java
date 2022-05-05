package co.com.nttdata.platform.infrastructure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import co.com.nttdata.platform.modules.common.MessagesUtil;


@SpringBootApplication(scanBasePackages = { "co.com.nttdata.platform.infrastructure", "co.com.nttdata.platform.modules",
"co.com.nttdata.platform.crosscutting" })
public class NttdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttdataApplication.class, args);
	}

	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("properties/manager-messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public MessagesUtil messagesUtil() {
		return new MessagesUtil();
	}		
	
}
