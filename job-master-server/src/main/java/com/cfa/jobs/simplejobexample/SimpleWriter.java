package com.cfa.jobs.simplejobexample;


import com.cfa.objects.letter.Letter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@RequiredArgsConstructor
public class SimpleWriter implements ItemWriter<List<String>> {
   /* @Override
    public void write(List<String> list) throws Exception {
        for(String s : list){
            System.out.println(s);
        }
    }*/

    @Override
    public void write(List<? extends List<String>> list) throws Exception {
        for(List<String> a : list){
            System.out.println(a);
        }
    }
}
