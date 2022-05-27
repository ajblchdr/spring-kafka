package com.cfa.jobs.simplejobexample;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.integration.chunk.RemoteChunkingWorkerBuilder;
import org.springframework.batch.integration.config.annotation.EnableBatchIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;

@Configuration
@EnableBatchIntegration
@EnableBatchProcessing
public class WorkerConfiguration {
    @Autowired
    private RemoteChunkingWorkerBuilder workerBuilder;
    @Bean
    public IntegrationFlow workerFlow() {
        ChannelConfig channelConfig = new ChannelConfig();

        return this.workerBuilder
                .itemProcessor(new SimpleProcessor())
                .itemWriter(new SimpleWriter())
                .outputChannel(channelConfig.requests())
                .inputChannel(channelConfig.replies())
                .build();
    }
}
