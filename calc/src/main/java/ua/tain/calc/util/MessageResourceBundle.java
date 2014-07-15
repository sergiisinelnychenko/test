package ua.tain.calc.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Simple message resource bundle, number of methods for the convenient usage
 * @author polar
 *
 */
@Component
public class MessageResourceBundle {

	/**
	 * Message source autowired by Spring. References .properties file(s)
	 */
    @Autowired 
    private MessageSource messageSource;

    /**
     * Returns the message from message source that corresponds to specified {@code code} using default locale.
     * @param code the code of message to be returned
     * @return the message from message source
     */
    public String getMessage(String code) {
        return getMessage(code, Locale.getDefault(), new Object[]{});
    }
    
    /**
     * Returns the message from message source that corresponds to specified {@code code} using default locale.
     * @param code the code of message to be returned
     * @param args the argument that will be put to place holders in returned message
     * @return the message from message source
     */
    public String getMessage(String code, Object... args) {
    	return getMessage(code, Locale.getDefault(), args);
    }
    
    /**
     * Returns the message from message source that corresponds to specified {@code code} using specified
     * {@code locale}.
     * @param code the code of message to be returned
     * @param args the argument that will be put to place holders in returned message
     * @param locale the locale of 
     * @return the message from message source
     */
    public String getMessage(String code, Locale locale, Object... args) {
        Assert.state(messageSource != null);
        Assert.notNull(code);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return messageSource.getMessage(code, args, code, locale);
    }
}
