package com.example.demo.formatter;

import com.example.demo.model.Nation;
import com.example.demo.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class NationFormatter implements Formatter<Nation> {
    @Autowired
    private NationService nationService;

    public NationFormatter() {
    }

    public NationFormatter(NationService nationService) {
        this.nationService = nationService;
    }

    @Override
    public Nation parse(String text, Locale locale) throws ParseException {
        return nationService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Nation object, Locale locale) {
        return null;
    }
}
