package chat2.service;

import chat2.model.GCMPushEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @KafkaListener(topics = "${kafka.topic-name.chat2}"
            , groupId = "${kafka.my.push.topic.group.name}"
            , containerFactory = "pushEntityKafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload GCMPushEntity gcmPushEntity,
                                  @Headers MessageHeaders messageHeaders) {

        // GCM으로 해당 데이터를 전달하는 로직 ....

        System.out.println(
                "Received Message: " + gcmPushEntity.toString() +
                        " headers: " + messageHeaders);
    }
}
