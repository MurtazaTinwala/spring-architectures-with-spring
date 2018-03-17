package com.packtpub.callcenterapp;

import com.packtpub.callcenterapp.transfer.EventNotificationChannel;
import com.packtpub.transfermoneyapp.domain.TransferMoneyDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

@Slf4j
@EnableBinding(EventNotificationChannel.class)
@SpringBootApplication
public class CallCenterAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallCenterAppApplication.class, args);
    }


    @Bean
    IntegrationFlow integrationFlow(EventNotificationChannel eventNotificationChannel) {
        return IntegrationFlows.from(eventNotificationChannel.subscriptionOnMoneyTransferredChannel()).
                handle(TransferMoneyDetails.class, (payload, headers) -> {
                    log.info("Verifying if we have to offer investment opportunities to customer with id: " + payload.getCustomerId());
                    log.info("Transaction details: " + payload);
                    return null;
                }).get();
    }
}

