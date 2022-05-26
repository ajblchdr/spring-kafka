package com.cfa.jobs.simplejobexample;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class SimpleReader implements ItemReader<List<String>> {
    private List<String> strings = new ArrayList<String>();
    @Override
    public List<String> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        strings.add("hello");
        strings.add("world");
        strings.add("it's me mario");
        //flat item reader
        return strings;
    }
}
