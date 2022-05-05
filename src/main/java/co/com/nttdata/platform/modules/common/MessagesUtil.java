package co.com.nttdata.platform.modules.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class MessagesUtil {

	@Autowired
	private MessageSource messageSource;

	public String getMessage(String key) {
		return messageSource.getMessage(key, null, Locale.getDefault());
	}

	public String getMessage(String key, String[] args) {
		return messageSource.getMessage(key, args, Locale.getDefault());
	}

}
