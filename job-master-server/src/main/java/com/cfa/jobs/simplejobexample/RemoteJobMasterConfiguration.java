package com.cfa.jobs.simplejobexample;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.integration.chunk.RemoteChunkingManagerStepBuilderFactory;
import org.springframework.batch.integration.config.annotation.EnableBatchIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@EnableBatchIntegration
@EnableBatchProcessing
public class RemoteJobMasterConfiguration {
    @Autowired
    private RemoteChunkingManagerStepBuilderFactory managerStepBuilderFactory;
    @Bean
    public Step managerStep() {
        LetterReader letterReader = new LetterReader();
        letterReader.setLetters(initData().iterator());
        ChannelConfig channelConfig = new ChannelConfig();
        return this.managerStepBuilderFactory.get("masterStep")
                .chunk(10)
                .reader(letterReader)
                .outputChannel(channelConfig.requests()) // requests sent to workers
                .inputChannel(channelConfig.replies())
                .build();// replies received from workers .build();
    }

    public List<String> initData(){
        List<String> result = new ArrayList<>();
        try {
            File myObj = new File("test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result.add(data);
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result;
    }
}