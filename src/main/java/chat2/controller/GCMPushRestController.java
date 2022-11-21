package chat2.controller;

import chat2.model.GCMPushEntity;
import chat2.service.KafkaMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GCMPushRestController {

    @Autowired
    private KafkaMessageSender kafkaMessageSender;

    @PostMapping("/push")
    public String push(@RequestBody GCMPushEntity gcmPushEntity) {
        kafkaMessageSender.send(gcmPushEntity);
        return "success";
    }

}
