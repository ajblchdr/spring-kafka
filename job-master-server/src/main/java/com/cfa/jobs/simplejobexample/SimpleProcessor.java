package com.cfa.jobs.simplejobexample;

import com.cfa.objects.letter.Letter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SimpleProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String letters) throws Exception {
        return  letters.toUpperCase();
    }
}
