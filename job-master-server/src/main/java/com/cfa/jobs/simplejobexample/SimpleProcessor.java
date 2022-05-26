package com.cfa.jobs.simplejobexample;

import com.cfa.objects.letter.Letter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SimpleProcessor implements ItemProcessor<List<String>, List<String>> {
    private List<String> strings = new ArrayList<>();
    @Override
    public List<String> process(List<String> letters) throws Exception {
        List<String> tempList = new ArrayList<>();
        for (String s : letters) {
            String tempLetter = s;
            tempLetter.toUpperCase();
            tempList.add(tempLetter);
        }
        return tempList;
    }
}
