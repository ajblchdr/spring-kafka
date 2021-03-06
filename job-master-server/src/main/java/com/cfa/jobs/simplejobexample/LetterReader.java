package com.cfa.jobs.simplejobexample;

import com.cfa.objects.letter.Letter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@RequiredArgsConstructor
public class LetterReader implements ItemReader<String> {

    private String path = "test.txt";
    private Iterator<String> letters;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return letters.hasNext() ? letters.next() : null;
    }
}
