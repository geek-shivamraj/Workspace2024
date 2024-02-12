package com.srvcode.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/*
    Internationalization example
 */

@RestController
public class InternationalizationDemo {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/good-morning")
    public String goodmorning() {
        /*
            'en' - English (Good Morning)
            'nl' - Dutch (Goedemorgen)
            'fr' - French (Bonjour)
            'de' - Deutsch (Guten Morgen)
         */
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",
                null, "Default Message", locale);
    }

}
