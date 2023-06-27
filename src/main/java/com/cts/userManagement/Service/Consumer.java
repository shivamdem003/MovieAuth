package com.cts.userManagement.Service;

import com.cts.userManagement.Model.MovieDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Consumer {

//    @KafkaListener(topics ={"movieApp"},containerFactory="kafkaListenerContainerFactory")
//    public void consumeMovieData(@Payload List<MovieDto> movielist){
//        System.out.printf("New Released Movie Details %n Movie Name: %s",movielist);
//    }

}
