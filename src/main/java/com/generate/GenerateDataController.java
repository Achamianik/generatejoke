package com.generate;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
@AllArgsConstructor
public class GenerateDataController {

    private KafkaTemplate<String, Joke> kafkaTemplate;

    @PostMapping("/{amountOfJokes}")
    public void generateJokes(@PathVariable int amountOfJokes) {
        for (int i = 0; i < amountOfJokes; i++) {
            Joke joke = Joke.generateRandomJoke(i);
            kafkaTemplate.send(new ProducerRecord<>("joke-feed", joke.getUuid(), joke));
        }
    }

}
